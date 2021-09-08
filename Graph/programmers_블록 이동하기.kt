//https://programmers.co.kr/learn/courses/30/lessons/60063
import java.util.*
class Solution {
    
    data class Robot(val r1 : Int, val c1 : Int, val dir : Int, val time : Int)
    //상좌하우
    val move = arrayOf(intArrayOf(-1,0),intArrayOf(0,-1),intArrayOf(1,0),intArrayOf(0,1))
    val rotateR = arrayOf(-1,-1,1,1)
    val rotateC = arrayOf(1,-1,-1,1)
    fun isInside(r1 : Int, c1 : Int, r2 : Int, c2 : Int, size : Int):Boolean{
        if(r1>=0 && r1<size && c1>=0 && c1<size && r2>=0 && r2<size && c2>=0 && c2<size){
            return true
        }
        return false
    }
    fun isBlock(r : Int, c : Int,board : Array<IntArray>) : Boolean{
        if(board[r][c]==1)
            return true
        return false
    }
    
    fun bfs(board : Array<IntArray>): Int{
        val n = board.size
        val visited = Array<Array<BooleanArray>>(n){Array<BooleanArray>(n){BooleanArray(n)}}
        val q : Queue<Robot> = LinkedList<Robot>()
        q.add(Robot(0,0,3,0))
        visited[0][0][3]=true
        while(q.isNotEmpty()){
            val (r,c,dir,time) = q.poll()
            val rr = r+move[dir][0]
            val cc = c+move[dir][1]
            if((r==n-1 &&c==n-1)||(rr==n-1&&cc==n-1)){
                return time
            }
            //move
            for(i in move.indices){
                val nr = r+move[i][0]
                val nc = c+move[i][1]
                val nrr = rr+move[i][0]
                val ncc = cc+move[i][1]
                if(!isInside(nr,nc,nrr,ncc,n))continue
                if(isBlock(nr,nc,board)||isBlock(nrr,ncc,board))continue
                if(visited[nr][nc][dir])continue
                q.add(Robot(nr,nc,dir,time+1))
                visited[nr][nc][dir]=true
            }
            //rotate
            //rc축으로 회전
            var newDir= dir
            for(i in 3 downTo 2 ){
                newDir =(newDir+i)%4 
                //검사할 좌표
                val xr = rr+move[newDir][0]
                val xc = cc+move[newDir][1]
                //회전된 좌표
                val nrr = r+move[newDir][0]
                val ncc = c+move[newDir][1]
                // println("$newDir $xr $xc $nrr $ncc")
                if(!isInside(r,c,nrr,ncc,n))continue
                if(isBlock(xr,xc,board))continue
                if(visited[r][c][newDir]) continue
                if(isBlock(nrr,ncc,board))continue
                q.add(Robot(r,c,newDir,time+1))
                visited[r][c][newDir]=true
            }
            
            //rrcc축으로 회전
            newDir = (dir+2)%4
            for(i in 3 downTo 2){
                newDir =(newDir+i)%4
                //검사할 좌표
                val xr = r+move[newDir][0]
                val xc = c+move[newDir][1]
                //회전된 좌표
                val nr = rr+move[newDir][0]
                val nc = cc+move[newDir][1]
                if(!isInside(nr,nc,r,c,n))continue
                if(isBlock(xr,xc,board))continue
                if(visited[nr][nc][(newDir+2)%4])continue
                if(isBlock(nr,nc,board))continue
                q.add(Robot(nr,nc,(newDir+2)%4,time+1))
                visited[nr][nc][(newDir+2)%4]=true
            }
        }
        return 0
    }
    
    fun solution(board: Array<IntArray>): Int {
        
        return bfs(board)
    }

}
