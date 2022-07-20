//https://www.acmicpc.net/problem/11687
val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().toInt()

fun countZero(mid: Int) : Long {
    var key: Long = 5
    var sum: Long = 0
    while (key <= mid) {
        sum += mid / key
        key *= 5
    }
    return sum
}
fun main() = with(System.out.bufferedWriter()) {
    val m = getInt().toLong()
    var s = 1
    var e = 987_654_321
    var answer = 0
    while(s<=e){
        val mid = (s+e)/2
        val cnt = countZero(mid)
        if(cnt >= m){
            if(cnt == m) answer = mid
            e = mid - 1
        }
        else{
            s = mid + 1
        }
    }
    write("${if(answer==0) -1 else answer}")
    close()
}
