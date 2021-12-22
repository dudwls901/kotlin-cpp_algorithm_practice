//https://www.acmicpc.net/problem/11559
val dirXY = arrayOf(arrayOf(0,1),arrayOf(0,-1),arrayOf(1,0),arrayOf(-1,0))

val br = System.`in`.bufferedReader()
var cnt=0
fun dfs(r : Int, c : Int, color : Char, idx : Int,graph : Array<CharArray>, visited : Array<IntArray>) : Boolean{

    var isBomb = false
    visited[r][c]=idx
    if(cnt>=4) isBomb=true
    for(i in 0 until 4){
        val nr = r+dirXY[i][0]
        val nc = c+dirXY[i][1]
        if(nr !in 0 until 12 || nc !in 0 until 6) continue
        if(graph[nr][nc]!=color) continue
        if(visited[nr][nc]==idx)continue
        visited[nr][nc]=idx
        cnt++
        isBomb= dfs(nr,nc,color,idx,graph,visited)
    }

    return isBomb
}

fun bomb(idx : Int, graph : Array<CharArray>, visited: Array<IntArray>){
    for(r in 0 until 12){
        for(c in 0 until 6){
            if(visited[r][c]==idx)
                graph[r][c]='.'
        }
    }
}

fun main() = with(System.out.bufferedWriter()){
    val graph = Array(12){br.readLine().toCharArray()}
    var finish =false
    var ans=0
    while(!finish){
        //RGBPY
        finish =true
        var idx=1
        val visited =Array(12){IntArray(6)}
        //bomb
        for(r in 0 until 12){
            for(c in 0 until 6){
                if(graph[r][c]!='.' && visited[r][c]==0){
                    cnt=1
                    if(dfs(r,c,graph[r][c],idx,graph,visited)){
                        finish=false
                        bomb(idx,graph,visited)
                    }
                    idx++
                }
            }
        }
        //내리기
        for(c in 0 until 6){
            for(r in 11 downTo 0){
                if(graph[r][c]=='.'){
                    var idx =r
                    while(idx>=0){
                        if(graph[idx][c]!='.')break
                        idx--
                    }
                    if(idx<0){
                        break
                    }
                    else{
                        graph[r][c]=graph[idx][c].also{graph[idx][c]='.'}
                    }
                }
            }
        }
        ans++
    }
    write("${ans-1}")
    close()
}
