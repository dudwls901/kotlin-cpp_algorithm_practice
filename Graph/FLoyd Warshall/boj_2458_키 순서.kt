//https://www.acmicpc.net/problem/2458
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main()= with(System.out.bufferedWriter()){
    //input
    val (n,m) = getIntList()
    val edge = Array(n+1){BooleanArray(n+1)}
    repeat(m){
        val (from, to) = getIntList()
        edge[from][to] = true
        edge[to][from]
    }
    for(k in 1 .. n){
        for(i in 1 .. n){
            for(j in 1 .. n){
                if(edge[i][k] && edge[k][j])
                    edge[i][j] = true
            }
        }
    }
    var answer = 0
    for(i in 1 .. n){
        var cnt = 0
        for(j in 1 .. n){
            if(edge[i][j]  || edge[j][i]) cnt++
        }
        if(cnt == n-1) answer++
    }
    write("$answer")
    close()
}
