//https://www.acmicpc.net/problem/10971
val br = System.`in`.bufferedReader()
val INF = 987654321

val dp = Array(10){IntArray(1 shl 10){-1} }
fun dfs(curIdx : Int, curState : Int,n : Int ,endState : Int,edge : Array<IntArray>) : Int{

    if(endState ==curState){
        return if(edge[curIdx][0]!=0)
            edge[curIdx][0]
        else
            INF
    }
    if(dp[curIdx][curState]!=-1){
        return dp[curIdx][curState]
    }

    dp[curIdx][curState] = INF
    for(next in 0 until n){
        if((curState and (1 shl next)) !=0 || edge[curIdx][next]==0) continue
        val nextState = curState or (1 shl next)
        dp[curIdx][curState] = dp[curIdx][curState].coerceAtMost(edge[curIdx][next] + dfs(next,nextState,n,endState,edge))
    }

    return dp[curIdx][curState]
}

// 2<= n <=10
fun main() = with(System.out.bufferedWriter()){
    val n = br.readLine().toInt()
    val edge = Array(n){ br.readLine().split(' ').map{it.toInt()}.toIntArray() }

    write("${dfs(0,1,n,(1 shl n)-1,edge)}")
    close()
}
