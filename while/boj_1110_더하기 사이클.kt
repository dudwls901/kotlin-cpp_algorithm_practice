//https://www.acmicpc.net/problem/1110

fun main() = with(System.`in`.bufferedReader()) {
    with(System.out.bufferedWriter()) {
        val input = Integer.parseInt(readLine())
        var num=input
        var cnt=0
        do {
            val temp = num/10 + num%10
            num = num%10*10+temp%10
            cnt++
        }while(num!=input)
        write("$cnt")
        close()
    }
    close()
}
