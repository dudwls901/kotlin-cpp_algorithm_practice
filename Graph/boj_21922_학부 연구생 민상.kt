//https://www.acmicpc.net/submit/21922/33469536
import java.util.*
//상우하좌
val mov = arrayOf(arrayOf(-1,0),arrayOf(0,1),arrayOf(1,0),arrayOf(0,-1))
val q : Queue<Wind> = LinkedList<Wind>()
fun bfs(visited : Array<Array<BooleanArray>>,  n : Int, m : Int, graph : Array<CharArray>,answer : Array<IntArray>){

    while(q.isNotEmpty()){
        var (r,c,dir) = q.poll()
        val nR = r+mov[dir][0]
        val nC = c+mov[dir][1]
        if(nR<0 || nR>=n || nC<0 || nC>=m) continue
        if(visited[dir][nR][nC]) continue
        visited[dir][nR][nC]=true
        answer[nR][nC]=1
//        set.add(Pair(nR,nC))
        if(graph[nR][nC]=='1' && dir%2==1){
            continue
        }
        else if(graph[nR][nC]=='2'&& dir%2==0){
            continue
        }
        else if(graph[nR][nC]=='3'){
            if(dir>=2){
                dir = 2+(dir+1)%2
            }
            else{
                dir = (dir+1)%2
            }
        }
        else if(graph[nR][nC]=='4'){
            when{
                dir ==0 ->dir=3
                dir ==1 ->dir=2
                dir ==2 ->dir=1
                else -> dir=0
            }
        }
        else if(graph[nR][nC]=='9'){
            continue
        }//dir 변경 완료
        q.add(Wind(nR,nC,dir))
    }

}

fun main() = with(System.out.bufferedWriter()){
    val br= System.`in`.bufferedReader()
    var tk = StringTokenizer(br.readLine())
    val (n,m) = List(2){Integer.parseInt(tk.nextToken())}
    val graph = Array(n){CharArray(m)}
    val visited = Array(4){Array(n){BooleanArray(m)}}
//    val set = mutableSetOf<Pair<Int,Int>>()
    val answer = Array(n){IntArray(m)}

    for(i in 0 until n){
        tk = StringTokenizer(br.readLine())
        for(j in 0 until m){
            val num = tk.nextToken()
            graph[i][j]= num[0]
            if(graph[i][j] == '9'){
//                set.add(Pair(i,j))
                answer[i][j]=1
                for(dir in 0 until 4){
                    visited[dir][i][j]=true
                    q.add(Wind(i,j,dir))
                }
            }
        }
    }
    bfs(visited,n,m,graph,answer)
    var sum=0
    for(ans in answer){
        sum +=ans.sum()
    }
    write("${sum}")

    close()
}
data class Wind(var r : Int, var c : Int, var dir : Int)
