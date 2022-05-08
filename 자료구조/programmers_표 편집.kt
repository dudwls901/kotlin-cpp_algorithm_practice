//https://programmers.co.kr/learn/courses/30/lessons/81303
import java.util.*

data class Info(
    var before: Int,
    var after: Int
)
class Solution {

    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        //preset
        var answer =  CharArray(n){'O'}
        val linkedList = Array(n){
            Info(it-1, it+1)
        }

        var cursor=k
        val stk = Stack<Int>()
        //solve
        cmd.forEach {
            val tk = StringTokenizer(it)
            val order = tk.nextToken()
            when(order){
                "D"->{
                    val num =tk.nextToken().toInt()
                    for(i in 0 until num){
                        var next = linkedList[cursor].after
                        if(next !in 0 until n) break
                        cursor = next
                    }
                }
                "U"->{
                    val num =tk.nextToken().toInt()
                    for(i in 0 until num){
                        var next = linkedList[cursor].before
                        if(next !in 0 until n) break
                        cursor = next
                    }
                }
                "C"->{
                    stk.push(cursor)
                    val before = linkedList[cursor].before
                    val after = linkedList[cursor].after

                    if(before>=0) {
                        linkedList[before].after = linkedList[cursor].after
                    }
                    if(after<n) {
                        linkedList[after].before = linkedList[cursor].before
                    }
                    if(after>=n){
                        cursor= before
                    }
                    else{
                        cursor= after
                    }
                }
                "Z"->{
                    val next = stk.pop()
                    val before = linkedList[next].before
                    val after = linkedList[next].after
                    if(before>=0)
                        linkedList[before].after =next
                    if(after<n)
                        linkedList[after].before = next
                }
            }
        }

        //output
        while(stk.isNotEmpty()){
            answer[stk.pop()] = 'X'
        }
        return String(answer)
    }
}
