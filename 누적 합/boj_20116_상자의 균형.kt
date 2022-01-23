//https://www.acmicpc.net/problem/20116
val br = System.`in`.bufferedReader()
//1<=n<=200000
//1<=L<=10^9
fun main() = with(System.out.bufferedWriter()){

    val (n,l) = br.readLine().split(' ').map{it.toInt()}
    val input = br.readLine().split(' ').map{it.toInt()}
    val pSum = DoubleArray(n)
    pSum[0] = input[0].toDouble()

    for(i in 1 until n){
        pSum[i] = pSum[i-1]+input[i]
    }

    for(i in 0 until n-1){
        if((pSum[n-1]-pSum[i])/(n-1-i) <= input[i]-l || (pSum[n-1]-pSum[i])/(n-1-i) >= input[i]+l){
            write("unstable")
            close()
            return
        }
    }
    write("stable")

    close()
}
