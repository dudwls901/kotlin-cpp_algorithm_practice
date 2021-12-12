//https://www.acmicpc.net/problem/15683
//반례 : https://www.acmicpc.net/board/view/48178
import kotlin.math.*

data class CCTV(var r : Int, var c : Int, var direct : Int)
val cctv = ArrayList<CCTV>()
var answer= 987654321

val dir = arrayOf(arrayOf(-1,0),arrayOf(0,1),arrayOf(1,0),arrayOf(0,-1))

fun check(graph : Array<IntArray>, n : Int, m : Int) : Int{
    var sum =0
    val copy = Array(n){r ->
        IntArray(m){c ->
            graph[r][c]
        }
    }
    for(tv in cctv){
        var nr = tv.r
        var nc = tv.c
        if(graph[tv.r][tv.c]==1){
            while(true) {
                nr += dir[tv.direct][0]
                nc += dir[tv.direct][1]
                if (nr !in 0 until n || nc !in 0 until m) break
                if (graph[nr][nc] == 6) break
                if (graph[nr][nc] != 0) continue
                copy[nr][nc] = -1
            }
        }
        else if(graph[tv.r][tv.c]==2){

            while(true) {
                nr += dir[tv.direct][0]
                nc += dir[tv.direct][1]
                if (nr !in 0 until n || nc !in 0 until m) break
                if (graph[nr][nc] == 6) break
                if (graph[nr][nc] != 0) continue
                copy[nr][nc] = -1
            }
            nr = tv.r
            nc = tv.c
            while(true) {
                nr += dir[tv.direct + 2][0]
                nc += dir[tv.direct + 2][1]
                if (nr !in 0 until n || nc !in 0 until m) break
                if (graph[nr][nc] == 6) break
                if (graph[nr][nc] != 0) continue
                copy[nr][nc] = -1
            }
        }
        else if(graph[tv.r][tv.c]==3){
            while(true) {
                nr += dir[tv.direct][0]
                nc += dir[tv.direct][1]
                if (nr !in 0 until n || nc !in 0 until m) break
                if (graph[nr][nc] == 6) break
                if (graph[nr][nc] != 0) continue
                copy[nr][nc] = -1
            }
            nr = tv.r
            nc = tv.c
            while(true) {
                nr += dir[(tv.direct + 1) % 4][0]
                nc += dir[(tv.direct + 1) % 4][1]
                if (nr !in 0 until n || nc !in 0 until m) break
                if (graph[nr][nc] == 6) break
                if (graph[nr][nc] != 0) continue
                copy[nr][nc] = -1
            }
        }
        else if(graph[tv.r][tv.c]==4) {
            while(true) {
                nr += dir[tv.direct][0]
                nc += dir[tv.direct][1]
                if (nr !in 0 until n || nc !in 0 until m) break
                if (graph[nr][nc] == 6) break
                if (graph[nr][nc] != 0) continue
                copy[nr][nc] = -1
            }
            nr = tv.r
            nc = tv.c
            while(true) {
                nr += dir[(tv.direct + 1) % 4][0]
                nc += dir[(tv.direct + 1) % 4][1]
                if (nr !in 0 until n || nc !in 0 until m) break
                if (graph[nr][nc] == 6) break
                if (graph[nr][nc] != 0) continue
                copy[nr][nc] = -1
            }
            nr = tv.r
            nc = tv.c
            while(true) {
                nr += dir[(tv.direct + 3) % 4][0]
                nc += dir[(tv.direct + 3) % 4][1]
                if (nr !in 0 until n || nc !in 0 until m) break
                if (graph[nr][nc] == 6) break
                if (graph[nr][nc] != 0) continue
                copy[nr][nc] = -1
            }
        }
    }
    for(i in 0 until n){
        for(j in 0 until m){
            if(copy[i][j]==0){
                sum++
            }
        }
    }
    return sum
}

fun dfs(idx : Int, graph : Array<IntArray>, n : Int, m : Int){

    if(idx==cctv.size){
        answer = min(answer,check(graph,n,m))
        return
    }
    //2인 경우 방향 상하, 좌우 두 경우
    if(graph[cctv[idx].r][cctv[idx].c]==2){
        for(i in 0 until 2){
            cctv[idx].direct=i
            dfs(idx + 1, graph, n, m)
        }
    }
    //나머지는 4방향 다 다름
    else {
        for (i in 0 until 4) {
            cctv[idx].direct = i
            dfs(idx + 1, graph, n, m)
        }
    }
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map{ it.toInt() }
    val graph = Array(n){r->
        val line = br.readLine().split(' ').map{it.toInt()}
        IntArray(m){c->
            if(line[c] in 1..4){
                cctv.add(CCTV(r,c,0))
            }
            line[c]
        }
    }
    for(i in 0 until n){
        for(j in 0 until m){
            if(graph[i][j]==5){
                for(k in 0 until 4){
                    var nr = i
                    var nc = j
                    while(true){
                        nr +=dir[k][0]
                        nc +=dir[k][1]
                        if(nr !in 0 until n || nc !in 0 until m) break
                        if(graph[nr][nc]==6) break
                        if(graph[nr][nc]!=0)continue
                        graph[nr][nc]=-1
                    }
                }
            }
        }
    }
    dfs(0,graph,n,m)
    write("$answer")
    close()
}
