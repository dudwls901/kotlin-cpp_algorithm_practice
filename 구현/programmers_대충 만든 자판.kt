//https://school.programmers.co.kr/learn/courses/30/lessons/160586
const val INF = 987654321
class Solution {
    
    val minMap = IntArray(26){INF}
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        //최소 키 매핑
        for(key in keymap){
            for(i in key.indices){
                val ch = key[i]
                minMap[ch-'A'] = minMap[ch-'A'].coerceAtMost(i+1) 
            }
        }
        
        return IntArray(targets.size){
            var ans = 0
            for(ch in targets[it]){
                val cnt = minMap[ch-'A']
                if(cnt == INF){
                    ans = -1
                    break
                }else{
                    ans += cnt
                }
            }
            ans
        }
    }
}
