//https://www.acmicpc.net/problem/2346
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {

    val n = getInt()
    val balloons = ArrayList<Pair<Int,Int>>()
    getIntList().forEachIndexed { idx, i ->
        balloons.add(Pair(i,idx+1))
    }
    var idx = 0
    while(true){
        write("${balloons[idx].second} ")
        var move = balloons[idx].first
        balloons.removeAt(idx)
        if(balloons.isEmpty()) break
        if(move>0) move--
        idx += move
        while(idx !in balloons.indices){
            if(idx<0){
                idx+=balloons.size
            }
            idx%=balloons.size
        }
    }
    close()
}
