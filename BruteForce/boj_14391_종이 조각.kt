//https://www.acmicpc.net/problem/14391
import kotlin.math.*
var answer=0
val check = Array<BooleanArray>(4){ BooleanArray(4) }

fun sum(n : Int, m : Int, graph : Array<String>) : Int{
    var total =0
    for(r in 0 until n){
        var sum=0
        for(c in 0 until m){
            //가로 연속
            if(check[r][c]){
                sum= sum*10 + Character.getNumericValue(graph[r][c])
            }
            //끊기면 전체 합에 추가
            else{
                total+=sum
                sum=0
            }
        }
        total+=sum
    }
    for(c in 0 until m){
        var sum=0
        for(r in 0 until n){
            //세로 연속
            if(!check[r][c]){
                sum = sum*10 + Character.getNumericValue(graph[r][c])
            }
            //끊기면 전체 합에 추가
            else{
                total+=sum
                sum=0
            }
        }
        total+=sum
    }
    return total
}

fun dfs(r : Int, c : Int, n : Int, m : Int, graph: Array<String>){

    if(r==n){
        answer = max(answer,sum(n,m,graph))
        return
    }
    if(c==m){
        dfs(r+1,0, n, m, graph)
        return
    }
    check[r][c]=true
    dfs(r,c+1,n,m,graph)
    check[r][c]=false
    dfs(r,c+1,n,m,graph)
}


fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array<String>(n){
        val str = br.readLine()
        str
    }
    dfs(0,0,n,m,graph)
    write("$answer")
    close()
}
