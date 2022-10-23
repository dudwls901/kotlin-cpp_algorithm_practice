//https://www.acmicpc.net/problem/2628
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun main() = with(System.out.bufferedWriter()){

    val (x,y) = getIntList()
    val rArr = ArrayList<Int>()
    val cArr = ArrayList<Int>()
    rArr.add(y)
    cArr.add(x)
    rArr.add(0)
    cArr.add(0)
    repeat(getInt()){
        val(order,num) = getIntList()
        if(order==0){
            rArr.add(num)
        }else{
            cArr.add(num)
        }
    }
    rArr.sort()
    cArr.sort()
    var maxR = 0
    var maxC = 0
    for(i in 1 until rArr.size){
        maxR = maxR.coerceAtLeast(rArr[i]-rArr[i-1])
    }
    for(i in 1 until cArr.size){
        maxC = maxC.coerceAtLeast(cArr[i]-cArr[i-1])
    }
    write("${maxR * maxC}")
    close()
}
