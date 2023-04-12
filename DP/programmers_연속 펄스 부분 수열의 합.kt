//https://school.programmers.co.kr/learn/courses/30/lessons/161988
class Solution {
    fun solution(sequence: IntArray): Long {
        var answer: Long = 0
        //dp 풀이
        //특정 부분 수열을 고르면 그 수열의 시작점에 1펄스, -1펄스를 골라야 한다.
        //1과 -1이 반복된다. 이는 사실 처음부터 수열에 1펄스, -1펄스를 곱해두면 어느 부분 수열에 펄스를 곱하는 모든 경우를 커버할 수 있다.
        //따라서 두 개의 펄스를 곱한 수열을 구해놓고 두 수열에서 dp[i] = max(dp[i], dp[i-1] + seq[i]) 식을 이용해 최대 합을 구하면 끝
        
        //누적합으로도 풀리는데 왜인지 이해 안 감
        //-1펄스, 1펄스이든 둘 다 결과는 똑같으니 아무거나 곱한다.
        //누적합 때려서 max-min의 절댓값 구하면 끝
        //증명은 못하겠다. 이해 안 됨
        val sequences = Array(2){ a->
            sequence.mapIndexed{idx,it ->
                if(a == 0){
                    if(idx %2 ==0) -it.toLong() else it.toLong()
                }else{
                    if(idx%2==1) -it.toLong() else it.toLong()
                }   
            }
        }
        val dp = LongArray(sequence.size+1)
        for(seq in sequences){
            for(i in 1 .. seq.size){
                dp[i] = dp[i].coerceAtLeast(dp[i-1] + seq[i-1])
                answer = answer.coerceAtLeast(dp[i])
            }
            dp.fill(0)
        }
        return answer
    }
}
