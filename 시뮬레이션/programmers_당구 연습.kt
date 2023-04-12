//https://school.programmers.co.kr/learn/courses/30/lessons/169198
// edgeCase고려하지 않아도 되긴 함. 아래에서 isEdgeCase에 해당하는 부분 다 지워도 됨
class Solution {
    
    fun getDistance(x: Int,y: Int) = x*x + y*y
    
    
    lateinit var edgeXY: Array<IntArray>
    lateinit var wallXY: Array<IntArray>
    
    fun solution(m: Int, n: Int, startX: Int, startY: Int, balls: Array<IntArray>): IntArray {
        var answerArr: IntArray = IntArray(balls.size)
        
        //prepare
        makeEdgeXY(m, n)
        // makeWallXY(m, n)
        
        for(i in balls.indices){
            val ball = balls[i]
            var answer = Int.MAX_VALUE
            if(isEdgeCase(startX,startY, ball[0],ball[1])){
                //4방향 꼭지점 기준 최솟값
                for(i in 0 until 4){
                    when(i){
                        0 ->{
                            if(startX > ball[0] && startY <ball[1]) continue
                        }
                        1 -> {
                            if(startX < ball[0] && startY < ball[1] ) continue
                        }
                        2 -> {
                            if(startX < ball[0] && startY > ball[1]) continue
                        }
                        else ->{
                            if(startX > ball[0] && startY > ball[1]) continue
                        }
                    }
                    answer = answer.coerceAtMost(calEdge(startX,startY, ball[0],ball[1],edgeXY[i][0], edgeXY[i][1]))
                } 
            }
            //4방향 벽 기준 뒤집어 최솟값
            var x = startX
            var y = 2*n - startY
            if((startX == ball[0]  && ball[1] > startY).not()){
                answer = answer.coerceAtMost(
                    calWall(x,y,ball[0],ball[1])
                )
            }
            x = 2*m - startX
            y = startY
            if((startY == ball[1] && ball[0] > startX).not()){
                answer = answer.coerceAtMost(
                    calWall(x,y,ball[0],ball[1])
                )
            }
            x = startX
            y = -startY
            if((startX == ball[0] && ball[1] < startY).not()){
                answer = answer.coerceAtMost(
                    calWall(x,y,ball[0],ball[1])
                )
            }
            x = -startX
            y = startY
            if((startY == ball[1] && ball[0] < startX).not()){
                answer = answer.coerceAtMost(
                    calWall(x,y,ball[0],ball[1])
                )
            }
            answerArr[i] = answer
        }
        return answerArr
    }
    
    fun isEdgeCase(x: Int, y: Int, nx: Int, ny: Int): Boolean = Math.abs(x-nx) == Math.abs(y-ny)
    
    fun makeEdgeXY(m: Int, n:Int){
        edgeXY = arrayOf(
            intArrayOf(0,n),
            intArrayOf(m,n),
            intArrayOf(m,0),
            intArrayOf(0,0)
        )
    }
    
    fun calEdge(x:Int, y: Int, nx: Int, ny: Int, ex: Int, ey: Int): Int{
        val line1 = Math.abs(ex-x) * Math.abs(ex-x) + Math.abs(ey-y) * Math.abs(ey-y)
        val line2 = Math.abs(ex-nx) * Math.abs(ex-nx) + Math.abs(ey-ny) * Math.abs(ey-ny)
        return line1+line2
    }
    
    fun calWall(x: Int,y: Int, nx: Int, ny: Int): Int{
        return Math.abs(nx-x) * Math.abs(nx-x) + Math.abs(ny-y) * Math.abs(ny-y)
    }
    
}
