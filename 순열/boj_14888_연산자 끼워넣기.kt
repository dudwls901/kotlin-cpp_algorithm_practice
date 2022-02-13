//https://www.acmicpc.net/problem/14888
val br = System.`in`.bufferedReader()

private lateinit var operSet : IntArray
var minAnswer=Int.MAX_VALUE
var maxAnswer=Int.MIN_VALUE
fun cal(n: Int, arr: List<Int>){
    var result=arr[0]
    for(i in 1 until n){
        when(operSet[i-1]){
            0 ->result += arr[i]
            1 -> result -= arr[i]
            2 -> result *= arr[i]
            3 -> result /= arr[i]
        }
    }
    maxAnswer = maxAnswer.coerceAtLeast(result)
    minAnswer = minAnswer.coerceAtMost(result)
}

fun permutation(cnt : Int, end: Int, arr: List<Int>, operator: IntArray){
    if(cnt==end){
        cal(cnt+1, arr)
    }
    for(i in operator.indices){
        if(operator[i]>0){
            operator[i]--
            operSet[cnt]=i
            permutation(cnt+1,end,arr,operator)
            operator[i]++
        }
    }
}

fun main() = with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    val arr = br.readLine().split(' ').map{it.toInt()}
    val operator = br.readLine().split(' ').map{it.toInt()}.toIntArray()
    operSet = IntArray(n)
    permutation(0,n-1,arr,operator)
    write("$maxAnswer\n")
    write("$minAnswer")
    close()
}
