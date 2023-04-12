//https://www.acmicpc.net/problem/16202
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getStr() = br.readLine().trim()
fun getInt() = br.readLine().trim().toInt()

data class Edge(
    val s: Int,
    val e: Int,
    val w: Int
)
lateinit var parent: IntArray

fun clear(){
    for(i in parent.indices){
        parent[i] = i
    }
}

fun getParent(x: Int): Int{
    return if(parent[x] == x) x else getParent(parent[x]).also{
        parent[x] = it
    }
}

fun unionParent(x: Int, y: Int){
    val xx = getParent(x)
    val yy = getParent(y)
    if(parent[xx] < parent[yy]){
        parent[yy] = xx
    }else{
        parent[xx] = yy
    }
}

fun isConnected(x: Int, y: Int): Boolean{
    return getParent(x) == getParent(y)
}

fun isMST(): Boolean{
    val x = getParent(1)
    for(y in 1 until parent.size){
        if (x != getParent(y)) return false
    }
    return true
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val (n,m,t) = getIntList()
    val edges = Array(m){
        val input = getIntList()
        Edge(input[0], input[1], it+1)
    }
    parent = IntArray(n+1){it}
    val answer = IntArray(t)
    for(turn in 0 until t){
        var turnResult = 0
        for(i in turn until edges.size){
            val (s,e,w) = edges[i]
            if(isConnected(s,e).not()){
                unionParent(s,e)
                turnResult += w
            }
        }
        if(isMST()) answer[turn] = turnResult
        clear()
    }
    write(answer.joinToString(" "))
    close()
}
