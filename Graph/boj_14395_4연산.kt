//https://www.acmicpc.net/problem/14395
import java.util.*

val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

val map = mutableMapOf(
    Pair(0,'*'),
    Pair(1,'+'),
    Pair(2,'-'),
    Pair(3,'/')
)
val visited = mutableSetOf<Long>()

fun cal(num: Long, ch: Char) : Long{
    return when(ch){
        '*' -> num*num
        '+' -> num+num
        '-' -> num-num
        '/' -> num/num
        else -> 0
    }
}

fun bfs(s: Int, t: Int) : String {
    val q : Queue<Pair<Long,StringBuilder>> = LinkedList()
    q.add(Pair(s.toLong(), StringBuilder()))

    while(q.isNotEmpty()){
        val cur = q.poll()

        for(i in 0 until 4){
            //0인 경우 나누기 스킵
            if(cur.first==0L && i==3) continue

            val nextNum = cal(cur.first,map[i]!!)
            cur.second.append(map[i])
            //종료
            if(nextNum == t.toLong()){
                return cur.second.toString()
            }
            if(visited.contains(nextNum)) {
                cur.second.deleteCharAt(cur.second.lastIndex)
                continue
            }
            q.add(Pair(nextNum, StringBuilder(cur.second)))
            visited.add(nextNum)
            cur.second.deleteCharAt(cur.second.lastIndex)
        }
    }
    return "-1"
}

fun main() = with(System.out.bufferedWriter()){

    //input
    val (s,t) = getIntList().apply{
        if(this[0] == this[1]){
            write("0")
            close()
            return
        }
    }
    //solve, output
    write("${bfs(s,t)}")

    close()
}
