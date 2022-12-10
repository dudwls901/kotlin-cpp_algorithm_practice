//https://school.programmers.co.kr/learn/courses/30/lessons/76503
class Solution {
    var answer = 0L
    lateinit var graph : Array<ArrayList<Int>>
    
    fun dfs(cur : Int, aL : LongArray, visited : BooleanArray):Unit{
        visited[cur]=true
        for(i in 0 until graph[cur].size){
            val next = graph[cur][i]
            if(visited[next])
                continue
            dfs(next,aL,visited)
            aL[cur]+=aL[next]
            answer+=Math.abs(aL[next])
        }
    }
    
    fun solution(a: IntArray, edges: Array<IntArray>): Long {
        
        val aL = LongArray(a.size) 
        val visited = BooleanArray(a.size,{false})
        
        graph= Array(a.size,{ArrayList<Int>()})
        for(i in a.indices){
            aL[i] = a[i].toLong()
        }
        for(i in edges.indices){
           graph[edges[i][0]].add(edges[i][1])
           graph[edges[i][1]].add(edges[i][0])
        }
        dfs(0,aL,visited)
        if(aL[0]==0L)
            return answer
        else
            return -1
    }
}
