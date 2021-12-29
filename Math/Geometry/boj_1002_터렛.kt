//https://www.acmicpc.net/problem/1002
import java.util.StringTokenizer
import kotlin.math.abs

fun main() = with(System.`in`.bufferedReader()){
    with(System.out.bufferedWriter()){
        val t = Integer.parseInt(readLine())
        for(i in 0 until t){
            val tk = StringTokenizer(readLine())
            val x1 = Integer.parseInt(tk.nextToken())
            val y1 = Integer.parseInt(tk.nextToken())
            val r1 = Integer.parseInt(tk.nextToken())
            val x2 = Integer.parseInt(tk.nextToken())
            val y2 = Integer.parseInt(tk.nextToken())
            val r2 = Integer.parseInt(tk.nextToken())
            val dis = (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)
            //두 정점 간의 거리가 반지름의 합과 같을 때
            if(dis == (r1+r2)*(r1+r2)){
                    write("1\n")
            }
            //두 정점 간의 거리가 0이고 반지름이 같을 때
            else if(dis==0 && r1-r2==0){
                write("-1\n")
            }
            //두 정점 간의 거리가 반지름의 합보다 클 때
            else if(dis>(r1+r2)*(r1+r2)){
                write("0\n")
            }
            //두 정점 간의 거리가 반지름의 합보다 작을 때
            else{
                if(dis<abs(r1-r2)*abs(r1-r2)){
                    write("0\n")
                }
                else if(dis==abs(r2-r1)*abs(r2-r1)){
                    write("1\n")
                }
                else{
                    write("2\n")
                }
            }
        }
        flush()
        close()
    }
    close()
}
