//https://www.acmicpc.net/problem/9094
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    val t = br.readLine().toInt()
    repeat(t){
        val (n,m) = br.readLine().split(' ').map{it.toInt()}
        var answer=0
        for(i in 1 until n-1){
            for(j in i+1 until n){
                if((i*i+j*j+m)%(i*j)==0){
                    answer++
                }
            }
        }
        write("$answer\n")
    }

    close()
}
