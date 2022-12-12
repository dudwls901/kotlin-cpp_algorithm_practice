//https://school.programmers.co.kr/learn/courses/30/lessons/131701
class Solution {
    fun solution(temp: IntArray): Int {
        val n = temp.size
        val elements = IntArray(n * 2) {
            temp[it % n]
        }
        val set = mutableSetOf<Int>()
        for(len in 1 .. n){
            for(i in temp.indices){
                var sum = 0
                for(j in i until i+len){
                    sum += elements[j]
                }
                set.add(sum)
            }
        }
        return set.size
    }
}
