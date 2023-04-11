//https://school.programmers.co.kr/learn/courses/30/lessons/178870
class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        //two pointer
        var l = 0
        var r = 0
        var sum = sequence[r]
        var answer = intArrayOf(0,Int.MAX_VALUE)
        //항상 K와 가깝게
        //sum이 K보다 크다면 R포인터 늘리고, sum이 k보다 작거나 같으면 L포인터 늘리고
        while(l < sequence.size){
            if(sum < k){
                if(r == sequence.size-1) break
                sum += sequence[++r]
            }else{
                if(sum == k){
                    if(answer[1]-answer[0] > r-l){
                        answer[0] = l
                        answer[1] = r
                    }
                }
                sum -= sequence[l++]
            }
        }
        return answer
    }
}
