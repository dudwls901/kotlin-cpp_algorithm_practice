//2021 하반기 초록 공채 기출
lateinit var graph: Array<IntArray>

fun findCross(type: Int, crossLen: Int, r: Int, c: Int, cnt: Int, center: Int): List<Pair<Int, Int>> {
    val pairList = ArrayList<Pair<Int, Int>>()
    var count = cnt * 2 + center
    var x = r
    var y = c
    if (type == -1) {
        while (x >= 0 && y >= 0 && count > 0) {
            pairList.add(Pair(x, y))
            x--
            y--
            count--
        }
    }
    else{
        while(x>=0 && y<=crossLen && count > 0){
            pairList.add(Pair(x, y))
            x--
            y++
            count--
        }
    }
    if(pairList.size%2!=0){
        pairList.removeAt(pairList.size/2)
    }
    else{

    }
    return pairList
}

fun swap(crossPair: List<Pair<Int, Int>>) {
    println(crossPair)
    for (i in 0 until crossPair.size / 2) {
        val (r1, c1) = crossPair[i]
        val (r2, c2) = crossPair[crossPair.size - 1 - i]
        graph[r1][c1] = graph[r2][c2].also { graph[r2][c2] = graph[r1][c1] }
    }
}

/*
* n,m의 범위 내에서 우하향 대각, 좌하향 대각을 기준으로 뒤집어라
* 
* */
fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = 5
    val m = 6
    var idx = 0
    graph = Array(n) { IntArray(m) { idx++ } }
    for (i in graph.indices) {
        for (j in graph[0].indices) {
            print("${graph[i][j]} ")
        }
        println()
    }
    val type = 1
    val crossLen = n.coerceAtMost(m)
    if (type == -1) {
        var r = 0
        var c = m - 1
        while (r < n) {
            var hasCenter = 0
            if((r-1)%2 !=0) hasCenter++
            val crossPair = findCross(-1, crossLen, r, c,(r - 1) / 2 +1, hasCenter)
            swap(crossPair)
            r++
        }
        r--
        c--
        while (c >= 0) {
            var hasCenter = 0
            if(c%2 !=0) hasCenter++
            val crossPair = findCross(-1, crossLen, r, c, (c) / 2, hasCenter)
            swap(crossPair)
            c--
        }
    }
    else{
        var r = 0
        var c = 0
        while(r<n){
            var hasCenter = 0
            if((r-1)%2 != 0) hasCenter++
            val crossPair = findCross(1,crossLen,r,c,(r-1)/2+1, hasCenter)
            swap(crossPair)
            r++
        }
        r--
        c++
        while(c<m){
            var hasCenter = 0
            if((crossLen-c)%2 !=0) hasCenter++
            val crossPair = findCross(1,crossLen,r,c, (crossLen-c)/2, hasCenter)
            swap(crossPair)
            c++
        }
    }

    for (i in graph.indices) {
        for (j in graph[0].indices) {
            print("${graph[i][j]} ")
        }
        println()
    }
    //output
    close()
}
