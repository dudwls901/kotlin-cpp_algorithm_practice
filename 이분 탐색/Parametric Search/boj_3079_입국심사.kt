//https://www.acmicpc.net/problem/3079
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
lateinit var arr:IntArray

fun canFinish( m: Long, mid: Long) : Boolean{
    var sum = 0L
    for(t in arr){
        sum += mid/t
        if(sum>=m) return true
    }
    return false
}

fun main(){
    //input
    val (n,m) = br.readLine().split(' ').map{it.toLong()}
    arr = IntArray(n.toInt()){getInt()}

    //solve
    var s = 1L
    var e = 0L
    for(t in arr){
        e = e.coerceAtLeast(m*t)
    }
    var answer = 0L
    while(s<=e){
        val mid: Long = (s+e)/2
        if(canFinish(m,mid)){
            answer = mid
            e = mid - 1
        }
        else{
            s = mid + 1
        }
    }
    println(answer)
}
