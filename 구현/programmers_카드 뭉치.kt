//https://school.programmers.co.kr/learn/courses/30/lessons/159994
class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer: String = ""
        var card1Idx = 0
        var card2Idx = 0
        
        goal.forEach{
            if(card1Idx < cards1.size && cards1[card1Idx] == it){
                card1Idx++
            }else if(card2Idx < cards2.size && cards2[card2Idx] == it){
                card2Idx++
            }else{
               return "No" 
            }
        }
        
        return "Yes"
    }
}
