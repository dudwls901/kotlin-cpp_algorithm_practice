//https://www.acmicpc.net/problem/1992
val br = System.`in`.bufferedReader()
var answer =0
val bw = System.out.bufferedWriter()
fun dfs(r : Int, c : Int, n : Int, graph : Array<String>){

    val ch = graph[r][c]
    var finish = true
    
    for(i in r until r+n){
        for(j in c until c+n){
            if(ch!=graph[i][j]){
                finish=false
                break
            }
        }
        if(!finish)
            break
    }

    //다음 뎁스
    if(!finish){
        bw.write("(")
        dfs(r,c,n/2,graph)
        dfs(r,c+n/2,n/2,graph)
        dfs(r+n/2,c,n/2,graph)
        dfs(r+n/2,c+n/2,n/2,graph)
        bw.write(")")
    }
    //출력 후 종료
    else{
        bw.write("$ch")
        return
    }

}

fun main(){
    val n = br.readLine().toInt()
    val graph = Array(n){br.readLine()}
    dfs(0,0,n,graph)
    bw.close()
}
