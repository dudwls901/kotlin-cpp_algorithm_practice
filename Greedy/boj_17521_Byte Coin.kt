//https://www.acmicpc.net/problem/17521
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {

    var (n, w) = br.readLine().split(' ').map { it.toLong() }
    val cost = LongArray(n.toInt())
    cost[0] = br.readLine().toLong()
    var stockCnt = 0L

    for (i in 1 until n.toInt()) {
        cost[i] = br.readLine().toLong()
        //상승장
        if (cost[i - 1] < cost[i]) {
            //저점 매수
            if(stockCnt==0L) {
                stockCnt = w / cost[i - 1]
                w %= cost[i - 1]
            }
            //마지막 날
            if (i == n.toInt() - 1) {
                //남은 주식 매도
                if (stockCnt > 0) {
                    w += stockCnt * cost[i]
                }
            }
        }
        //하락장
        else {
            //고점 매도
            w += cost[i - 1] * stockCnt
            stockCnt = 0L
        }
    }
    write("$w")

    close()
}
