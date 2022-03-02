//https://www.acmicpc.net/problem/17070
val br = System.`in`.bufferedReader()

lateinit var graph: Array<List<Int>>
var answer=0
var n=0
val dir = arrayOf(arrayOf(0,1), arrayOf(1,0),arrayOf(1,1))


fun dfs(r: Int, c: Int, direct: Int){

    if(r==n-1 && c==n-1){
        answer++
        return
    }

    for(i in 0 until 3){
        if(direct xor 1 ==i) continue
        val nr = r + dir[i][0]
        val nc = c + dir[i][1]
        if(nr !in 0 until n || nc !in 0 until n) continue
        if(i==2){
            if(nr-1 <0 || nc-1 < 0 || graph[nr][nc]==1 || graph[nr-1][nc] == 1 || graph[nr][nc-1] ==1) continue
        }
        else{
            if(graph[nr][nc]==1) continue
        }
        dfs(nr,nc,i)
    }

}
//3<=n<=16
fun main() = with(System.out.bufferedWriter()){

    n = br.readLine().toInt()
    graph = Array(n){br.readLine().split(' ').map{it.toInt()}}
    dfs(0,1, 0)
    write("$answer")
    close()
}
