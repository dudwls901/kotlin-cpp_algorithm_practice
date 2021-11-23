//https://www.acmicpc.net/problem/16918
//1초 아무것도x
//2초 폭탄 설치되어있지 않은 모든 칸에 설치 ( 모든 칸에 폭탄이 설치됨)
//3초 3초 전에 설치된 폭탄 모두 폭발
//1<=r,c,n<=200
//터져야될 폭탄 1 나중 폭탄 2

val dir = arrayOf(
    intArrayOf(1,0),
    intArrayOf(0,1),
    intArrayOf(-1,0),
    intArrayOf(0,-1)
)

fun install(r: Int, c : Int, graph: Array<IntArray>){
    for(i in 0 until r){
        for(j in 0 until c){
            if(graph[i][j]==0){
                graph[i][j]=2
            }
        }
    }
}

fun bomb(r : Int, c : Int, graph: Array<IntArray>){
    val graphCopy = Array(r){IntArray(c)}
    //복사하면서 나중 폭탄을 1로 변경
    for(i in 0 until r){
        for(j in 0 until c){
            graphCopy[i][j] = graph[i][j]
            if(graph[i][j]==2){
                graph[i][j]=1
            }
        }
    }
    for(i in 0 until r){
        for(j in 0 until c){
            if(graphCopy[i][j]==1){
                graph[i][j] =0
                for(k in 0 until 4){
                    val nr = i+dir[k][0]
                    val nc = j+dir[k][1]
                    if(nr !in 0 until r || nc !in 0 until c) continue
                    graph[nr][nc] =0
                }
            }
        }
    }
}

fun play(r : Int, c : Int, n : Int, graph: Array<IntArray>){
    var time=0
    var bombTime =3
    while(time++<n){
        //설치
        if(time%2==0){
            install(r,c,graph)
        }
        if(time==bombTime){
            bomb(r,c,graph)
            bombTime +=2
        }
    }
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (r,c,n) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(r){r->
        val line = br.readLine()
        var idx=0
        IntArray(c){c->
            if(line[idx++]=='.') 0 else 1
        }
    }
    play(r,c,n,graph)
    for(i in 0 until r){
        for(j in 0 until c){
            if(graph[i][j]==0){
                write(".")
            }
            else{
                write("O")
            }
        }
        write("\n")
    }
    close()
}
