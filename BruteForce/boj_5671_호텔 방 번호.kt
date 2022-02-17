//https://www.acmicpc.net/problem/5671
import java.util.StringTokenizer
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    var input = br.readLine()
    while(input!=null){
        val tk = StringTokenizer(input)
        var n = tk.nextToken().toInt()
        val m = tk.nextToken().toInt()
        var answer=0
        //solve
        while(n<=m){
            val visited = BooleanArray(10)
            val str = n.toString()
            var canBuild=true
            for(i in str.indices){
                if(visited[str[i]-'0']){
                    canBuild=false
                    break
                }
                visited[str[i]-'0'] =true
            }
            if(canBuild) answer++
            n++
        }
        //output
        write("$answer\n")
        //next
        input = br.readLine()
    }
    close()
}
