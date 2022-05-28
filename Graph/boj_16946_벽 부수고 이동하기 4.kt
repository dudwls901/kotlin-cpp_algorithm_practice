//https://www.acmicpc.net/problem/16946
import java.util.*

val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var graph: Array<IntArray>
val group = Array(1000){IntArray(1000) }
val maxCntInGroup = IntArray(500001)

val dir = arrayOf(
    arrayOf(0,1),
    arrayOf(1,0),
    arrayOf(0,-1),
    arrayOf(-1,0)
)

//0들 그룹핑
fun bfs(r: Int, c: Int, num: Int, n: Int, m: Int) : Int{

    var cnt =1

    group[r][c] = num

    val q: Queue<Pair<Int,Int>> = LinkedList()
    q.add(Pair(r,c))

    while(q.isNotEmpty()){
        val (cr, cc) = q.poll()

        for(i in 0 until 4){
            val nr = cr + dir[i][0]
            val nc = cc + dir[i][1]

            if(nr !in 0 until n || nc !in 0 until m) continue
            if(graph[nr][nc]==1) continue
            if(group[nr][nc]>0) continue

            group[nr][nc] = num
            q.add(Pair(nr,nc))
            cnt++
        }
    }
    return cnt
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (n,m) = getIntList()
    graph = Array(n){ br.readLine().map { it.digitToInt() }.toIntArray() }

    //solve
    //그룹별 카운트 세어놓기
    var num=1
    for(r in 0 until n){
        for(c in 0 until m){
            if(graph[r][c]==1) continue
            if(group[r][c] >0) continue
            maxCntInGroup[num] = bfs(r,c,num, n, m)
            num++
        }
    }

    //output
    //인접 4방향의 그룹들의 카운트 +
    for(r in 0 until n){
        for(c in 0 until m){
            if(graph[r][c] != 0){

                //4방향 중복 제거해서 더하기
                var set = mutableSetOf<Int>()
                for (i in 0 until 4) {
                    val nr = r + dir[i][0]
                    val nc = c + dir[i][1]

                    if (nr !in 0 until n || nc !in 0 until m) continue
                    if (graph[nr][nc] == 1) continue
                    if(set.contains(group[nr][nc])) continue
                    set.add(group[nr][nc])
                    graph[r][c] += maxCntInGroup[group[nr][nc]]
                }
                graph[r][c] %= 10
            }
            write("${graph[r][c]}")
        }
        write("\n")
    }
    close()
}
