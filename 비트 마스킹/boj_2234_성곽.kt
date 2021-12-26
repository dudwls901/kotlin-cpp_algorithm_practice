//https://www.acmicpc.net/problem/2234
val dirXY = arrayOf(arrayOf(0,1),arrayOf(0,-1),arrayOf(1,0),arrayOf(-1,0))
val dir = arrayOf(4,1,8,2)
val br = System.`in`.bufferedReader()
var roomCnt=0
var maxSize=1
var curSize=0
var maxDeleteWallSize=0
fun dfs(r : Int, c : Int, num : Int, graph : Array<List<Int>>, room : Array<IntArray>){
    room[r][c]=num
    curSize++
    for(i in 0 until 4){
        //해당 방향에 벽이 없으면 ㄱ
        if(graph[r][c] and dir[i] ==0){
            var nr = r + dirXY[i][0]
            var nc = c + dirXY[i][1]
            //이미 방문했다면 스킵
            if(room[nr][nc]!=0) continue
            dfs(nr,nc,num,graph,room)
        }
    }
}

fun main() = with(System.out.bufferedWriter()){
    val (m,n) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(n){ br.readLine().split(' ').map { it.toInt() } }
    val room = Array(n){IntArray(m)}
    val roomSize = ArrayList<Int>()
    var num=1

    //roomCnt, maxSize구하기, room numbering하기, 각 roomSize 구하기 
    for(r in 0 until n){
        for(c in 0 until m){
            if(room[r][c]==0){
                curSize=0
                dfs(r,c,num++,graph,room)
                roomSize.add(curSize)
                maxSize=  maxSize.coerceAtLeast(curSize)
                roomCnt++
            }
        }
    }

    //maxDeleteWallSize 구하기
    for(r in 0 until n){
        for(c in 0 until m){
            for(i in 0 until 4){
                val nr = r + dirXY[i][0]
                val nc = c + dirXY[i][1]
                //그래프 범위 벗어나는 경우 스킵
                if(nr !in 0 until n || nc !in 0 until m) continue
                //벽이 있으면서 다른 방일 때만
                if(graph[r][c] and dir[i] !=0 && room[r][c] !=room[nr][nc]){
                    maxDeleteWallSize = maxDeleteWallSize.coerceAtLeast(roomSize[room[r][c]-1]+roomSize[room[nr][nc]-1])
                }
            }
        }
    }
    write("$roomCnt\n$maxSize\n$maxDeleteWallSize")
    close()
}
