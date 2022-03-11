//https://www.acmicpc.net/problem/17135
val br = System.`in`.bufferedReader()
lateinit var graph: Array<IntArray>
//왼 위 오
val dir = arrayOf(arrayOf(0, -1), arrayOf(-1, 0), arrayOf(0, 1))
val archor = IntArray(3)
var answer = 0

fun down(temp1: Array<IntArray>, temp2: Array<IntArray>, n: Int, m: Int) {
    for (r in n - 1 downTo 0) {
        for (c in 0 until m) {
            var num = 0
            if (r > 0) {
                num = temp1[r - 1][c]
            }
            temp1[r][c] = num
            temp2[r][c] = num
        }
    }
}

fun solve(n: Int, m: Int, d: Int) {
    val temp1 = Array(n) { IntArray(m) }
    val temp2 = Array(n) {IntArray(m)}
    for (i in 0 until n) {
        for (j in 0 until m) {
            temp1[i][j] = graph[i][j]
            temp2[i][j] = graph[i][j]
        }
    }

    var sum = 0


    //n턴이 지나면 적이 아에 없음
    for (turn in 0 until n) {

        //3명의 궁수
        for (i in 0 until 3) {
            val c = archor[i]
            var r = n
            //d범위만큼 확인
            loop@ for (arrange in 1 .. d) {
                 for (i in -arrange .. arrange) {
                    val nr = r-(arrange-kotlin.math.abs( i))
                    val nc = c+i
                    if (nr !in 0 until n || nc !in 0 until m) continue
                    //적이 있을 때
                    if (temp1[nr][nc] == 1) {
                        if(temp2[nr][nc]==1){
                            sum++
                        }
                        temp2[nr][nc]=0
                        break@loop
                    }
                }
            }

        }
        //한 턴 끝난 후 한 칸 다운, temp2->temp1
        for(i in 0 until n){
            for(j in 0 until m){
                temp1[i][j] = temp2[i][j]
            }
        }
        down(temp1,temp2, n, m)
    }
    answer = answer.coerceAtLeast(sum)
}

//3명의 궁수 자리 선정해서 solve
fun combination(len: Int, idx: Int, n: Int, m: Int, d: Int) {
    if (len == 3) {
        solve(n, m, d)
        return
    }
    for (i in idx until m) {
        archor[len] = i
        combination(len + 1, i + 1, n, m, d)
    }
}


fun main() = with(System.out.bufferedWriter()) {

    val (n, m, d) = br.readLine().split(' ').map { it.toInt() }
    graph = Array(n) { br.readLine().split(' ').map { it.toInt() }.toIntArray() }

    combination(0, 0, n, m, d)
    write("$answer")
    close()
}
