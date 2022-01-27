//https://www.acmicpc.net/problem/3085
val br = System.`in`.bufferedReader()
val dirXY : Array<IntArray> = arrayOf(intArrayOf(0,1),intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,-1))

//1<=n<=50
var answer =0
var max=0
lateinit var graph : Array<CharArray>

fun findMax(n : Int){
    for(r in 0 until n){
        var curC = graph[r][0]
        var cCnt = 0
        var curR = graph[0][r]
        var rCnt = 0
        for(c in 0 until n){
            //가로 탐색
            if(curC==graph[r][c]){
                cCnt++
                max = max.coerceAtLeast(cCnt)
            }
            else{
                curC=graph[r][c]
                cCnt=1
            }
            //세로 탐색
            if(curR==graph[c][r]){
                rCnt++
                max = max.coerceAtLeast(rCnt)
            }
            else{
                curR = graph[c][r]
                rCnt=1
            }
        }
    }
}

fun choiceSwap(n : Int, r: Int, c : Int, visited: Array<BooleanArray>){

    for(dir in 0 until 4){
        val nr = r + dirXY[dir][0]
        val nc = c + dirXY[dir][1]
        if(nr !in 0 until n || nc !in 0 until n) continue
        if(visited[nr][nc]) continue
        if(graph[r][c] == graph[nr][nc]) continue

        graph[r][c] = graph[nr][nc].also{graph[nr][nc] = graph[r][c]}
        findMax(n)
        answer= answer.coerceAtLeast(max)
        max = 0
        graph[r][c] = graph[nr][nc].also{graph[nr][nc] = graph[r][c]}
    }

}


fun main() = with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    graph = Array(n){br.readLine().toCharArray()}
    val visited = Array(n){BooleanArray(n)}

    findMax(n)
    answer= answer.coerceAtLeast(max)
    max = 0

    for(i in 0 until n){
        for(j in 0 until n){
            choiceSwap(n,i,j,visited)
            visited[i][j]=true
        }
    }

    write("$answer")

    close()
}
