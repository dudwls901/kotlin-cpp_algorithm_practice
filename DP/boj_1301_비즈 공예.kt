//https://www.acmicpc.net/problem/1301
val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().toInt()
val dp = Array(11) { Array(11) { Array(11) { Array(11) { Array(11) { Array(6) { LongArray(6){-1} } } } } } }
// f = 전전
// g = 전
fun makeDp(beads: IntArray, f: Int, g: Int) : Long{
    val a = beads[1]
    val b = beads[2]
    val c = beads[3]
    val d = beads[4]
    val e = beads[5]
    if(a==0 && b==0 && c==0 && d==0 && e==0) return 1
    var ret:Long = dp[a][b][c][d][e][f][g]
    if(ret != -1L) return ret
    ret = 0
    for(i in 1 .. 5){
        if(f != i && g != i && beads[i] >0){
            beads[i]--
            ret += makeDp(beads,g,i)
            beads[i]++
        }
    }
    dp[a][b][c][d][e][f][g] = ret
    return ret
}

fun main() = with(System.out.bufferedWriter()) {
    val n = getInt()
    val beads = IntArray(6)
    for(i in 1 .. n){
        beads[i] = getInt()
    }
    write("${makeDp(beads,0,0)}")
    close()
}
