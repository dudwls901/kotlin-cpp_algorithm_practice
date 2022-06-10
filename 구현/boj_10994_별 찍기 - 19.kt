//https://www.acmicpc.net/problem/10994
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var graph: Array<CharArray>

fun draw(n: Int, r: Int, c: Int){
    if(n==1){
        graph[r][c] = '*'
        return
    }

    val size = 1 + (n - 1) * 4
    //세로 별 찍기
    for(i in r until r + size){
        graph[i][c] = '*'
        graph[i][c+size-1] = '*'
    }
    //가로 별 찍기
    for(j in c until c + size){
        graph[r][j] = '*'
        graph[r+size-1][j] = '*'
    }

    //재귀적으로 네모 하나씩 그려감
    draw(n-1,r+2, c+2)

}

fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    val size = 1 + (n - 1) * 4
    graph = Array(size) { CharArray(size) { ' ' } }
    //solve
    draw(n,0,0)
    //output
    for(r in graph.indices){
        for(c in graph[0].indices){
            write("${graph[r][c]}")
        }
        write("\n")
    }
    close()

}
