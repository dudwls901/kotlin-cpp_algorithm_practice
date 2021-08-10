//https://www.acmicpc.net/problem/10951
import java.util.StringTokenizer
fun main() =with(System.`in`.bufferedReader()){
    with(System.out.bufferedWriter()){

        var s :String?

        while(true){
            s = readLine() ?:break
            var token = StringTokenizer(s)
            write("${Integer.parseInt(token.nextToken())+Integer.parseInt(token.nextToken())}\n")
        }
        flush()
        close()
    }
    close()
}
