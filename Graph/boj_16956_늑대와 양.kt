//https://www.acmicpc.net/problem/16956
val dirXY = arrayOf(arrayOf(0,1),arrayOf(0,-1),arrayOf(1,0),arrayOf(-1,0))
val br = System.`in`.bufferedReader()
//s 양
//w 늑대
//양이나 늑대가 없을 수도 있음
fun main() = with(System.out.bufferedWriter()){
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(n){ br.readLine().toCharArray() }
    for(r in 0 until n){
        for(c in 0 until m){
            if(graph[r][c]=='S'){
                for(i in 0 until 4){
                    val nr = r+dirXY[i][0]
                    val nc = c+dirXY[i][1]
                    if(nr !in 0 until n || nc !in 0 until m) continue
                    if(graph[nr][nc]=='W'){
                        write("0")
                        close()
                        return
                    }
                    if(graph[nr][nc]=='S') continue
                    graph[nr][nc]='D'
                }
            }
        }
    }
    write("1\n")
    for(i in 0 until n){
        for(j in 0 until m){
            write("${graph[i][j]}")
        }
        write("\n")
    }
    close()
}
