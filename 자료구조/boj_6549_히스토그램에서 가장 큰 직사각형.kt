//https://www.acmicpc.net/problem/6549
import java.util.*
import kotlin.math.*
fun main()=with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    while(true){
        val tk = StringTokenizer(br.readLine())
        val n = Integer.parseInt(tk.nextToken())
        if(n==0){
            break
        }
        val stack = Stack<Int>()
        val high = LongArray(n+2)
        var answer = 0L
        var num : Long
        stack.push(0)

        for(i in 1 .. n+1){
            if(i==n+1){
                num = 0
            }
            else {
                num = tk.nextToken().toLong()
            }
            high[i]=num
            while(stack.isNotEmpty() && high[stack.peek()]>num){
                val highIdx = stack.pop()
                answer = max(answer, high[highIdx]*(i-stack.peek()-1))
            }
            stack.push(i)
        }
        write("$answer\n")
    }
    close()
}
