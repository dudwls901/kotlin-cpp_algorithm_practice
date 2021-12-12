//https://www.acmicpc.net/problem/2098
import kotlin.math.*

var n = 0
val INF = 987654321
val dp = Array(16){IntArray(1 shl 16){-1} }
fun dfs(node : Int, state : Int, endState : Int, graph : Array<IntArray>) : Int{

    //모든 도시를 방문한 경우 (종료 조건)
    if(state == endState){
        //마지막 길이 존재하는 경우 마지막 길을 더해준다.
        if(graph[node][0]!=0){
            return graph[node][0]
        }
        //마지막 길이 없는 경우 INF를 넣어주어 아래 min을 통해 제외되게 만든다
        else{
            return INF
        }
    }
    //이미 state 방문 상태로 node를 방문한 경우 재활용
    if(dp[node][state]!=-1) return dp[node][state]
    //min을 구하기 위한 전처리
    dp[node][state] = INF
    for(i in 0 until n){
        //이미 방문한 도시이거나 가는 길이 없는 도시면 패스
        if(state and (1 shl i) != 0 || graph[node][i]==0) continue
        //다음 길 누적
        dp[node][state] = min(dp[node][state],graph[node][i]+dfs(i,state or (1 shl i),endState, graph))
    }
    //정답 반환
    return dp[node][state]
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    n = br.readLine().toInt()
    var graph = Array(n){
        br.readLine().split(' ').map{it.toInt()}.toIntArray()
    }
    write("${dfs(0,1,(1 shl n) -1,graph)}")
    close()
}
