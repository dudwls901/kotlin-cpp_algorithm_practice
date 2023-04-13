//https://school.programmers.co.kr/learn/courses/30/lessons/155652
class Solution {
    
    val skipIdx = BooleanArray(26)
    
    fun solution(s: String, skip: String, index: Int): String {
        var answer: String = ""
        for(ch in skip){
            skipIdx[ch-'a'] = true
        }
        val ss = s.toCharArray()
        for(i in ss.indices){
            ss[i] = nextChar(ss[i],index)
        }
        return String(ss)
    }
    fun nextChar(ch: Char, index: Int): Char{
        var num = ch-'a'
        var cnt = index
        while(cnt > 0){
            num++
            num = num%26
            if(skipIdx[num]) continue
            cnt--
        }
        return 'a'+(num%26)
    }
}
