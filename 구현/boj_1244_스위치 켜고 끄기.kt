//https://www.acmicpc.net/problem/1244
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val input = br.readLine().split(' ').map { it.toInt() }.toIntArray()
    val switchArr = IntArray(n+1)
    for(i in 1 .. n){
        switchArr[i] = input[i-1]
    }
    val m = br.readLine().toInt()
    for (i in 0 until m) {

        var (sex, idx) = br.readLine().split(' ').map { it.toInt() }
        when (sex) {
            //남학생
            1 -> {
                val plus = idx
                while(idx<=n){
                    (switchArr[idx] xor 1).also { switchArr[idx] = it }
                    idx+=plus
                }
            }
            //여학생
            else -> {
                for(j in 0 until n/2){
                    if(idx+j <=n && idx-j >0 && switchArr[idx+j] == switchArr[idx-j]){
                            (switchArr[idx+j] xor 1).also {
                            switchArr[idx + j] = it
                            switchArr[idx - j] = it
                        }
                    }
                    else break
                }
            }
        }
    }
    var idx=1
    while(idx<=n){
        if(idx%20==0 && idx!=0){
            write("${switchArr[idx]}\n")
        }
        else{
            write("${switchArr[idx]} ")
        }
        idx++
    }
    close()
}
