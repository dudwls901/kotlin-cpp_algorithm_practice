//https://programmers.co.kr/learn/courses/30/lessons/60059
class Solution {
    
    fun rotate(key : Array<IntArray>) : Array<IntArray>{
        val keyCopy = Array(key.size){IntArray(key.size)}
        for(i in key.indices){
            for(j in key.indices){
                keyCopy[i][j] = key[key.size-1-j][i]
            }
        }
        return keyCopy
    }
    
    fun check(board : Array<IntArray>, key : Array<IntArray>,lock : Array<IntArray>,r : Int, c : Int):Boolean{
        //깊은 복사 : 원본 배열의 값이 안 바뀜
        val boardCopy = Array(board.size){IntArray(board.size)}
        for(i in board.indices){
            for(j in board[i].indices){
                boardCopy[i][j] = board[i][j]
            }
        }
        
       //board에 key 합치기
        for(i in key.indices){
            for(j in key.indices){
                boardCopy[r+i][c+j] +=key[i][j]
            }
        }

         //a,b가 lock의 범위 내일 때, board[a][b]의 값이 2또는 0이라면 어차피 열 수 없으므로 바로 false return
        //이를 모두 통과한다면 return true
        // println("${key.size-1} ${boardSize}")
        for(i in key.size-1 until board.size-(key.size-1)){
            for(j in key.size-1 until board.size-(key.size-1)){
                if(boardCopy[i][j]!=1){
                    return false
                }
            }
        }
        return true
    }
    
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val boardSize = (key.size-1)*2+lock.size
        val board = Array(boardSize){IntArray(boardSize)}
        //자물쇠는 고정이므로 보드의 중앙에 미리 저장
        for(i in key.size-1 until boardSize-(key.size-1)){
            for(j in key.size-1 until boardSize-(key.size-1)){
                board[i][j]=lock[i-(key.size-1)][j-(key.size-1)]        
            }
        }
        //자물쇠의 왼쪽 맨 위에 걸치는 key부터 자물쇠의 오른쪽 맨 아래에 걸치는 key까지 검사
        var keyCopy = key
        
        for(t in 0 until 4){      
            for(i in 0 until boardSize-(key.size-1)){
                for(j in 0 until boardSize-(key.size-1)){
                    if(check(board,keyCopy,lock,i,j)) return true
                }
            }
            //키를 총 4번 회전
            if(t==3)continue
           keyCopy = rotate(keyCopy)
        }
        return false
    }
}
