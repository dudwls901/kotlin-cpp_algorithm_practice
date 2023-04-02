//https://www.acmicpc.net/problem/1469
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()
var existAnswer = false
var answer = IntArray(100){-1}
fun main(){
    //input
    val n = getInt()
    val numbers = getIntList().sorted()
    //solve
    backTracking(0,n,numbers, BooleanArray(17))
    //output
    if(!existAnswer){
        print("-1")
    }
}

fun backTracking(idx: Int, n: Int, numbers: List<Int>, visited: BooleanArray) {
    if(existAnswer) return
    if(idx == 2*n){
        for(i in 0 until 2*n){
            if(answer[i] == -1) return
        }
        existAnswer = true
        print(answer.filter { it !=-1 }.joinToString(" "))
        return
    }
    if(answer[idx] != -1) {
        backTracking(idx+1, n, numbers, visited)
    }
    for(num in numbers){
        if(visited[num]) continue
        if(answer[idx] != -1 || answer[idx+num+1] != -1 ) continue
        answer[idx] = num
        answer[idx+num+1] = num
        visited[num] = true
        backTracking(idx+1, n, numbers, visited)
        visited[num] = false
        answer[idx] = -1
        answer[idx+num+1] = -1
    }
}
