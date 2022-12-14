//https://school.programmers.co.kr/learn/courses/30/lessons/131127
class Solution {
    lateinit var map: MutableMap<String,Int>
    var answer = 0
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        solve(want,number,discount)
        return answer
    }

    private fun solve(want: Array<String>, number: IntArray, discount: Array<String>) {
        map = mutableMapOf()
        discount.forEachIndexed { idx,v ->
            map.put(v, map.getOrDefault(v,0)+1)
            if(idx - 10 >=0){
                if(map.getOrDefault(discount[idx - 10],0) == 0){
                    map.remove(discount[idx - 10])
                }else{
                    map.put(discount[idx - 10], map[discount[idx - 10]]!!-1 )
                }
            }
            if(checkPossible(want,number)) answer++
        }
    }

    private fun checkPossible(want: Array<String>, number: IntArray): Boolean {
        for(i in want.indices){
            val key = want[i]
            val cnt = number[i]
            if(map.getOrDefault(key,0)<cnt) return false
        }
        return true
    }
}
