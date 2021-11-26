//https://www.acmicpc.net/problem/17090
//3<=n,m<=500
//visited 2 : 탈출 가능 1 : 탈출 불가 0 : 미방문
val visited = Array<IntArray>(500){ IntArray(500) }//방문 체크
val moving = mapOf(
    'U' to Pair(-1,0),
    'R' to Pair(0,1),
    'D' to Pair(1,0),
    'L' to Pair(0,-1))
var answer=0
var isEscaped=false

fun dfs(r : Int, c : Int, n : Int, m : Int, graph : Array<String>){
    var nr = r + moving[graph[r][c]]!!.first
    var nc = c + moving[graph[r][c]]!!.second
    if(nr !in 0 until n || nc !in 0 until m){
        isEscaped = true
        visited[r][c]=2
        answer++
        return
    }
    if(visited[nr][nc]!=0){
        if(visited[nr][nc]==2) {
            isEscaped = true
            visited[r][c]=2
            answer++
        }
        return
    }
    visited[nr][nc]=1
    dfs(nr,nc,n,m,graph)
    if(isEscaped){
        visited[r][c]=2
        answer++
    }
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map { it.toInt() }
    val graph = Array<String>(n){""}
    //input
    for(i in 0 until n){
        graph[i] = br.readLine()
    }
    //solve
    for(i in 0 until n){
        for(j in 0 until m){
            if(visited[i][j]!=0){
                continue
            }
            dfs(i,j,n,m,graph)
            isEscaped=false
        }
    }

    write("$answer")

    close()
}

// import java.util.*

// //3<=n,m<=500
// val visited = Array<BooleanArray>(500){BooleanArray(500)}//방문 체크
// val escape = Array<BooleanArray>(500){BooleanArray(500)}//해당 노드 탈출 가능 여부
// val moving = mapOf<Char,Pair<Int,Int>>('U' to Pair(-1,0), 'R' to Pair(0,1), 'D' to Pair(1,0), 'L' to Pair(0,-1))
// var answer=0
// fun bfs(i : Int, j : Int,n :Int, m : Int, graph : Array<String>){
//     val q : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()//나아갈 길들
//     val way : Queue<Pair<Int,Int>> = LinkedList<Pair<Int,Int>>()//지나온 길들
//     q.add(Pair(i,j))
//     way.add(Pair(i,j))
//     visited[i][j] =true

//     while(q.isNotEmpty()){

//         var (r,c) = q.poll()
//         val nr = r+ moving[graph[r][c]]!!.first
//         val nc = c+ moving[graph[r][c]]!!.second

//         if(nr !in 0 until n || nc !in 0 until m){ //nr,nc가 탈출한 경우
//             while(way.isNotEmpty()){//지나온 길들은 모두 탈출 가능
//                 val (rr,cc) = way.poll()
//                 escape[rr][cc]=true
//                 answer++
//             }
//             return
//         }
//         if(visited[nr][nc]){ //이미 방문한 경우
//             if(escape[nr][nc]){//방문한 칸이 탈출 가능한 경우
//                 while(way.isNotEmpty()){
//                     val (rr,cc) = way.poll()
//                     escape[rr][cc]=true
//                     answer++
//                 }
//             }
//             return
//         }
//         //다음 탐색
//         visited[nr][nc]=true
//         q.add(Pair(nr,nc))
//         way.add(Pair(nr,nc))
//     }

// }

// fun main() = with(System.out.bufferedWriter()){
//     val br = System.`in`.bufferedReader()
//     val (n,m) = br.readLine().split(' ').map { it.toInt() }
//     val graph = Array<String>(n){""}
//     //input
//     for(i in 0 until n){
//         graph[i] = br.readLine()
//     }
//     //solve
//     for(i in 0 until n){
//         for(j in 0 until m){
//             if(visited[i][j]){
//                 continue
//             }
//             bfs(i,j,n,m,graph)
//         }
//     }
//     write("$answer")

//     close()
// }
