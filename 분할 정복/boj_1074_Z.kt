//https://www.acmicpc.net/problem/1074
import java.util.StringTokenizer

var answer = 0
var cnt = 0
fun recurCal(size: Int, rr: Int, cc: Int, r: Int, c: Int) {
    if (rr == r && cc == c) {
        answer = cnt
        return
    }

    if (rr + size > r && rr <= r && cc + size > c && cc <= c) {
        recurCal(size / 2, rr, cc, r, c)
        recurCal(size / 2, rr, cc + size / 2, r, c)
        recurCal(size / 2, rr + size / 2, cc, r, c)
        recurCal(size / 2, rr + size / 2, cc + size / 2, r, c)
    } else {
        cnt += size * size
    }
}

fun main() = with(System.out.bufferedWriter()) {
    with(System.`in`.bufferedReader()){
        val tk =StringTokenizer(readLine())
        var n = Integer.parseInt(tk.nextToken())
        val r = Integer.parseInt(tk.nextToken())
        val c = Integer.parseInt(tk.nextToken())
        var size= 1
        for(i in 0 until n){
            size *=2
        }
        recurCal(size,0,0,r,c)
        write("$answer")
        close()
    }
    close()
}
