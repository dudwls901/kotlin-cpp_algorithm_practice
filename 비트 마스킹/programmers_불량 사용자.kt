//https://programmers.co.kr/learn/courses/30/lessons/64064
//8Px * 8*x
class Solution {
    var answer = 0
    val resultVisited = BooleanArray(1 shl 9)
    val combVisited = BooleanArray(9)
    
    fun check(a: String, b: String): Boolean{
        if(a.length!=b.length) return false
        for(i in a.indices){
            if(a[i]==b[i] || b[i]=='*') continue
            return false
        }
        return true
    }

    fun permutation(userId: Array<String>, bannedId: Array<String>,cur: Int, len: Int, end: Int, resultSet: IntArray){

        if(len==end){
            if(!resultVisited[cur]) {
                answer++
            }
            resultVisited[cur] = true
            return
        }

        for(i in userId.indices){
            if(combVisited[i]) continue
            if(!check(userId[i], bannedId[len])) continue

            combVisited[i] = true
            resultSet[len]=i
            val next = cur or (1 shl (i+1))
            permutation(userId,bannedId,next,len+1,end,resultSet)

            combVisited[i] = false
        }

    }

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        println(banned_id.size)
        permutation(user_id, banned_id,1, 0, banned_id.size, IntArray(banned_id.size))
        return answer
    }
}
