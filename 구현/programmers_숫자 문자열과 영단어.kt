//https://programmers.co.kr/learn/courses/30/lessons/81301
class Solution {

    val map = mutableMapOf<String,Int>()
    fun solution(s: String): Int {

        for(i in 0 ..9){
            map[i.toString()] = i
        }
        map["zero"] = 0
        map["one"] = 1
        map["two"] = 2
        map["three"] = 3
        map["four"] = 4
        map["five"] = 5
        map["six"] = 6
        map["seven"] = 7
        map["eight"] = 8
        map["nine"] = 9
        var strBuffer = StringBuffer()
        var answer = StringBuffer()
        for(ch in s){
            strBuffer.append(ch)
            if(map[strBuffer.toString()]!=null){
                answer.append(map[strBuffer.toString()])
                strBuffer= StringBuffer()
            }
        }

        return answer.toString().toInt()
    }
}
