//https://www.acmicpc.net/problem/2239
val br = System.`in`.bufferedReader()
//사전 순으로 앞서는 것을 출력 -> 행 박스 열 순이 유리
//위 설명 x 그냥 순서를 1부터 9까지 탐색함으로써 자동으로 사전순 정렬
val square =  Array(9) { BooleanArray(10) }
val row =  Array(9) { BooleanArray(10) }
val col =  Array(9) { BooleanArray(10) }
var finish = false
//backtracking
fun play(idx : Int, graph : Array<CharArray>){

    var idxCopy = idx
    var r = 0
    var c = 0
    while(idxCopy<81){
        r = idxCopy/9
        c = idxCopy%9
        if(graph[r][c]=='0')
            break
        idxCopy++
    }

    if(idxCopy==81){
        finish= true
        return
    }

    for (i in 1..9) {
        //해당 칸에 숫자가 들어갈 수 없으면 다음 숫자 검사
        if (row[r][i]) continue
        if (col[c][i]) continue
        if (square[((r / 3) * 9 + c) / 3][i]) continue
        
        //들어갈 수 있다면 넣기
        graph[r][c] = (i + '0'.toInt()).toChar()
        row[r][i] = true
        square[((r / 3) * 9 + c) / 3][i] = true
        col[c][i] = true
        //다음 0인 칸 찾기
        play(idx + 1, graph)
        //이전 dfs에서 종료되었다면 싹 다 return으로 종료
        if (finish) return
        //해당 칸에 i를 넣고 다음 0들을 검사했을 때 스도쿠가 완성될 수 없다면 다시 초기화
        //return 이전에 넣으면그래프가 다시 초기화 됨에 유의
        graph[r][c] = '0'
        row[r][i] = false
        square[((r / 3) * 9 + c) / 3][i] = false
        col[c][i] = false
    }


}

fun main() = with(System.out.bufferedWriter()){
    //input
    val graph = Array(9){r->
        val line = br.readLine()
        for(c in 0 until 9){
            //row
            row[r][Character.getNumericValue(line[c])]=true
            //col
            col[c][Character.getNumericValue(line[c])]=true
            //square
            square[((r/3)*9+c)/3][Character.getNumericValue(line[c])]=true
        }
        line.toCharArray()
    }
    
    //solve
    play(0,graph)
    
    //answer
    for(i in 0 until 9){
        for(j in 0 until 9){
            write("${graph[i][j]}")
        }
        write("\n")
    }
    close()
}
