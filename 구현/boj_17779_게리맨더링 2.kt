//https://www.acmicpc.net/problem/17779
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

var n = 0
lateinit var graph: Array<IntArray>
var answer = Int.MAX_VALUE

fun divideSector(x: Int, y: Int, d1: Int, d2: Int, lineGraph: Array<IntArray>) {
    val cntArr = IntArray(5)

    for(r in 1 until x+d1){
        for(c in 1 ..y){
            if(lineGraph[r][c]==-1) break
            lineGraph[r][c] = 1
        }
    }

    for(r in 1..x+d2){
        for(c in n downTo y+1){
            if(lineGraph[r][c]==-1) break
            lineGraph[r][c] = 2
        }
    }
    for(r in x+d1 .. n){
        for(c in 1 until y-d1+d2){
            if(lineGraph[r][c]==-1) break
            lineGraph[r][c] =3
        }
    }
    for(r in x + d2 + 1..n){
        for(c in n downTo y-d1+d2){
            if(lineGraph[r][c]==-1) break
            lineGraph[r][c] = 4
        }
    }
    for (r in 1..n) {
        for (c in 1..n) {
            if (lineGraph[r][c] <=0) {
                cntArr[4] += graph[r][c]
                continue
            }
            cntArr[lineGraph[r][c] - 1] += graph[r][c]
        }
    }
    answer = answer.coerceAtMost(cntArr.maxOrNull()!! - cntArr.minOrNull()!!)
}

fun makeLine(x: Int, y: Int, d1: Int, d2: Int) {
    val lineGraph = Array(n + 1) { IntArray(n + 1) }
    var r = x
    var c = y
    lineGraph[r][c] = -1
    while (c >= y - d1 && r <= x + d1) {
        if (r in 1..n && c in 1..n)
            lineGraph[r][c] = -1
        c--
        r++
    }
    r = x
    c = y
    while (c <= y + d2 && r <= x + d2) {
        if (r in 1..n && c in 1..n)
            lineGraph[r][c] = -1
        r++
        c++
    }
    r = x + d1
    c = y - d1
    while (r <= x + d1 + d2 && c <= y - d1 + d2) {
        if (r in 1..n && c in 1..n)
            lineGraph[r][c] = -1
        r++
        c++
    }
    r = x + d2
    c = y + d2
    while (r <= x + d1 + d2 && c >= y + d2 - d1) {
        if (r in 1..n && c in 1..n)
            lineGraph[r][c] = -1
        r++
        c--
    }
    divideSector(x, y, d1, d2, lineGraph)

}

fun main() = with(System.out.bufferedWriter()) {
    n = getInt()
    graph = Array(n+1){ r->
        if(r==0){
            IntArray(n+1)
        }
        else {
            val line = getIntList()
            IntArray(n + 1) { c ->
                if(c==0){
                    0
                }
                else{
                    line[c-1]
                }
            }
        }
    }

    //x,y,d1,d2구하기
    for (x in 1..n) {
        for (y in 1..n) {
            for (d1 in 1 until n) {
                if (x + d1 > n || y - d1 < 1) break
                for (d2 in 1 until n) {
                    if (x + d1 + d2 > n || y + d2 > n) break
                    makeLine(x, y, d1, d2)
                }
            }
        }
    }
    write("$answer")
    close()
}
