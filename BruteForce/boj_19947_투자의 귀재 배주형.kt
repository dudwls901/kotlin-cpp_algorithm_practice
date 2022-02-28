//https://www.acmicpc.net/problem/19947
val br = System.`in`.bufferedReader()
var answer=0

fun dfs(h: Int, y: Int){
    if(y==0){
        answer = answer.coerceAtLeast(h)
        return
    }
    if(y-1>=0){
        dfs((h*1.05).toInt(),y-1)
    }
    if(y-3>=0){
        dfs((h*1.2).toInt(),y-3)
    }
    if(y-5>=0){
        dfs((h*1.35).toInt(),y-5)
    }
}

fun main() = with(System.out.bufferedWriter()){

    val (h,y) = br.readLine().split(' ').map{it.toInt()}
    dfs(h,y)
    write("$answer")
    close()
}
