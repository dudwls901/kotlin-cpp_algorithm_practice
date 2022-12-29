//https://school.programmers.co.kr/learn/courses/30/lessons/133502#
class Solution {
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        val target = intArrayOf(1,3,2,1)
        label@for(i in ingredient.indices){
            if(ingredient[i] == 1){
                if(i <3) continue
                var idx = i
                for(j in target.indices){
                    while(idx-j>0 && ingredient[idx-j]==0){
                        idx--
                    }
                    if(ingredient[idx-j] != target[j]) continue@label 
                }
                idx = i
                answer++
                for(j in target.indices){
                    while(idx-j>0 && ingredient[idx-j]==0){
                        idx--
                    }
                    ingredient[idx-j] = 0 
                }
            }
        }
        return answer
    }
}
