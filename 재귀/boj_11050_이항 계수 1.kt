//https://www.acmicpc.net/problem/11050
val br = System.`in`.bufferedReader()
val facto = IntArray(11){1}

fun makeFacto(n : Int) : Int{
    if(n==1){
        return 1
    }
    return (n*makeFacto(n-1)).also{ facto[n] = it }
}


fun main() = with(System.out.bufferedWriter()){
    val (n ,m) = br.readLine().split(' ').map{it.toInt()}
    facto[1]=1
    makeFacto(n)
    write("${facto[n]/facto[n-m]/facto[m]}")
    close()
}
