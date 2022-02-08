//https://www.acmicpc.net/problem/6416
import java.util.*
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var t = 1
    var twoEdge=false
    val inDegree = IntArray(14)
    val visited = BooleanArray(14)
    var isFirstZero = true
    val set = HashSet<Int>()
    var edgeCnt=0
    loop@ while (true) {
        val tk = StringTokenizer(br.readLine())

        while (tk.hasMoreTokens()) {
            val from = tk.nextToken().toInt()
            val to = tk.nextToken().toInt()

            //프로그램 종료
            if (from == -1) {
                close()
                return;
            }
            //이미 진입 차수가 있는 경우
            if (inDegree[to] == 1) {
                twoEdge=true
                continue@loop
            }
            inDegree[to]++
            //테스트케이스 종료
            if (from == 0 && to == 0) {
                var root = 0
                for (i in 0 until 14) {
                    if (inDegree[i] == 0 && set.contains(i)) {
                        root++
                    }
                }
                if(isFirstZero){
                    write("Case $t is a tree.\n")
                }
                else {
                    if (root == 0 || twoEdge || set.size-1!=edgeCnt) {
                        write("Case $t is not a tree.\n")
                    } else {
                        write("Case $t is a tree.\n")
                    }
                }
                //reset
                isFirstZero=true
                twoEdge=false
                set.clear()
                t++
                edgeCnt=0
                for(i in 0 until 14){
                    inDegree[i]=0
                    visited[i]=false
                }
                continue@loop
            }
            set.add(from)
            set.add(to)
            edgeCnt++
            isFirstZero=false
        }
    }

    close()
}
