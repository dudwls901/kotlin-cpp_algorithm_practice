//https://www.acmicpc.net/problem/2866
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getStr() = br.readLine().trim()
fun getInt() = br.readLine().trim().toInt()

lateinit var reversedInput: Array<String>
lateinit var input: Array<String>
fun main() = with(System.out.bufferedWriter()){
    //input
    val (r,c) = getIntList()
    input = Array(r){ getStr() }

    var s = 0
    var e = r-2
    var answer = 0

    //preset
    makeReversedInput(c,input)
    
    //solve
    while(s<=e){
        val mid = (s+e)/2
        if(canRemove(mid)){
            answer = mid+1
            s = mid+1
        }else{
            e = mid-1
        }
    }
    //output
    write("$answer")
    close()
}

fun makeReversedInput(n: Int, input: Array<String>){

    reversedInput = Array(n){ c->
        val sb = StringBuilder()
        for(r in input.indices){
            sb.append(input[r][c])
        }
        sb.toString()
    }
}

fun canRemove(c: Int): Boolean{
    val se = mutableSetOf<String>()
    for(str in reversedInput){
        val truncatedStr = str.substring(c+1)
        if(se.contains(truncatedStr)) return false
        se.add(truncatedStr)
    }
    return true
}
