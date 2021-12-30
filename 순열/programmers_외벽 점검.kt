//https://programmers.co.kr/learn/courses/30/lessons/60062
class Solution {
    
    var answer= 987654321
    val picked = ArrayList<Int>() // 순열로 고른 dist
    val weakCopy = IntArray(30) // 원형 자료구조를 1차원 배열로
    
    //다음 dist의 시작점 찾기
    fun findNext(value : Int, size : Int ) : Int{
        for(i in 0 until size*2){
            if(weakCopy[i]>value){
                return weakCopy[i]
            }
        }
        return value
    }
    
    fun check(size : Int) : Int{
        //weak.size만큼
        //i에서 시작하여 weak.size개보다 크거나 같으면 모든 지점 점검 가능
        for(i in 0 until size){
            val checked = BooleanArray(size)
            var curVal = weakCopy[i]
            val end = weakCopy[i+size]
            for(j in picked.indices){
                curVal += picked[j]
                curVal = findNext(curVal,size)
                if(curVal>=end) return picked.size
            }
        }
        return 987654321     
    }
    
    fun permutation(cnt : Int, n : Int, size : Int, dist : IntArray, visited: BooleanArray){
        
        //하나 이상의 dist가 선택됐을 때 모든 지점을 점검할 수 있는지 check
        if(cnt>0){
            val ans = check(size)
            answer= answer.coerceAtMost(ans)
            if(cnt==dist.size){
                return
            }
        }
        
        for(i in 0 until dist.size){
            if(visited[i])continue
            visited[i]=true
            picked.add(dist[i])
            permutation(cnt+1,n,size,dist,visited)
            picked.removeAt(picked.size-1)
            visited[i]=false
        }
        
    }
    
    fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
        var idx=0
        while(idx<weak.size){
            weakCopy[idx] = weak[idx]
            weakCopy[idx+weak.size]=weak[idx]+n
            idx++
        }
        
        permutation(0,n,weak.size,dist,BooleanArray(8))
        if(answer==987654321)
            answer =-1
        return answer
    }
}
