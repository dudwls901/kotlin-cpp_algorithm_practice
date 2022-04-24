//https://www.acmicpc.net/problem/12886
import java.util.*
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
//fun Char.chToInt() = Character.getNumericValue()
fun chToInt(ch: Char) = Character.getNumericValue(ch)

data class State(
    val a: Int,
    val b: Int,
    val c: Int
)

val visited = Array(1501){BooleanArray(1501)}


fun move(cur: State,dir: Int): State{
    when(dir){
        0->{
            if(cur.a<cur.b){
                return State(cur.a*2, cur.b-cur.a, cur.c)
            }
        }
        1->{
            if(cur.a>cur.b){
                return State(cur.a-cur.b, cur.b*2, cur.c)
            }
        }
        2->{
            if(cur.b<cur.c){
                return State(cur.a, cur.b*2, cur.c-cur.b )
            }
        }
        3->{
            if(cur.b>cur.c){
                return State(cur.a, cur.b-cur.c, cur.c*2)
            }
        }
        4->{
            if(cur.a<cur.c){
                return State(cur.a*2,cur.b,cur.c-cur.a)
            }
        }
        else->{
            if(cur.a>cur.c){
                return State(cur.a-cur.c, cur.b, cur.c*2)
            }
        }
    }
    return cur
}

fun bfs(a: Int, b: Int, c: Int): Int{
    val q: Queue<State> = LinkedList()
    q.add(State(a,b,c))

    while(q.isNotEmpty()){
        val cur = q.poll()

        //종료 검사
        if(cur.a == cur.b && cur.a  == cur.c) return 1
        
        for(i in 0 until 6){
            val next = move(cur, i)
//            println(next)
            if(visited[next.a][next.b]) continue
            visited[next.a][next.b] = true
            q.add(next)
        }

    }

 return 0
}


fun main() = with(System.out.bufferedWriter()){

    //input
    val (a,b,c) = getIntList().also {
        if(it.sum()%3 !=0){
            write("0")
            close()
            return
        }
    }

    //solve
    visited[a][b] = true
    write("${bfs(a,b,c)}")

    close()
}
