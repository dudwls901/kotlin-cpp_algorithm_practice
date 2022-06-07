//https://www.acmicpc.net/problem/16938
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }

lateinit var graph: List<Int>

var answer=0

fun combination(n: Int, l: Int, r: Int, x: Int, sum: Int, cnt: Int, idx: Int, max:Int, min: Int){
    if(cnt>=2){
        if(max-min >=x && sum in l .. r) {
            answer++
        }
    }
    //두 문제 이상 선택
    //max-min >= X
    //sum >= L
    for(i in idx until n){
        if(sum>r) continue
        combination(n,l,r,x,sum+graph[i], cnt+1, i+1, max.coerceAtLeast(graph[i]),min.coerceAtMost(
            graph[i]))
    }
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val (N,L,R,X) = getIntList()
    graph = getIntList()
    //solve
    combination(N,L,R,X,0,0,0,0,Int.MAX_VALUE)
    //output
    write("$answer")
    close()
}
