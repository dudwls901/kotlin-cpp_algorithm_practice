//https://www.acmicpc.net/problem/22942
import java.util.*
val br = System.`in`.bufferedReader()

data class Node(val x : Int, val isOpen : Boolean, val num : Int)

fun main() = with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    val arr = Array(n*2){Node(0,false,0)}
    var idx=0
    for(i in 0 until n){
        val tk = StringTokenizer(br.readLine())
        val x = tk.nextToken().toInt()
        val r = tk.nextToken().toInt()
        arr[idx++] = Node(x-r,true,i)
        arr[idx++] = Node(x+r,false,i)
    }
    arr.sortBy { it.x }

    val stk = Stack<Node>()

    for(next in arr){

        if(stk.empty()){
            stk.push(next)
        }
        else{
            val cur = stk.lastElement()
            if(cur.num == next.num){
                stk.pop()
            }
            else{
                if(cur.isOpen && !next.isOpen){
                    write("NO")
                    close()
                    return
                }
                stk.push(next)
            }
        }
    }
    write("YES")

    close()
}
