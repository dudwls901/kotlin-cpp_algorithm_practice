//https://www.acmicpc.net/problem/2884
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())
    var h = Integer.parseInt(token.nextToken())
    var m = Integer.parseInt(token.nextToken())
    m-=45
    if (m < 0) {
        m += 60
        h-=1
        if(h<0)
            h+=24
    }
    print("$h $m")
}
