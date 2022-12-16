//https://www.acmicpc.net/problem/15728
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }

data class Node(
    val result: Int,
    val card: Int,
)

fun main() = with(System.out.bufferedWriter()) {

    //input
    val (n, k) = getIntList()
    val shareCards = getIntList()
    val teamCards = getIntList()
    
    //solve
    val nodeList = ArrayList<Node>()
    shareCards.forEach {
        teamCards.forEach { card ->
            nodeList.add(
                Node(
                    it * card,
                    card
                )
            )
        }
    }
    nodeList.sortByDescending { it.result }
    var removeCnt = 0
    val removeSet = mutableSetOf<Int>()
    var answer = 0
    for((result,card) in nodeList){
        if(!removeSet.contains(card)){
            if(removeCnt == k){
                answer = result
                break
            }
            removeSet.add(card)
            removeCnt++
        }
    }
    //output
    write("$answer")
    close()
}
