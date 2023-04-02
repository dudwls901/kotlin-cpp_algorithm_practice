//https://school.programmers.co.kr/learn/courses/30/lessons/176963
class Solution {
    
    private val map = mutableMapOf<String,Int>()
    
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {

        for(i in name.indices){
            map[name[i]] = yearning[i]
        }
        val answer = IntArray(photo.size){
            cal(photo[it])
        }
        return answer
    }
    fun cal(photos: Array<String>): Int{
        var sum = 0
        for(photo in photos){
            sum += map.getOrDefault(photo,0)
        }
        return sum
    }
}
