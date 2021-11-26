//https://www.acmicpc.net/problem/16724
//1<=n,m<=1000

val dir = mapOf(
    'D' to Pair(1,0),
    'U' to Pair(-1,0),
    'L' to Pair(0,-1),
    'R' to Pair(0,1)
)
val parent = IntArray(1000000){it}

fun getParent(idx : Int) : Int{
    if(parent[idx] ==idx) return parent[idx] else return getParent(parent[idx]).also{parent[idx]= it}
}

fun unionParent(a : Int, b : Int){
    val aa = getParent(a)
    val bb = getParent(b)
    if(aa<bb){
        parent[bb] = aa
    }
    else{
        parent[aa] = bb
    }
}

fun findParent(a : Int, b : Int) : Boolean{
    val aa = getParent(a)
    val bb = getParent(b)
    return aa==bb
}


fun dfs(r : Int, c : Int, n : Int, m : Int, graph: Array<String>){
    val nr = r + dir[graph[r][c]]!!.first
    val nc = c + dir[graph[r][c]]!!.second
    val curIdx = r*m+c
    val nextIdx = nr*m+nc
    //유니온 파인드로 사이클 찾기
    //사이클이 완성된다면 리턴
    if(findParent(curIdx,nextIdx)) return
    unionParent(curIdx,nextIdx)
    dfs(nr,nc,n,m,graph)
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array<String>(n){""}
    for(i in 0 until n){
        graph[i] = br.readLine()
    }
	//dfs로 그래프 탐색
    for(i in 0 until n){
        for(j in 0 until m){
            dfs(i,j,n,m,graph)
        }
    }
    
    //사이클 개수 카운트
    val answer = mutableSetOf<Int>()
    for(i in 0 until n*m){
        answer.add(getParent(parent[i]))
    }

    write("${answer.size}")
    close()
}

// //1<=n,m<=1000

// val dir = mapOf(
//     'D' to Pair(1,0),
//     'U' to Pair(-1,0),
//     'L' to Pair(0,-1),
//     'R' to Pair(0,1)
// )
// val visited = Array(1000){IntArray(1000)}
// var cycle=1
// fun dfs(r : Int, c : Int, n : Int, m : Int, graph: Array<String>) : Int{
//     val nr = r + dir[graph[r][c]]!!.first
//     val nc = c + dir[graph[r][c]]!!.second
//     if(visited[nr][nc]!=0){
//         return visited[nr][nc]
//     }
//     visited[nr][nc]=cycle
//     visited[nr][nc] =dfs(nr,nc,n,m,graph)

//     return 1
// }

// fun main() = with(System.out.bufferedWriter()){
//     val br = System.`in`.bufferedReader()
//     val (n,m) = br.readLine().split(' ').map{it.toInt()}
//     val graph = Array<String>(n){""}
//     for(i in 0 until n){
//         graph[i] = br.readLine()
//     }

//     for(i in 0 until n){
//         for(j in 0 until m){
//             if(visited[i][j]!=0) continue
//             visited[i][j]=cycle
//             visited[i][j]=dfs(i,j,n,m,graph)
//             cycle++
//         }
//     }
//     val answer = mutableSetOf<Int>()
//     for(i in 0 until n){
//         for(j in 0 until m){
//             answer.add(visited[i][j])
//         }
//     }
    
//     write("${answer.size}")
//     close()
// }
