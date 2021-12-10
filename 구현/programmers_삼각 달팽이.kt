//https://programmers.co.kr/learn/courses/30/lessons/68645
class Solution {
    fun solution(n: Int): IntArray {
        val arr = Array(n){IntArray(n)}
        //하, 우, 왼대 방향 반복
        val dir = arrayOf(arrayOf(1,0),arrayOf(0,1),arrayOf(-1,-1))
        //n==5인 경우 각 방향마다 54321만큼 이동
        var moveMax = n
        var r=0
        var c=0
        var curDir = 0
        var num=1
        var moveCnt=0
        while(moveMax!=0){
            arr[r][c] = num++
            moveCnt++
            //해당 방향의 최대 이동횟수 도달하면
            if(moveCnt==moveMax){
                //다음 방향의 최대 이동 횟수 감소
                moveMax--
                //이동 횟수 초기화
                moveCnt=0
                //방향 전환
                curDir++
            }
            r+= dir[curDir%3][0]
            c+= dir[curDir%3][1]
        }
        
        val answer = ArrayList<Int>()
        
        for(i in 0 until n){
            for(j in 0 until n){
                if(arr[i][j]>0)
                    answer.add(arr[i][j])
            }
        }
        return answer.toIntArray()
    }
}
