//https://www.acmicpc.net/problem/15658
val br = System.`in`.bufferedReader()

fun getInt() = br.readLine().toInt()
fun getIntList() = br.readLine().split(' ').map{it.toInt()}

lateinit var numArr: List<Int>
lateinit var opArr: IntArray
var maxAns = -Int.MAX_VALUE
var minAns = Int.MAX_VALUE

fun cal(num1: Int, num2: Int, op: Int): Int{
    return when(op){
        0->{
            num1+num2
        }
        1->{
            num1-num2
        }
        2->{
            num1*num2
        }
        else->{
            num1/num2
        }
    }
}

fun permutation(result: Int, idx: Int, n: Int){
    if(idx==n){
        maxAns = maxAns.coerceAtLeast(result)
        minAns = minAns.coerceAtMost(result)
        return
    }

    for(i in 0 until 4){
        if(opArr[i]<=0) continue
        opArr[i]--
        permutation(cal(result,numArr[idx],i),idx+1,n)
        opArr[i]++
    }

}

fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    numArr = getIntList()
    opArr = getIntList().toIntArray()

    //solve
    permutation(numArr[0],1,n)

    //output
    write("$maxAns\n$minAns")
    close()
}
