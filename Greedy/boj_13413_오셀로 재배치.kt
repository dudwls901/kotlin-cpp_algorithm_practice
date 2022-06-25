//https://www.acmicpc.net/problem/13413
val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()){

    repeat(getInt()){
        //input
        val n = getInt()
        val before = br.readLine()
        val after = br.readLine()
        val diff = intArrayOf(0,0)
        //solve
        for(i in before.indices){
            val a = before[i]
            val b = after[i]
            if(a!=b){
                if(a=='W') diff[0]++
                else diff[1]++
            }
        }
        //output
        write("${diff[0].coerceAtLeast(diff[1])}\n")
    }
    close()
}
