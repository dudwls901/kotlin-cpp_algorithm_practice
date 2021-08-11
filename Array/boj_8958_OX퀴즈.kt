//https://www.acmicpc.net/problem/8958

fun main()=with(System.`in`.bufferedReader()){
    with(System.out.bufferedWriter()){
        val t = Integer.parseInt(readLine())
        for(i in 0 until t){
            val str = readLine()
            val arr = IntArray(str.length)
            var score=1
            for(j in 0 until str.length){
                if(str[j]=='O'){
                    arr[j]=score++
                }
                else{
                    score=1
                }
            }
            write("${arr.sum()}\n")
        }
        close()
    }
    close()
}
