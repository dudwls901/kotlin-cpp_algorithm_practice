//https://www.acmicpc.net/problem/17406
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
lateinit var oper: Array<List<Int>>
lateinit var visited: BooleanArray
var answer = Int.MAX_VALUE
/*
* 회전 연산 조합
* 순열 결과로 회전, A 최솟값 갱신
* */

fun rotate(op: List<Int>, graph: Array<IntArray>){
    var sr = op[0]-1-op[2]
    var sc = op[1]-1-op[2]
    var er = op[0]-1+op[2]
    var ec = op[1]-1+op[2]
    var n = er-sr
    var m = ec-sc
    var cnt = op[2]
    while (cnt>0){
        var r = sr
        var c = sc
        var temp = graph[r+1][c]
        //우
        for(i in 0 until n){
            graph[r][c] = temp.also{temp = graph[r][c]}
            c++
        }
        //하
        for(i in 0 until n){
            graph[r][c] = temp.also{temp = graph[r][c]}
            r++
        }
        //좌
        for(i in 0 until n){
            graph[r][c] = temp.also{temp = graph[r][c]}
            c--
        }
        //상
        for(i in 0 until n){
            graph[r][c] = temp.also{temp = graph[r][c]}
            r--
        }
        sr++
        sc++
        n-=2
        m-=2
        cnt--
    }
}

fun permuatation(idx: Int, n: Int, m: Int, k: Int, result: IntArray, graph: Array<IntArray>){
    if(idx==k){
        //한 번의 순열 결과셋을 돌려볼 때 origin배열 상태에서 돌려야 함
        val tempArr = Array(n){ r->
            IntArray(m){ c->
                graph[r][c]
            }
        }
        //rotate
        for(r in result){
            val op = oper[r]
            rotate(op,tempArr)
        }
        //cal
        for(r in 0 until n){
            var sum =0
            for(c in 0 until m){
                sum += tempArr[r][c]
            }
            answer = answer.coerceAtMost(sum)
        }
        return
    }

    for(i in 0 until k){
        if(visited[i]) continue
        visited[i] = true
        result[idx] = i
        permuatation(idx+1, n, m, k, result,graph)
        visited[i] = false
    }
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val (n,m,k) = getIntList()
    val graph = Array(n){ getIntList().toIntArray()}
    oper = Array(k) { getIntList() }
    visited = BooleanArray(k)
    //solve
    permuatation(0,n,m,k,IntArray(k),graph)

    //output
    write("$answer")

    close()
}
