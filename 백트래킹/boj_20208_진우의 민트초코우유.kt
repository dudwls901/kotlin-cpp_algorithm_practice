//https://www.acmicpc.net/problem/20208
import kotlin.math.abs
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

lateinit var graph: Array<IntArray>
var answer = 0
var sr = 0
var sc = 0
val milks = ArrayList<Pair<Int,Int>>()

fun main()= with(System.out.bufferedWriter()){

    //input
    val(n,m,h) = getIntList()
    graph = Array(n){r ->
        val list = getIntList()
        for(c in list.indices){
            if(list[c] == 1){
                sr = r
                sc = c
            }else if(list[c] == 2){
                milks.add(Pair(r,c))
            }
        }
        list.toIntArray()
    }

    //solve
    backTracking(sr,sc,0, BooleanArray(milks.size),n,m,h)
    //output
    write("$answer")
    close()
}

fun backTracking(r: Int,c: Int, cnt: Int, visited: BooleanArray, n: Int, curHP: Int, h: Int) {
    val goHome = curHP-(Math.abs(sr-r) + Math.abs(sc-c))
    if(goHome>=0){
        answer = answer.coerceAtLeast(cnt)
    }
    for(i in milks.indices){
        if(visited[i]) continue
        val (nr,nc) = milks[i]
        val diff = curHP-(Math.abs(r-nr) + Math.abs(c-nc))
        if(diff < 0) continue
        visited[i] = true
        backTracking(nr,nc, cnt+1, visited, n, diff + h,h)
        visited[i] = false
    }
}
