//https://school.programmers.co.kr/learn/courses/30/lessons/134240
class Solution {
    fun solution(food: IntArray): String {
        var answer = StringBuilder()
        for(i in 1 until food.size){
            repeat(food[i]/2){
                answer.append(i)
            }
        }
        
        return "${answer}0${answer.reversed()}"
    }
}
