//https://www.acmicpc.net/problem/9663
import kotlin.math.*

var answer=0

fun isPossible(row : Int,board : IntArray) : Boolean{

    for(i in 0 until row){
    //현재 둘 퀸의 자리가 이전까지 퀸들의 행과열,대각선 자리라면 둘 수 없음
        if(board[i]==board[row] || (row-i == abs(board[row]-board[i])))
            return false
    }
    return true
}

fun dfs(row : Int,board : IntArray,n : Int){

	//한 행씩 퀸을 두면서 내려왔으므로, 현재 행이 n과 같아진다면 n개의 퀸을 두었다는 의미
    if(row == n){
        answer++
        return
    }
    for(i in 0 until n ){
        board[row] = i
        //현재 행의 열에 퀸을 둘 수 있으면 다음 행 이어서 탐색
        //현재 행의 열에 퀸을 둘 수 없다면 현재 행의 다음 열 이어서 탐색
        if(isPossible(row,board)){
            dfs(row+1,board,n)
        }
    }

}

fun main() = with(System.out.bufferedWriter()){
    //1<=n<=15
    val br =System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    val board = IntArray(n)
    dfs(0,board,n)
    write("$answer")
    close()
}
