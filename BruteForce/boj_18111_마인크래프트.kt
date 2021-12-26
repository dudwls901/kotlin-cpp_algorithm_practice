//https://www.acmicpc.net/problem/18111
val INF = 987654321
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){
    val (n,m,b) = br.readLine().split(' ').map{it.toInt()}
    var maxHigh =0
    var minHigh=INF
    var answer=Pair(INF,0)
    val graph = Array(n){r->
        var c = 0
        br.readLine().split(' ').map{
            val high = it.toInt()
            maxHigh= maxHigh.coerceAtLeast(high)
            minHigh = minHigh.coerceAtMost(high)
            high
        }
    }

    while(minHigh<=maxHigh){
        var build = 0
        var delete = 0
        for(i in 0 until n){
            for(j in 0 until m){
                if(graph[i][j]>minHigh){
                    delete+=graph[i][j]-minHigh
                }
                else{
                    build+=minHigh-graph[i][j]
                }
            }
        }
        if(build<=b+delete){
            if(answer.first>=delete*2+build){
                answer = Pair(delete*2+build, minHigh)
            }
        }
        minHigh++
    }
    write("${answer.first} ${answer.second}")
    close()
}
