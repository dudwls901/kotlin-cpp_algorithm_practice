//https://www.acmicpc.net/problem/14503
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }

val dir = arrayOf(
    arrayOf(-1,0),
    arrayOf(0,1),
    arrayOf(1,0),
    arrayOf(0,-1)
)
lateinit var graph: Array<IntArray>
var answer = 0
fun simulation(n: Int, m: Int, r: Int, c: Int, d: Int){
    if(graph[r][c]==0) {
        graph[r][c] = 2
        answer++
    }
    var rotate = 4
    var curD = d
    while(rotate>0){
        val nd = (curD+3)%4
        val nr = r+dir[nd][0]
        val nc = c+dir[nd][1]
        if(nr !in 0 until n || nc !in 0 until m || graph[nr][nc] != 0) {
            curD = nd
            rotate--
            continue
        }
        simulation(n,m,nr,nc,nd)
        return
    }
    //4방향 모두 없는 경우
    val nr = r-dir[d][0]
    val nc = c-dir[d][1]
    if(nr in 0 until n && nc in 0 until m && graph[nr][nc] !=1){
        simulation(n,m,nr,nc,d)
    }
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val (n,m) = getIntList()
    val (r,c,d) = getIntList()
    graph = Array(n){ getIntList().toIntArray()}
    //solve
    simulation(n,m,r,c,d)
    //output
    write("$answer")

    close()
}
