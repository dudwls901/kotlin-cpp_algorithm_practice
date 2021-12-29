//https://www.acmicpc.net/problem/17425
val MAX = 1000001
val br = System.`in`.bufferedReader()
//1<=n<=1000000
val g = LongArray(MAX){1}

fun solveF(){
    for(i in 2 until MAX){
        for(j in i until MAX step i){
            g[j]+=i.toLong()
        }
    }
}

fun solveG(){
    for(i in 2 until MAX){
        g[i] += g[i-1]
    }
}

fun main() = with(System.out.bufferedWriter()){
    val t = br.readLine().toInt()
    solveF()
    solveG()
    repeat(t){
        write("${g[br.readLine().toInt()]}\n")
    }
    close()
}
