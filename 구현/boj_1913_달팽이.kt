//https://www.acmicpc.net/problem/1913
//3<=n<=999
//안에서 바깥으로
//시작점 n/2 n/2
//상우하좌 순
val dir = arrayOf(arrayOf(-1,0),arrayOf(0,1),arrayOf(1,0),arrayOf(0,-1))

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val find = br.readLine().toInt()
    val graph= Array(n){IntArray(n)}
    var num = 1
    var curDir=0
    var moveMax=1
    var moveCnt=0
    var r=n/2
    var c=n/2
    var answer = Pair(r,c)
    graph[r][c]=num
    //방향 두 번 바뀔때마다 이동 칸 증가
    //11 22 33 44 55 66 7
    while(true){
        r += dir[curDir%4][0]
        c += dir[curDir%4][1]
        if(r !in 0 until n || c !in 0 until n)
            break

        graph[r][c]=++num
        moveCnt++
        if(moveCnt==moveMax){
            curDir++
            moveCnt=0
            if(curDir%2==0){
                moveMax++
            }
        }
        if(num==find){
            answer = Pair(r,c)
        }
    }

    for(i in graph.indices){
        for(j in graph[i].indices){
            write("${graph[i][j]} ")
        }
        write("\n")
    }
    write("${answer.first+1} ${answer.second+1}")
    
    close()
}
