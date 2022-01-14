//https://www.acmicpc.net/problem/3187
val dirXY = arrayOf(arrayOf(0,1),arrayOf(0,-1),arrayOf(1,0),arrayOf(-1,0))
val br = System.`in`.bufferedReader()
var sCnt = 0
var wCnt = 0
fun dfs(r : Int, c : Int, n : Int, m : Int, graph : Array<CharArray>){
    if(graph[r][c]=='v'){
        wCnt++
    }
    else if(graph[r][c]=='k'){
        sCnt++
    }
    graph[r][c] = '#'

    for(dir in 0 until 4){
        val nr = r + dirXY[dir][0]
        val nc = c + dirXY[dir][1]
        if(nr !in 0 until n || nc !in 0 until m) continue
        if(graph[nr][nc]=='#')continue
        else if(graph[nr][nc]=='v'){
            wCnt++
        }
        else if(graph[nr][nc]=='k'){
            sCnt++
        }
        graph[nr][nc]='#'
        dfs(nr,nc,n,m,graph)
    }
}

fun main() = with(System.out.bufferedWriter()){

    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(n){br.readLine().toCharArray()}
    var sheep = 0
    var wolf = 0
    for(i in 0 until n){
        for(j in 0 until m){
            if(graph[i][j]!='#'){
                sCnt=0
                wCnt=0
                dfs(i,j,n,m,graph)
                if(sCnt>wCnt)
                    sheep+=sCnt
                else
                    wolf+=wCnt
            }

        }
    }
    write("$sheep $wolf")
    close()
}
