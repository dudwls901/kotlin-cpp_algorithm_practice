//https://www.acmicpc.net/problem/2548
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun getSum(arr: IntArray, mid: Int): Int{
    var sum = 0
    for(i in arr){
        sum += Math.abs(arr[mid]-i)
    }
    return sum
}

fun main() = with(System.out.bufferedWriter()){

    //input
    val n = getInt()
    val input = getIntList().toIntArray()
    input.sort()
    //solve
    var s = 0
    var e = input.size-1
    var answer = 0
    var sum = Int.MAX_VALUE
    while(s<=e){
        val mid = (s+e)/2
        val result = getSum(input,mid)
        if(result <= sum){
            answer = input[mid]
            e = mid-1
            sum = result
        }else{
            s = mid+1
        }
    }
    write("$answer")
    close()
}
