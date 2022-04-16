//https://www.acmicpc.net/problem/20922
val br = System.`in`.bufferedReader()

lateinit var arr: List<Int>
val visited = IntArray(100001)
fun main() = with(System.out.bufferedWriter()){

    //input
    val (n, k) = br.readLine().split(' ').map{it.toInt()}
    arr = br.readLine().split(' ').map{it.toInt()}
    //solve
    var answer=1
    var s=0
    for(e in 0 until n){
        while(visited[arr[e]]==k) {
            visited[arr[s++]]--
        }
        visited[arr[e]]++
        answer=  answer.coerceAtLeast(e-s+1)
    }
    //output
    write("$answer")
    close()
}
