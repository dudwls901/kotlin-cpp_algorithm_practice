//https://www.acmicpc.net/problem/14225
val br = System.`in`.bufferedReader()

fun getIntGraph() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
lateinit var input: List<Int>
val visited = BooleanArray(2000001)
val graph = BooleanArray(2000001)

fun combination(result: Int, idx: Int, n: Int){

    graph[result] = true

    for(i in idx until n){
        if(visited[i]) continue
        visited[i] = true
        combination(result+input[i], i+1, n)
        visited[i] = false
    }
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    input = getIntGraph()

    //solve
    combination(0,0,n)

    //output
    for(i in graph.indices){
        if(!graph[i]) {
            write("$i")
            close()
            return
        }
    }

    close()
}
