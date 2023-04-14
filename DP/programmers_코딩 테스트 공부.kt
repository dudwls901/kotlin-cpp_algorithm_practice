//https://school.programmers.co.kr/learn/courses/30/lessons/118668
//dp로 푼 것, 그래프로도 가능
const val INF = 987654321
class Solution {
    var maxAlp = 0
    var maxCop = 0
    fun solution(alpp: Int, copp: Int, problems: Array<IntArray>): Int {

        val myProblems = ArrayList<IntArray>().apply{
            addAll(problems)
            add(intArrayOf(0,0,1,0,1))
            add(intArrayOf(0,0,0,1,1))
        }
        
        for(problem in problems){
            maxAlp = maxAlp.coerceAtLeast(problem[0])
            maxCop = maxCop.coerceAtLeast(problem[1])
        }
        
        //하나만 충족된 경우 아래 for문을 타지 않기 때문에 maxAlp, maxCop로 갱신
        val alp = if(alpp >= maxAlp) maxAlp else alpp
        val cop = if(copp >= maxCop) maxCop else copp
        
        //둘 다 충족된 경우
        if(alp >= maxAlp && cop >= maxCop) return 0
        
        val dp = Array(152){IntArray(152){INF}}
        dp[alp][cop] = 0
        
        //max를 넘어가는 숫자는 max로 갱신 (최대를 max로 제한)
        for(r in alp .. maxAlp){
            for(c in cop .. maxCop){
                for(pro in myProblems){
                    if(r < pro[0] || c < pro[1]) continue
                    val nAlp = maxAlp.coerceAtMost(r + pro[2])
                    val nCop = maxCop.coerceAtMost(c + pro[3])
                    dp[nAlp][nCop] = dp[nAlp][nCop].coerceAtMost(dp[r][c] + pro[4])
                }
            }
        }
        return dp[maxAlp][maxCop]
    }
}
