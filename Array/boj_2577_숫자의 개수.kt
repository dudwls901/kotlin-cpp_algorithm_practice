//https://www.acmicpc.net/problem/2577

fun main() = with(System.`in`.bufferedReader()){
    with(System.out.bufferedWriter()){
        var num=1
        val arr = IntArray(10,{0})
        for( i in 0 until 3){
            num *= Integer.parseInt(readLine())
        }
        val str = num.toString()
        for(i in str){
            arr[Character.getNumericValue(i)]++
        }
        for(i in arr){
            write("$i\n")
        }
        close()
    }
    close()
}
