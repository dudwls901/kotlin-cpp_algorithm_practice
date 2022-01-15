//https://programmers.co.kr/learn/courses/30/lessons/87946

//in 80
//after 20 소모
//최대한 던전 많이 탐험
class Solution {
    var answer=0
    
    fun dfs(cur : Int, dungeons : Array<IntArray>, cnt : Int, visited : BooleanArray){
        if(cnt==dungeons.size){
            answer = answer.coerceAtLeast(cnt)
            return
        }
        for(i in dungeons.indices){
            if(visited[i])continue
            if(cur<dungeons[i][0]){
                answer = answer.coerceAtLeast(cnt)
                continue
            }
            visited[i]=true
            dfs(cur-dungeons[i][1],dungeons,cnt+1,visited)
            visited[i]=false
        }
    }
    
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        dfs(k,dungeons,0,BooleanArray(dungeons.size))
        return answer
    }
}
