//https://www.acmicpc.net/problem/16954
import java.util.*

val dir = arrayOf(intArrayOf(0,0), intArrayOf(0,1), intArrayOf(1,0), intArrayOf(0,-1), intArrayOf(-1,0),
    intArrayOf(1,1), intArrayOf(-1,-1), intArrayOf(-1,1),intArrayOf(1,-1))
var graph1 = Array<String>(8,{""})

//이동한 벽을 리턴
fun moveWall() : Array<String>{
    val graph2 = Array<String>(8){""}
    graph2[0] = "........"
    for(i in 1 until 8){
        graph2[i] = graph1[i-1]
    }
    return graph2
}

fun bfs( time : Int) : Int{
    val queue : Queue<Coordi>  = LinkedList<Coordi>()
    queue.add(Coordi(7,0))

    for(t in 0 until time){
        //1초에 한 번씩 벽 움직이기
        val graph2 = moveWall()
        val qSize = queue.size

        for(i in 0 until qSize){
            val (r,c) = queue.poll()
            for(j in 0 until dir.size){
                val nextR = r + dir[j][0]
                val nextC = c + dir[j][1]
                //그래프 안에 있으면
                if(nextR>=0 && nextR <8 && nextC>=0 && nextC<8){
                    //이동한벽과 기존의 벽에 닿지 않으면(queue에 푸시)
                    if(graph1[nextR][nextC]=='#' || graph2[nextR][nextC]=='#')
                        continue
                    queue.add(Coordi(nextR,nextC))
                }
            }
        }
        //time초 동안 살아남지 못하면(큐에 더이상 값이 없으면 0리턴)
        if(queue.isEmpty()){
            return 0
        }
        graph1 = graph2
    }
    //time초 동안 살아남음
    return 1
}

fun main()=with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var time = 8
    for(i in 0 until 8){
        graph1[i] = br.readLine()
        //벽의 가장 높은 위치 == 벽의 최대 이동 시간
        if(graph1[i].contains('#') && time ==8){
            time = 8-i
        }
    }
    write("${bfs(time)}")
    br.close()
    close()
}

data class Coordi(val r : Int, val c : Int)
