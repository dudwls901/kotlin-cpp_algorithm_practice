//https://www.acmicpc.net/problem/1025
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
val set = mutableSetOf<Int>()
lateinit var graph: Array<String>
var answer = -1
val dir = arrayOf(
    arrayOf(0,1),
    arrayOf(1,0),
    arrayOf(1,1),
    arrayOf(1,-1)
)
fun pick(r: Int, c: Int, result: StringBuffer, d: Int, stepR: Int, stepC: Int,n: Int,m: Int){
//    println("$result")
    val result1 = result.toString().toInt()
    val result2 = result.toString().reversed().toInt()
    answer = if(set.contains(result1)) answer.coerceAtLeast(result1) else answer
    answer = if(set.contains(result2)) answer.coerceAtLeast(result2) else answer

    val nr = r+dir[d][0]*stepR
    val nc = c+dir[d][1]*stepC
    if(nr !in 0 until n || nc !in 0 until m) return

    pick(nr,nc,result.append(graph[nr][nc]), d, stepR, stepC, n, m)

}

fun main() =with(System.out.bufferedWriter()){
    //input
    val (n,m) = getIntList()
    graph = Array(n){br.readLine()}

    //preset
    for(i in 0 .. 40000){
        set.add(i*i)
    }
    //solve
    //모든 점에서 시작
    for(r in 0 until n){
        for(c in 0 until m){
            //우 하 하대각2
            for(i in 0 until 4){
                //step 1 ~
                for(stepR in 1 .. n) {
                    for(stepC in 1 .. m) {
                        pick(r, c, StringBuffer(graph[r][c].toString()), i, stepR, stepC, n, m)
                    }
                }
            }
        }
    }

    //output
    write("$answer")
    close()
}
