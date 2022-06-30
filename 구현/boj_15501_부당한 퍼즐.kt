//https://www.acmicpc.net/problem/15501
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    val origin = getIntList()
    var result = getIntList()
    var firstIdx = 0
    var same = true
    for(i in result.indices){
        if(origin[0] == result[i]){
            firstIdx = i
        }
    }
    for(i in origin.indices){
        if(origin[i] != result[(firstIdx+i)%origin.size]){
            same = false
            break
        }
    }
    if(!same) {
        result = result.reversed()
        for (i in result.indices) {
            if (origin[0] == result[i]) {
                firstIdx = i
            }
        }
        for (i in origin.indices) {
            if (origin[i] != result[(firstIdx + i) % origin.size]) {
                write("bad puzzle")
                close()
                return
            }
        }
    }
    write("good puzzle")
    close()
}
