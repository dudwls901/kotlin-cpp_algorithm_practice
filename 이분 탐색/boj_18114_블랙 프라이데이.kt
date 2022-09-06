//https://www.acmicpc.net/problem/18114
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var visited: BooleanArray

fun biSearch(search: Int, input: IntArray, ): Boolean {

    var s = 0
    var e = input.size - 1
    while (s <= e) {
        val mid = (s + e) / 2
        if (input[mid] > search) {
            e = mid - 1
        } else if (input[mid] < search) {
            s = mid + 1
        } else if(input[mid] == search){
            if(visited[mid]) e = mid - 1
            else return true
        }
    }
    return false
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, c) = getIntList()
    val input = getIntList().toIntArray()
    visited = BooleanArray(n)
    //solve
    input.sort()
    //하나만 선택
    if(biSearch(c,input)){
        write("1")
        close()
        return
    }
    for (i in input.indices) {
        //두개 선택
        visited[i] = true
        if(biSearch(c-input[i],input)){
            write("1")
            close()
            return
        }
        //세개 선택
        for (j in i + 1 until input.size) {
            visited[j] = true
            if(biSearch(c - (input[i] + input[j]),input)){
                write("1")
                close()
                return
            }
            visited[j] = false
        }
        visited[i] = false
    }
    write("0")
    close()
}
