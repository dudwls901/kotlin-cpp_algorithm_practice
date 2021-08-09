//https://www.acmicpc.net/problem/2439

fun main() = with(System.`in`.bufferedReader()){
    with(System.out.bufferedWriter()){
        var n = Integer.parseInt(readLine())
        for(i in 1..n){
            for(i in 0 until n-i){
                write(" ")
            }
            for(i in 0 until i){
                write("*")
            }
            write("\n")
        }
        flush()
        close()
    }
    close()
}
