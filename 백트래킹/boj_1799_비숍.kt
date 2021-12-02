//https://www.acmicpc.net/problem/1799
import kotlin.math.*
var answer =arrayOf(0,0)
val left = BooleanArray(20)
val right = BooleanArray(19)
fun backTracking( i : Int, j: Int, n : Int,graph : Array<IntArray>, cnt : Int, color : Int){
    var r = i
    var c = j
    if (c >= n) {
        r++;
        if(c%2 == 0) c = 1;
        else c = 0;
    }
    if (r >= n) {
        answer[color] = max(answer[color], cnt);
        return;
    }
    //그래프가 1(비숍을 놓을 수 있는 칸)이고, 해당 칸의 왼쪽 대각, 오른쪽 대각에 비숍이 없다면!
    if(graph[r][c]==1 && !left[c-r+n] && !right[r+c]){
        left[c-r+n]=true
        right[r+c]=true
        backTracking(r,c+2,n,graph,cnt+1,color)
        left[c-r+n]=false
        right[r+c]=false
    }
    backTracking(r,c+2,n,graph,cnt,color)


}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val graph = Array(n){
        br.readLine().split(' ').map { it.toInt() }.toIntArray()
    }
    backTracking(0,0,n,graph,0,0)
    backTracking(0,1,n,graph,0,1)
    write("${answer[0]+answer[1]}")
    close()
}
