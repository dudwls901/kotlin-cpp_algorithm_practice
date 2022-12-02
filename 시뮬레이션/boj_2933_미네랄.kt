//https://www.acmicpc.net/problem/2933
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

lateinit var map: Array<CharArray>
lateinit var clusterMap: Array<IntArray>
val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0)
)

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, m) = getIntList()
    map = Array(n) { br.readLine().toCharArray() }
    getInt()
    //solve
    getIntList().forEachIndexed { idx, h ->
        shoot(idx, n - h, n, m)
    }
    //output
    for(r in 0 until n){
        for(c in 0 until m){
            write("${map[r][c]}")
        }
        write("\n")
    }
    close()
}

fun shoot(idx: Int, h: Int, n: Int, m: Int) {
    when (idx and 1 == 0) {
        true -> leftShoot(h, m)
        false -> rightShoot(h, m)
    }
    moveMap(n, m)
}

fun moveMap(n: Int, m: Int) {
    clusterMap = Array(n){ IntArray(m) }
    //seperate cluster
    for (c in 0 until m) {
        if (map[n - 1][c] == 'x' && clusterMap[n - 1][c] != 1) {
            seperate(n - 1, c, n, m)
        }
    }

    var num = 2
    for(r in 0 until n) {
        for (c in 0 until m) {
            if (map[r][c] == 'x' && clusterMap[r][c] == 0) {
                groupingCluster(r, c, num++, n, m)
            }
        }
    }

    while(--num>1){
        while (true){
            if(downMap(num, n,m)) break
        }
    }

    for(r in 0 until n){
        for(c in 0 until m){
            map[r][c] = if(clusterMap[r][c]==0)'.' else 'x'
        }
    }

}

fun groupingCluster(sr: Int, sc: Int, num: Int, n: Int, m: Int) {
    val q: Queue<Pair<Int,Int>> = LinkedList()
    q.add(Pair(sr,sc))
    clusterMap[sr][sc] = num
    while (q.isNotEmpty()){
        val (cr,cc) = q.poll()
        for(i in 0 until 4){
            val nr = cr + dir[i][0]
            val nc = cc + dir[i][1]
            if(nr !in 0 until n || nc !in 0 until m) continue
            if(clusterMap[nr][nc] == num) continue
            if(map[nr][nc] == '.') continue
            clusterMap[nr][nc] = num
            q.add(Pair(nr,nc))
        }
    }
}


fun seperate(sr: Int, sc: Int, n: Int, m: Int) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(sr,sc))
    clusterMap[sr][sc] = 1
    while (q.isNotEmpty()){
        val (cr,cc) = q.poll()
        for(i in 0 until 4){
            val nr = cr + dir[i][0]
            val nc = cc + dir[i][1]
            if(nr !in 0 until n || nc !in 0 until m) continue
            if(clusterMap[nr][nc]==1) continue
            if(map[nr][nc] =='.') continue
            clusterMap[nr][nc] = 1
            q.add(Pair(nr,nc))
        }
    }
}

fun downMap(num: Int, n: Int, m: Int): Boolean {
    for(r in 0 until n-1){
        for(c in 0 until m){
            if(clusterMap[r][c] == 2 &&clusterMap[r+1][c] ==1) return true
        }
    }
    for(r in n-1 downTo  0){
        for(c in 0 until  m){
            if(clusterMap[r][c] == num){
                if(r + 1 >= n ){
                  return true
                }else{
                    if(clusterMap[r+1][c] !=0){
                        return true
                    }else{
                        clusterMap[r][c] = 0
                        clusterMap[r+1][c] = num
                    }
                }
            }
        }
    }
    return false
}


fun rightShoot(h: Int, m: Int) {
    for (c in m - 1 downTo 0) {
        if (map[h][c] == 'x') {
            map[h][c] = '.'
            return
        }
    }
}

fun leftShoot(h: Int, m: Int) {
    for (c in 0 until m) {
        if (map[h][c] == 'x') {
            map[h][c] = '.'
            return
        }
    }
}
