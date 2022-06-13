//https://www.acmicpc.net/problem/17281
import java.util.*
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var scores: Array<List<Int>>
var answer=0
lateinit var visited: BooleanArray
lateinit var result: IntArray
fun calScore(n: Int): Int{
    var sum = 0
    var seq = 0
    for(i in 0 until n){
        //이닝 시작
        //점수 초기화 out 초기화 베이스 초기화
        var score=0
        var out = 0
        val base = IntArray(3)
        while(out <3){
            val hit = scores[i][result[seq%9]]
            when(hit){
                0 ->{
                    out++
                    //3아웃 즉시 종료
                    if(out>=3) {
                        seq++
                        break
                    }
                }
                //1,2,3타
                1 ->{
                    score+= base[2]
                    base[2] = base[1]
                    base[1] = base[0]
                    base[0] = 1
                }
                2 ->{
                    score+= base[1] + base[2]
                    base[2] = base[0]
                    base[1] = 1
                    base[0] = 0
                }
                3 ->{
                    score+= base[0] + base[1] + base[2]
                    base[2] = 1
                    base[1] = 0
                    base[0] = 0
                }
                4->{
                    score+= base[0] + base[1] + base[2] + 1
                    base[0] = 0
                    base[1] = 0
                    base[2] = 0
                }
            }
            seq++
        }
        sum += score
    }
    return sum
}


fun permutation(n: Int, idx: Int){
    if(idx==3){
        permutation(n, idx+1)
        return
    }
    if(idx==9){
        answer = answer.coerceAtLeast(calScore(n))
        return
    }

    for(i in 1 until 9){
        if(visited[i]) continue
        visited[i] = true
        result[idx] = i
        permutation(n, idx+1)
        visited[i] = false
    }
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    scores = Array(n){
        val tk = StringTokenizer(br.readLine())
        List(9){tk.nextToken().toInt()}
    }
    result = IntArray(9)
    visited = BooleanArray(9)
    //1번 선수 4번 타자로 고정
    result[3] = 0
    //solve
    permutation(n,0)
    //output
    write("$answer")
    close()
}
