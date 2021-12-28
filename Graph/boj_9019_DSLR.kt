//https://www.acmicpc.net/problem/9019
import java.util.*
val br = System.`in`.bufferedReader()

fun bfs(from : Int, to : Int, visited : BooleanArray) : String{

    val q : Queue<Pair<Int,String>> = LinkedList<Pair<Int,String>>()
    q.add(Pair(from,""))
    visited[from]=true

    while(q.isNotEmpty()){
        val cur = q.poll()
        val curNum = cur.first
        //D
        var next = (curNum*2)%10000
        if(next==to){
            return cur.second+"D"
        }
        if(!visited[next]){
            q.add(Pair(next,cur.second+"D"))
            visited[next]=true
        }
        //S
        next = if(curNum-1 <0) 9999 else curNum-1
        if(next==to){
            return cur.second+"S"
        }
        if(!visited[next]){
            q.add(Pair(next,cur.second+"S"))
            visited[next]=true
        }
        //L
        next = (curNum%1000)*10+curNum/1000
        if(next==to){
            return cur.second+"L"
        }
        if(!visited[next]){
            q.add(Pair(next,cur.second+"L"))
            visited[next]=true
        }
        //R
        next = (curNum%10)*1000+(curNum/10)%1000
        if(next==to){
            return cur.second+"R"
        }
        if(!visited[next]) {
            q.add(Pair(next, cur.second +"R"))
            visited[next] = true
        }
    }
    return "NO"
}

fun main() = with(System.out.bufferedWriter()){

    var t = br.readLine().toInt()
    for(i in 0 until t){
        val (from, to) = br.readLine().split(' ').map{it.toInt()}
        val visited = BooleanArray(10000)
        write("${bfs(from,to,visited)}\n")
    }
    close()
}
