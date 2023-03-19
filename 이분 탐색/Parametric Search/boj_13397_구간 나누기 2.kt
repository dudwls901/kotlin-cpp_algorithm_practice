//https://www.acmicpc.net/problem/13397
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()){

    //input
    val (n,m) = getIntList()
    val input = getIntList()
    var left = 0
    var right = input.maxOrNull()!!
    var answer = Int.MAX_VALUE
    //solve
    while(left <= right){
        val mid = (left + right)/2
        if(canMid(mid,m,input)){
            answer = mid
            right = mid - 1
        }else{
            left = mid + 1
        }
    }
    //output
    write("$answer")

    close()
}

fun canMid(mid: Int,m: Int, input: List<Int>): Boolean {
    var min = Int.MAX_VALUE
    var max = 0
    var mCnt = 1
    for(num in input){
        min = min.coerceAtMost(num)
        max = max.coerceAtLeast(num)
        if(max - min > mid){
            max = num
            min = num
            mCnt++
        }
        if(mCnt > m) return false
    }
    return true
}
