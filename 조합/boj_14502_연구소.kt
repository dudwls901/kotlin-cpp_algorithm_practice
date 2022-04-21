//https://www.acmicpc.net/problem/14502
import java.util.*
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var graph: Array<IntArray>
lateinit var visited: Array<BooleanArray>
val virus = ArrayList<Pair<Int,Int>>()
var answer=0
val dir = arrayOf(
    arrayOf(0,1),
    arrayOf(1,0),
    arrayOf(0,-1),
    arrayOf(-1,0)
)


fun copyGraph(n: Int, m: Int): Array<IntArray>{
    val temp = Array(n){IntArray(m)}
    for(i in 0 until n){
        for(j in 0 until m){
            temp[i][j] = graph[i][j]
        }
    }
    return temp
}

fun cal(temp: Array<IntArray>): Int{
    var cnt=0
    for(line in temp){
        for(num in line){
            if(num==0){
                cnt++
            }
        }
    }
    return cnt
}

fun bfs(n: Int, m: Int): Int{
    val q: Queue<Pair<Int,Int>> = LinkedList()
    val temp = copyGraph(n,m)
    for(v in virus){
        q.add(v)
    }

    while(q.isNotEmpty()){
        val cur = q.poll()
        for(i in 0 until 4){
            val nr = cur.first + dir[i][0]
            val nc = cur.second + dir[i][1]
            if(nr !in 0 until n || nc !in 0 until m) continue
            if(temp[nr][nc] != 0) continue
            temp[nr][nc] = 2
            q.add(Pair(nr,nc))
        }
    }

    return cal(temp)
}

fun combination(idx: Int, cnt: Int, n: Int, m: Int){
    if(cnt==3){
        //cal
        answer = answer.coerceAtLeast(bfs(n,m))
        return
    }
    for(i in idx until n*m){
        val r = i/m
        val c = i%m
        if(graph[r][c]!=0) continue
        graph[r][c] = 1
        combination(i+1,cnt+1,n,m)
        graph[r][c] = 0
    }
}

fun main() = with(System.out.bufferedWriter()){

    //input
    val (n,m) = getIntList()
    visited = Array(n){BooleanArray(m)}
    graph = Array(n){ r->
        val tk = StringTokenizer(br.readLine())
        IntArray(m){ c->
            val num = tk.nextToken().toInt()
            if(num==2){
                virus.add(Pair(r,c))
            }
            num
        }
    }

    //solve
    combination(0,0,n,m)

    //output
    write("$answer")
    close()
}
