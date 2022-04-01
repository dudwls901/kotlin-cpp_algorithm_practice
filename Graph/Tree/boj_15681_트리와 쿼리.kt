//https://www.acmicpc.net/problem/15681
val br = System.`in`.bufferedReader()

//정점 n 2  10^5
//루트 r 1  N
//쿼리 q 1  1^5

lateinit var edge:Array<ArrayList<Int>>
lateinit var treeCnt: IntArray
lateinit var visited: BooleanArray

fun makeSubTreeCnt(n: Int,r: Int, q: Int){
    visited[r] =  true
    if(edge[r].isEmpty()){
        return
    }
    //루트에서 쭉쭉 내려가기
    for(next in edge[r]){
        if(visited[next]) continue
        makeSubTreeCnt(n,next,q)
        treeCnt[r]+=treeCnt[next]
    }
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n,r,q) = br.readLine().split(' ').map{it.toInt()}
    edge = Array(n+1){ArrayList<Int>()}
    treeCnt = IntArray(n+1){1}
    visited = BooleanArray(n+1)

    for(i in 0 until n-1){
        val (from, to) = br.readLine().split(' ').map{it.toInt()}
        edge[from].add(to)
        edge[to].add(from)
    }
    //solve
    makeSubTreeCnt(n,r,q)

    //output
    for(i in 0 until q){
        write("${treeCnt[br.readLine().toInt()]}\n")
    }

    close()
}
