//https://www.acmicpc.net/problem/10952
import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()){
    with(System.out.bufferedWriter()) {

        while(true){
            val token = StringTokenizer(readLine());
            var a = Integer.parseInt(token.nextToken())
            var b = Integer.parseInt(token.nextToken())
            if(a+b==0)break else write("${a+b}\n")
        }

        flush()
        close()
    }
    close()
}
