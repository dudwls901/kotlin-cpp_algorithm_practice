//https://programmers.co.kr/learn/courses/30/lessons/68936
class Solution {
    
    val answer = IntArray(2){0}
    
    fun dfs(r : Int, c : Int, size : Int, arr : Array<IntArray>){
        var zero = true
        var one = true
        for(i in r until r+size){
            for(j in c until c+size){
                if(arr[i][j]==0) one = false
                if(arr[i][j]==1) zero = false
            }
        }
        if(zero){
            answer[0]++ 
            return
        }
        if(one){
            answer[1]++
            return
        }
        dfs(r,c,size/2,arr)
        dfs(r,c+size/2,size/2,arr)
        dfs(r+size/2,c,size/2,arr)
        dfs(r+size/2,c+size/2,size/2,arr)
        
    }
    
    fun solution(arr: Array<IntArray>): IntArray {
        dfs(0,0,arr.size,arr)
        return answer
    }
}
