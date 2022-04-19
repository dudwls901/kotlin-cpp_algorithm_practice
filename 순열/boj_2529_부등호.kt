//https://www.acmicpc.net/problem/2529
val br = System.`in`.bufferedReader()

fun getIntGraph() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
var minAns = Long.MAX_VALUE
var maxAns = 0L
var input =""
fun permutation(result: Long, idx: Int, visited: BooleanArray){
    if(idx==input.length){
        minAns= minAns.coerceAtMost(result)
        maxAns = maxAns.coerceAtLeast(result)
        return
    }
    for(i in 0 .. 9){
        if(visited[i]) continue
        val cur = result%10
        when(input[idx]){
            '<'->{
                if(cur>=i) continue
                visited[i] = true
                permutation(result*10+i, idx+1, visited)
            }
            else->{
                if(cur<=i) continue
                visited[i] = true
                permutation(result*10+i, idx+1, visited)
            }
        }
        visited[i] = false
    }
}

fun main() = with(System.out.bufferedWriter()){

    val k = getInt()
    input = br.readLine().replace(" ","")

    for(i in 0 .. 9) {
        val visited= BooleanArray(10)
        visited[i] = true
        permutation(i.toLong(), 0, visited)
    }

    write("${String.format("%0${k+1}d", maxAns)}\n${String.format("%0${k+1}d", minAns)}")

    close()
}
