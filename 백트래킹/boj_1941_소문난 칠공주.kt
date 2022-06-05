//https://www.acmicpc.net/problem/1941
val br = System.`in`.bufferedReader()

val dir = arrayOf(
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1),
    arrayOf(-1, 0)
)

lateinit var graph: Array<String>
val resultSet = BooleanArray(1 shl 26)
val visited = BooleanArray(25)
var answer = 0

fun check(r: Int, c: Int) : Boolean {
    for(i in 0 until 4){
        val nr = r+dir[i][0]
        val nc = c+dir[i][1]
        if(nr !in 0 until 5 || nc !in 0 until 5) continue
        val nIdx = nr*5 + nc
        if(visited[nIdx]) return true
    }
    return false
}

fun backTracking( s: Int, y: Int, result: Int) {

    //end
    //7명 채웠고 다솜파가 4명 이상
    if (s + y == 7) {
        //비트마스킹으로 결과 중복 체크
        if( s >= 4) {
            answer++
        }
        return
    }

    for(i in 0 until 25){
        //방문체크
        if(visited[i]) continue

        val r = i/5
        val c = i%5
        var ns = s
        var ny = y
        if(graph[r][c]=='Y'){
            ny++
        }
        else{
            ns++
        }

        //가지치기
        //1. 다솜파가 후달리는 경우
        if(7-(ns+ny) < 4-ns) continue
        //2.이미 탐색한 루트인 경우
        if(resultSet[result or (1 shl i)]) continue
        //3. 인접하지 않은 경우
        if(result !=0 && !check(r,c)) continue
        visited[i] =true
        resultSet[result or (1 shl i)] = true
        backTracking(ns,ny,result or (1 shl i))
        visited[i] = false
    }
}

fun main() = with(System.out.bufferedWriter()) {

    //input
    graph = Array(5) { br.readLine() }
    //solve
    backTracking(0,0,0)
    //output
    write("$answer")
    close()
}
