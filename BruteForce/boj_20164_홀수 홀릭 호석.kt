//https://www.acmicpc.net/problem/20164
val br = System.`in`.bufferedReader()

fun chToInt(ch: Char) = Character.getNumericValue(ch)
fun getInt() = br.readLine().toInt()
var minAnswer = Int.MAX_VALUE
var maxAnswer = 0
fun backTracking(n: String, cnt: Int){
    var nextCnt = cnt
    for(ch in n){
        if(chToInt(ch)%2!=0) nextCnt++
    }
    if(n.length ==1){
        //end
        minAnswer = minAnswer.coerceAtMost(nextCnt)
        maxAnswer = maxAnswer.coerceAtLeast(nextCnt)
        return
    }
    //길이 2
    if(n.length==2){
        //sC1
        for(i in 1 until n.length){
            val a = n.substring(0,i).toInt()
            val b = n.substring(i).toInt()
            backTracking((a+b).toString(), nextCnt)
        }
    }
    //길이 3
    else{
        //sC2
        for(i in 1 until n.length){
            for(j in i+1 until n.length){
                val a = n.substring(0,i).toInt()
                val b = n.substring(i,j).toInt()
                val c = n.substring(j).toInt()
                backTracking((a+b+c).toString(), nextCnt)
            }
        }
        return
    }
}

fun main() = with(System.out.bufferedWriter()){

    //input
    val n = getInt()
    //solve
    backTracking(n.toString(),0)

    write("$minAnswer $maxAnswer")

    close()
}
