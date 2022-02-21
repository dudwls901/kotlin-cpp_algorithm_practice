//https://www.acmicpc.net/problem/17484
val br = System.`in`.bufferedReader()

val dir = arrayOf(arrayOf(1, 0), arrayOf(1, 1), arrayOf(1, -1))
lateinit var graph: Array<List<Int>>
var answer = Int.MAX_VALUE
fun dfs(r: Int, c: Int, beforeDir: Int, sum: Int, n: Int, m: Int){
    for(i in 0 until 3){
        if(beforeDir==i) continue
        val nr = r + dir[i][0]
        val nc = c + dir[i][1]
        if(nr == n){
            answer = answer.coerceAtMost(sum)
            return
        }
        if(nr !in 0 until n || nc !in 0 until m) continue
        dfs(nr,nc,i,sum+graph[nr][nc],n,m)

    }
}

fun main() = with(System.out.bufferedWriter()){

    val (n, m) = br.readLine().split(' ').map{it.toInt()}
    graph = Array(n){br.readLine().split(' ').map{it.toInt()}}

    for(i in 0 until m){
        dfs(-1,i,-1,0,n,m)
    }
    write("$answer")
    close()
}
