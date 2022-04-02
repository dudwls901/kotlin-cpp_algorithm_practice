//https://www.acmicpc.net/problem/17427
val br = System.`in`.bufferedReader()

lateinit var g: LongArray
var n = 0

//에라토스테네스의 체
fun solveF(){
    for(i in 2 .. n){
        for(j in i ..n step i ){
            g[j]+=i.toLong()
        }
    }
}

//누적합
fun solveG(){
   for(i in 2 .. n) {
       g[i] += g[i-1]
   }
}


fun main() = with(System.out.bufferedWriter()) {

    n = br.readLine().toInt()
    g = LongArray(n+1){1}

    solveF()
    solveG()

    write("${g[n]}")
    close()
}
