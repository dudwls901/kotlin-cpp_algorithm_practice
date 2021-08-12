//https://programmers.co.kr/learn/courses/30/lessons/43163

import java.util.*
class Solution {
    val visited = BooleanArray(50)
    fun bfs(begin : String, target : String, words : Array<String>): Int{
        val q : Queue<Pair<String,Int>> = LinkedList<Pair<String,Int>>()
        q.add(Pair(begin,0))
        
        while(q.size!=0){
            val (now,cnt) = q.poll()
            if(now == target){
                return cnt
            }
            for(i in 0 until words.size){
                var dif=0
                if(visited[i])
                continue
                for(j in 0 until words[i].length){
                    if(now[j]!=words[i][j]){
                        dif++
                    }
                }
                if(dif==1){
                    q.add(Pair(words[i],cnt+1))
                    visited[i]=true
                }
            }
        }
        
        return 0
    }
    
    fun solution(begin: String, target: String, words: Array<String>): Int {
        
        return bfs(begin, target, words)
        
    }
}
