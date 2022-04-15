//https://www.acmicpc.net/problem/14391
val br = System.`in`.bufferedReader()

lateinit var graph: Array<IntArray>

fun main() = with(System.out.bufferedWriter()){

    //input
    val (n,m) =br.readLine().split(' ').map{it.toInt()}
    graph= Array(n){
        val line = br.readLine()
        IntArray(m){Character.getNumericValue(line[it])}
    }

    //solve
    //0부터 1111~
    //0이면 가로 1이면 세로
    var answer=0
    for(state in 0 until (1 shl n*m)){
        var sum=0
        //가로
        for(r in 0 until n){
            var cur=0
            for(c in 0 until m){
                if(state and (1 shl r*m+c) ==0){
                    cur = cur*10 + graph[r][c]
                }
                else{
                    sum+=cur
                    cur=0
                }
            }
            sum+=cur
        }
        //세로
        for(c in 0 until m){
            var cur=0
            for(r in 0 until n){
                if(state and (1 shl r*m+c) !=0){
                    cur = cur*10 + graph[r][c]
                }
                else{
                    sum+=cur
                    cur=0
                }
            }
            sum+=cur
        }
        answer = answer.coerceAtLeast(sum)
    }

    write("$answer")

    close()
}
