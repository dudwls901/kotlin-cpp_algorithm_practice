//https://www.acmicpc.net/problem/15685
val br = System.`in`.bufferedReader()

fun getIntGraph() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
fun reverseDir(d: Int) = (d+2)%4
fun rotate(d: Int) = (d+3)%4
data class Dragon(
    val r: Int,
    val c: Int,
    val d: Int
)
val dir = arrayOf(
    arrayOf(0,1), //우
    arrayOf(-1,0), //상
    arrayOf(0,-1),//좌
    arrayOf(1,0)//하
)
val graph = Array(101){BooleanArray(101)}
lateinit var curve: Array<ArrayList<Dragon>>

fun move(idx: Int, g: Int){
    //g세대동안 움직이기
    repeat(g){
        for(i in curve[idx].size-1 downTo 1){
            val curD = curve[idx][i].d
            val nextDir = rotate(curD).let { reverseDir(it) }
            val nr = curve[idx][curve[idx].size-1].r + dir[nextDir][0]
            val nc = curve[idx][curve[idx].size-1].c + dir[nextDir][1]
            if(nr !in 0 .. 100 || nc !in 0 .. 100) break
            graph[nr][nc] = true
            curve[idx].add(Dragon(nr,nc,nextDir))
        }
    }
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    curve = Array(n){ ArrayList() }
    for(i in 0 until n){
        val(x,y,d,g) = getIntGraph()
        graph[y][x] = true
        curve[i].add(Dragon(y,x,d))
        val nr =y+dir[d][0]
        val nc = x+dir[d][1]
        if(nr !in 0 ..100 || nc !in 0..100) continue
        curve[i].add(Dragon(nr,nc,d))
        graph[nr][nc] = true
        //solve
        move(i,g)
    }
    //output
    var answer=0
    for(i in 0 until 100){
        for(j in 0 until 100){
            if(graph[i][j] && graph[i][j+1] && graph[i+1][j] && graph[i+1][j+1])
                answer++
        }
    }
    write("$answer")
    close()
}
