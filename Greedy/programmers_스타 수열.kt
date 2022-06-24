//https://programmers.co.kr/learn/courses/30/lessons/70130
class Solution {
    /*
    * a에서 부분 수열 뽑기 a 50만
    * 짝수, 길이 2이상
    * 순서대로 2개씩 묶은 n개의 집합의 교집합이 1개 이상
    * x[i]!=x[i+1]
    * */
    var answer = 0
    fun solution(a: IntArray): Int {
        val cntArr = IntArray(a.size + 1)
        for (num in a) {
            cntArr[num]++
        }

        for (i in cntArr.indices) {
            val cnt = cntArr[i]
            //배열에 없는 수는 스팁
            if (cnt == 0) continue
           //현재 구한 스타 수열의 길이로 비교
           // cnt가 2일 때, 이미 구한 길이가 2로 구할 수 있는 최대 길이인 4이상이라면 스킵!
           // 그러면 cnt가 계속 1 1 1 1 1 1 1 1 1인 경우도 한 번만 검사하고 나머진 스킵 가능하다.
            if (answer*2 >= cnt*2) continue
            var hasI = false
            var hasOther = false
            var len = 0
            for (idx in a.indices) {
                //공통 수 만났을 때
                if (a[idx] == i) {
                    hasI = true
                    //공통 수가 x[i],x[i+1]에서 x[i+1]인 경우
                    if (hasOther) {
                        len++
                        hasI = false
                        hasOther = false
                    }
                }
                //다른 수 만났을 때
                else {
                    hasOther = true
                    //공통 수가 x[i],x[i+1]에서 x[i]인 경우
                    if (hasI) {
                        len++
                        hasI = false
                        hasOther = false
                    }
                }
            }
            answer = answer.coerceAtLeast(len)
        }
        return answer * 2
    }
}
