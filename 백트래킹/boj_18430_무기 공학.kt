//acmicpc.net/problem/18430
val br = System.`in`.bufferedReader()
//1<=n,m<=5
lateinit var graph : Array<IntArray>
lateinit var visited : Array<BooleanArray>
var answer =0

fun shapeSum(shape : Int, r : Int, c: Int, n : Int, m : Int, type : Int) : Int{
    return when(type){
        //생성
        0->{
            when(shape){
                0 ->{
                    if(r+1 !in 0 until n
                        || c+1 !in 0 until m
                        || visited[r][c]
                        ||visited[r+1][c]
                        ||visited[r][c+1])
                        0
                    else{
                        visited[r][c] = true
                        visited[r+1][c] = true
                        visited[r][c+1] = true
                        graph[r][c]*2+graph[r+1][c]+graph[r][c+1]
                    }
                }
                1->{
                    if(r-1 !in 0 until n
                        || c+1 !in 0 until m
                        || visited[r][c]
                        || visited[r-1][c]
                        || visited[r][c+1]
                    ){
                        0
                    }
                    else{
                        visited[r][c] = true
                        visited[r-1][c] = true
                        visited[r][c+1] = true
                        graph[r][c]*2+graph[r-1][c]+graph[r][c+1]
                    }
                }
                2->{
                    if(r-1 !in 0 until n
                        || c-1 !in 0 until m
                        || visited[r][c]
                        || visited[r-1][c]
                        || visited[r][c-1]
                    ){
                        0
                    }
                    else{
                        visited[r][c] = true
                        visited[r-1][c] = true
                        visited[r][c-1] = true
                        graph[r][c]*2+graph[r-1][c]+graph[r][c-1]
                    }
                }
                else->{
                    if(r+1 !in 0 until n
                        || c-1 !in 0 until m
                        || visited[r][c]
                        || visited[r+1][c]
                        || visited[r][c-1]
                    ){
                        0
                    }
                    else{
                        visited[r][c] = true
                        visited[r+1][c] = true
                        visited[r][c-1] = true
                        graph[r][c]*2+graph[r+1][c]+graph[r][c-1]
                    }
                }
            }
        }
        //삭제
        else->{
            when(shape){
                0 -> {
                    visited[r][c] = false
                    visited[r + 1][c] = false
                    visited[r][c + 1] = false
                    0
                }
                1-> {
                    visited[r][c] = false
                    visited[r - 1][c] = false
                    visited[r][c + 1] = false
                    0
                }
                2-> {
                    visited[r][c] = false
                    visited[r - 1][c] = false
                    visited[r][c - 1] = false
                    0
                }
                else->{
                    visited[r][c] = false
                    visited[r + 1][c] = false
                    visited[r][c - 1] = false
                    0
                }
            }
        }

    }

}

fun dfs(curIdx : Int, n : Int, m : Int, sum : Int){
    var cur = curIdx
    answer = answer.coerceAtLeast(sum)
    while(cur<n*m) {
        var r = cur/m
        var c = cur%m
        for (i in 0 until 4) {
            //생성
            val next = shapeSum(i, r, c,n, m,0)
            if(next==0) continue

            dfs(cur+1, n, m, sum+next)
            //삭제
            shapeSum(i,r,c,n,m,1)
        }
        cur++
    }
}

fun main() = with(System.out.bufferedWriter()){
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    graph = Array(n){br.readLine().split(' ').map{it.toInt()}.toIntArray()}
    visited = Array(n){BooleanArray(m)}
    dfs(0,n,m,0)
    write("$answer")
    close()
}
