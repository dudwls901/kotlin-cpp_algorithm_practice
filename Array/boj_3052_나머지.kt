//https://www.acmicpc.net/problem/3052

fun main()=with(System.`in`.bufferedReader()){
    with(System.out.bufferedWriter()){
        val arr = BooleanArray(42)
        for(i in 0 until 10){
            val num = Integer.parseInt(readLine())
            arr[num%42]=true
        }
        var cnt=0
        for(i in arr){
            if(i)
            cnt++
        }
        write("$cnt")
        
        close()
    }
    close()
}
