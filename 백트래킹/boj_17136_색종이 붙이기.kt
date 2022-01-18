//https://www.acmicpc.net/problem/17136
import java.util.*
const val INF = 987654321
val br = System.`in`.bufferedReader()
var answer=INF
val graph = Array(10){CharArray(10)}
val sticker = IntArray(6)

//스티커 붙일 수 있는지 확인
fun check(r : Int, c : Int, i : Int) : Boolean{
	//5개 사용한 스티커는 사용 불가
    if(sticker[i]==5)
        return false
    for(rr in 0 until i) {
        for (cc in 0 until i) {
            val nr = r + rr
            val nc = c + cc
            if (nr !in 0 until 10) return false
            if (nc !in 0 until 10) return false
            if (graph[nr][nc] != '1') return false
        }
    }
    return true
}

//스티커 붙이기, 떼기
fun stick(r : Int, c : Int, i : Int, mode : Int){
    sticker[i]+=mode
    for(rr in 0 until i) {
        for (cc in 0 until i) {
            val nr = r + rr
            val nc = c + cc
            if(mode==1){
                graph[nr][nc]='2'
            }
            else{
                graph[nr][nc]='1'
            }
        }
    }
}

fun backTracking(i : Int, cnt : Int){

	//현재 답보다 큰 경우 탐색 필요 x
    if(cnt>=answer) return

	var idx = i
    while(idx<=99 && graph[idx/10][idx%10]!='1'){
        idx++
    }
    
    //종료 조건
    //idx가 100이면 그래프에 1이 없음을 의미
    if(idx==100){
        answer= answer.coerceAtMost(cnt)
        return
    }

		//현재 idx를 r,c로 치환
        val r = idx / 10
        val c = idx % 10

		//5개 모두 붙일 수 없다면 더 깊이 탐색할 필요 없음
        var canMake=false
        for (i in 5 downTo 1) {
            if (check(r, c, i)) {
                stick(r, c, i, 1)
                backTracking((idx + 1), cnt + 1)
                stick(r, c, i, -1)
                canMake=true
            }
        }
        if(!canMake) return
}

fun main() = with(System.out.bufferedWriter()){
    for(i in 0 until 10){
        val tk = StringTokenizer(br.readLine())
        for(j in 0 until 10){
            graph[i][j] = tk.nextToken()[0]
        }
    }
    backTracking(0,0)

    if(answer==INF)
        answer = -1
    write("$answer")
    close()
}
