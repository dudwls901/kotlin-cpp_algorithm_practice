//https://www.acmicpc.net/problem/7573
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

var answer = 0
//그물 치기
fun cast(r: Int, c: Int, l: Int, n: Int){
    var w = 1
    while(w*2 < l){

        val h = (l - w*2)/2 
        //w,h로 그물 쳐보기
        for(i in 0 .. h){
            label@for(j in 0 .. w){
                val cr = r - i
                val cc = c - j
                var cnt=0
                for(ii in 0 .. h){
                    for(jj in 0 .. w){
                        val nr = cr + ii
                        val nc = cc + jj
                        if(nr !in 1 .. n || nc !in 1 .. n) continue@label
                        if(graph[nr][nc]) cnt++
                    }
                }
                answer = answer.coerceAtLeast(cnt)
                if(i!=0 && i!=h ) break
            }
        }
        w++
    }
}

lateinit var graph: Array<BooleanArray>
val fish = ArrayList<Pair<Int,Int>>()
fun main() = with(System.out.bufferedWriter()){

    //input
    val (n,l,m) = getIntList()
    graph = Array(n+1){BooleanArray(n+1)}
    repeat(m){
        val (r,c) = getIntList()
        graph[r][c] = true
        fish.add(Pair(r,c))
    }
    //solve
    fish.forEach { (r,c) ->
        cast(r,c,l,n)
    }
    //output
    write("$answer")
    close()
}
