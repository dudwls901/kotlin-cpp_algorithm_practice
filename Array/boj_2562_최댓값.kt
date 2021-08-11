//https://www.acmicpc.net/problem/2562

fun main() = with(System.`in`.bufferedReader()){
    with(System.out.bufferedWriter()){
        val arr = ArrayList<Int>()
        for(i in 0 until 9){
            arr.add(Integer.parseInt(readLine()))
        }
        val max = arr.maxOrNull()
        write("$max\n${arr.indexOf(max)+1}")
        close()
    }
    close()
}
