//https://www.acmicpc.net/problem/13023
val br = System.`in`.bufferedReader()

lateinit var edge: Array<ArrayList<Int>>

var result = false

fun dfs(cur: Int, depth: Int, visited: BooleanArray) {

    if(depth==4){
        result =true
        return
    }
    for(next in edge[cur]){
        if(visited[next]) continue
        visited[next] = true
        dfs(next, depth+1, visited)
        visited[next] = false
    }

}

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    edge = Array(n) { ArrayList() }
    repeat(m) {
        val (a, b) = br.readLine().split(' ').map { it.toInt() }
        edge[a].add(b)
        edge[b].add(a)
    }

    //solve,output
    for (i in 0 until n) {
        dfs(i, 0, BooleanArray(n) { it == i })
        if (result) {
            write("1")
            close()
            return
        }
        result = false
    }

    write("0")
    close()
}
