//https://www.acmicpc.net/problem/16198
val br = System.`in`.bufferedReader()

fun getInt() = br.readLine().toInt()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
lateinit var input: IntArray
lateinit var visited: BooleanArray
var answer=0

fun findNext(idx: Int,n: Int): Int{
    var left = input[0]
    var right = input[n-1]
    for(i in idx -1 downTo 1){
        if(!visited[i]){
            left = input[i]
            break
        }
    }
    for(i in idx+1 until n-1){
        if(!visited[i]){
            right = input[i]
            break
        }
    }
    val next = left*right
    return next
}

fun permutation(idx: Int, result : Int, cnt: Int, n: Int){

    answer = answer.coerceAtLeast(result)
    if(cnt==n-2) return

    for(i in 1 until n-1){
        if(visited[i]) continue
        val next = findNext(i,n)
        visited[i] = true
        permutation(i,result + next,cnt+1,n)
        visited[i] = false
    }
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    input = getIntList().toIntArray()
    visited = BooleanArray(n)

    //solve
    permutation(1,0,0,n)

    //output
    write("$answer")
    close()
}
