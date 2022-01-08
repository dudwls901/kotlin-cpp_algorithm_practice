//https://www.acmicpc.net/problem/18808
val br = System.`in`.bufferedReader()

//1<=n,m<=40
//1<=k<=100

lateinit var graph : Array<BooleanArray>
var answer = 0
//스티커 돌리기
fun rotate(sticker : Array<Array<IntArray>>){

    for(dir in 1 .. 3) {
        for (r in sticker[dir].indices) {
            for (c in sticker[dir][r].indices) {
                sticker[dir][r][c] = sticker[dir-1][sticker[dir-1].size-c-1][r]
            }
        }

    }
}

//붙이기
fun attach(i : Int,j : Int,n : Int,m : Int,sticker : Array<IntArray>,visitedSticker : Array<BooleanArray>){
    var cr =-1
    var cc =-1
    for(r in 0 until 10){
        for(c in 0 until 10){
            if(sticker[r][c]==1){
                if(cr==-1){
                    cr=r
                    cc=c
                }
                
                val nr = i+r-cr
                val nc = j+c-cc
                graph[nr][nc]=true
                answer++
            }

        }
    }
}

//붙일 수 있나 확인
fun dfs(i : Int, j : Int, n : Int, m : Int, sticker : Array<IntArray>) : Boolean{
    var cr =-1
    var cc =-1
    for(r in 0 until 10){
        for(c in 0 until 10){
            if(sticker[r][c]==1){
                if(cr==-1){
                    cr=r
                    cc=c
                }
                //넣을 수 있는지 검사
                val nr = i+r-cr
                val nc = j+c-cc
                if(nr !in 0 until n || nc !in 0 until m) return false
                if(graph[nr][nc]) return false
            }

        }
    }
    return true
}

fun main() = with(System.out.bufferedWriter()){

    val (n,m,k) = br.readLine().split(' ').map{it.toInt()}
    graph = Array(n){BooleanArray(m)}
    val sticker = Array(k){ Array(4){ Array(10) { IntArray(10) } } }


    for(i in 0 until k){
        val (r, c) = br.readLine().split(' ').map{it.toInt()}
        for(j in 0 until r){
            var idx = 0
            br.readLine().split(' ').map{
                val num = it.toInt()
                sticker[i][0][j][idx++] = num
            }
        }
        //스티커 원본을 3번 돌린 값들 모두 저장
        rotate(sticker[i])
    }

    for(s in sticker.indices) {
        var canAttach = false
        //스티커 4방향 붙여보기
        for (dir in 0 until 4) {
            //왼쪽 위부터
            for (i in 0 until n) {
                for (j in 0 until m) {
                    //스티커 붙은 칸 스킵
                    if (graph[i][j]) continue

                    canAttach = dfs(
                        i,
                        j,
                        n,
                        m,
                        sticker[s][dir])
                    //붙일 수 있으면 붙이고 사용 처리
                    if (canAttach) {
                        attach(
                            i,
                            j,
                            n,
                            m,
                            sticker[s][dir],
                            Array(sticker[s][dir].size) { BooleanArray(sticker[s][dir][0].size) })
                        break
                    }
                    if (canAttach) break
                }
                if (canAttach) break
            }
            if(canAttach) break
        }
    }
    write("$answer")
    close()
}
