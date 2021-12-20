//https://www.acmicpc.net/problem/1525
//코드3 : 좌표 이동 방식 변경(nr,nc구해서 문자열 인덱스로 변)
import java.util.*
val dirXY = arrayOf(arrayOf(0,1),arrayOf(0,-1),arrayOf(1,0),arrayOf(-1,0))
//val dir = arrayOf(1,3,-1,-3)
val br = System.`in`.bufferedReader()
val visited = mutableSetOf<Int>()
fun bfs(input : String) : Int{
    //pair.first = 상태, pair.second = 이동횟수
    val q : Queue<Pair<String,Int>> = LinkedList<Pair<String,Int>>()
    q.add(Pair(input,0))
    visited.add(input.toInt())
    while(q.isNotEmpty()){
        val cur = q.poll()
        val curIdx = cur.first.indexOf('0')
        val cr = curIdx/3
        val cc = curIdx%3
        if (cur.first == "123456780") return cur.second
        for (j in 0 until 4) {
            val nr = cr + dirXY[j][0]
            val nc = cc + dirXY[j][1]
            //그래프 벗어나면 스킵
            if(nr !in 0 until 3 || nc !in 0 until 3) continue
            //nr,nc로 문자열에서 0의 인덱스 구하기
            val nextIdx = nr*3+nc
            var nextState = cur.first
            var temp = nextState.toCharArray()
            //swap
            temp[curIdx] = temp[nextIdx].also { temp[nextIdx] = temp[curIdx] }
            nextState = String(temp)
            if (visited.contains(nextState.toInt())) continue
            q.add(Pair(nextState, cur.second+1))
            visited.add(nextState.toInt())
        }
    }
    return -1
}
fun main() = with(System.out.bufferedWriter()){
    var input = (br.readLine()+br.readLine()+br.readLine()).replace(" ","")
    write("${bfs(input)}")
    close()
}
