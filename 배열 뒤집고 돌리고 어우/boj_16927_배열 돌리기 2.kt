//https://www.acmicpc.net/problem/16927
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var graph: Array<IntArray>

fun rotate(a: Int, b: Int, t: Int){
    var n = a
    var m = b
    var sr = 0
    var sc = 0
    //바깥 테두리부터
    label@while(n>0 && m>0) {
    	//뎁스별로 전체 회전 횟수 r을 나눈 값이 달라야 한다.
        repeat(t % (n * 2 + (m - 2) * 2)) {
            var r = sr
            var c = sc
            var temp = graph[r][c]
            //좌 세로
            while (r + 1 < sr + n) {
                graph[r + 1][c] = temp.also { temp = graph[r + 1][c] }
                r++
            }
            //하 가로
            while (c + 1 < sc + m) {
                graph[r][c + 1] = temp.also { temp = graph[r][c + 1] }
                c++
            }
            //우 세로
            while (r - 1 >= sr) {
                graph[r - 1][c] = temp.also { temp = graph[r - 1][c] }
                r--
            }
            //상 가로
            while (c - 1 >= sc) {
                graph[r][c - 1] = temp.also { temp = graph[r][c - 1] }
                c--
            }
        }
        sr++
        sc++
        n -= 2
        m -= 2
    }
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val (n,m,r) = getIntList()
    graph = Array(n){ getIntList().toIntArray()}
    //solve
    rotate(n,m,r)
    //output
    for(i in 0 until n){
        for(j in 0 until m){
            write("${graph[i][j]} ")
        }
        write("\n")
    }
    close()
}
