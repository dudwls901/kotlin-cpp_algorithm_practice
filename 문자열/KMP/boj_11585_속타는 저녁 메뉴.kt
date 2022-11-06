//https://www.acmicpc.net/problem/11585
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

fun makeTable(pattern: String): IntArray{
    val pi = IntArray(pattern.length)
    var j = 0
    for(i in 1 until pi.size){
        while(j > 0 && pattern[i] != pattern[j]){
            j = pi[j-1]
        }
        if(pattern[i] == pattern[j]){
            pi[i] = ++j
        }
    }
    return pi
}

fun kmp(parent: String, pattern: String, pi: IntArray): Int{
    var i = 0
    var j = 0
    var cnt = 0
    while(i < parent.length){
        if(parent[i] == pattern[j]){
            if(++j == pattern.length){
                cnt++
                j = pi[j-1]
            }
        }else{
            if(j > 0) j = pi[j-1]
        }
        i++
    }
    return cnt
}

fun getGcd(low: Int, high: Int): Int{
    return if(high%low == 0) low
    else getGcd(high%low, low)
}

fun main() = with(System.out.bufferedWriter()){

    val n = getInt()
    val input = br.readLine().replace(" ","")
    val parent = "$input${input.substring(0,input.lastIndex)}"
    val pattern = br.readLine().replace(" ","")
    val pi = makeTable(pattern)
    val cnt = kmp(parent,pattern,pi)
    val gcd = getGcd(cnt,n)
    write("${cnt/gcd}/${n/gcd}")
    close()
}
