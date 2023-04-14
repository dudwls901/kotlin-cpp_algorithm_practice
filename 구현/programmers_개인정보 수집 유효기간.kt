//https://school.programmers.co.kr/learn/courses/30/lessons/150370
class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer = ArrayList<Int>()
        val cur = today.getDays()
        val termsPeriod = IntArray(26)
        for(term in terms){
            val(t, m) = term.split(" ")
            termsPeriod[t[0]-'A'] = m.toInt()*28
        }
        for(i in privacies.indices){
            val privacy = privacies[i]
            val(d,t) = privacy.split(" ")
            val day = d.getDays()
            if( cur >= day + termsPeriod[t[0]-'A']){
                answer.add(i+1)
            }
        }
        
        return answer.toIntArray()
    }
    
    fun String.getDays(): Int{
        val (y,m,d) = this.split(".").map{it.toInt()}
        return y * 12 * 28 + m * 28 + d
    }
}

data class Privacy(
    val day: Int,
    val term: Char
)
