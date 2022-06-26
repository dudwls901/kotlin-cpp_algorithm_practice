//https://programmers.co.kr/learn/courses/30/lessons/87391
/*
쿼리 20만
n,m 10억
실제 시뮬레이션 없이 이동한 값을 상태로 나타내기
x,y에서 갈 수 있는 r1,c1  r2,c2  가능한 값의 범위
x,y에서 시작해 쿼리 역순 실행
*/
class Solution {
    val oper = LongArray(2)
    fun solution(n: Int, m: Int, x: Int, y: Int, queries: Array<IntArray>): Long {
        var r1 = x
        var r2 = x
        var c1 = y
        var c2 = y
        //연산 결과 추출
        for(i in queries.size-1 downTo 0){
            val d = queries[i][0]
            val cnt = queries[i][1]
            //방향 반전
            when(d){
                0 -> {//우
                    c2+=cnt
                    if(c2>=m) c2 = m-1
                    if(c1!=0) c1+=cnt
                    if(c1>=m) return 0
                }
                1 -> {//좌
                    c1-=cnt
                    if(c1<0) c1 = 0
                    if(c2!=m-1) c2-=cnt
                    if(c2<0) return 0
                }
                2 -> {//하
                    r2+=cnt
                    if(r2>=n) r2 = n-1
                    if(r1!=0) r1+=cnt
                    if(r1>=n) return 0
                }
                else -> {//상
                    r1-=cnt
                    if(r1<0) r1 = 0
                    if(r2!=n-1) r2-=cnt
                    if(r2<0) return 0
                }
            }
        }
        return (r2-r1+1).toLong() * (c2-c1+1).toLong()
    }
}
