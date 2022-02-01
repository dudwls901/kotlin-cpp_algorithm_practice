//https://www.acmicpc.net/problem/10157
val br = System.`in`.bufferedReader()

val dirXY = arrayOf(arrayOf(-1, 0), arrayOf(0, 1), arrayOf(1, 0), arrayOf(0,-1))

fun main() = with(System.out.bufferedWriter()) {

    val (c,r) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(r){IntArray(c)}
    val k = br.readLine().toInt()

    if(k>c*r){
        write("0")
        close()
        return
    }
    var idx = c*r
    var curNum = 1
    var dir =0

    while(true) {

        val cr = idx / c + dirXY[dir][0]
        val cc = idx % c + dirXY[dir][1]

        //방향 전환
        if (cr !in 0 until r || cc !in 0 until c || graph[cr][cc] != 0) {
            dir = ((dir+1)%4)
            continue
        }
        if(curNum==k){
            write("${cc + 1} ${r-cr}")
            break
        }
        idx = cr*c + cc
        graph[cr][cc] = curNum++

    }
    close()
}
