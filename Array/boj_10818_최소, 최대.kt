//https://www.acmicpc.net/problem/10818

fun main() = with(System.`in`.bufferedReader()){
    with(System.out.bufferedWriter()){
        val n = Integer.parseInt(readLine())
        val arr = readLine().split(' ').map{Integer.parseInt(it)}
        write("${arr.minOrNull()} ${arr.maxOrNull()}\n")
        close()
    }
    close()
}
