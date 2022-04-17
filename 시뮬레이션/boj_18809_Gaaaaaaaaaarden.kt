//https://www.acmicpc.net/problem/18809
import java.util.*
val br = System.`in`.bufferedReader()

data class Node(
    val r: Int,
    val c: Int,
    val color: Int
)
val oilList=ArrayList<Pair<Int,Int>>()
lateinit var graph: Array<IntArray>
lateinit var startList: Array<Node>
val dir = arrayOf(
    arrayOf(0,1),
    arrayOf(1,0),
    arrayOf(0,-1),
    arrayOf(-1,0)
)
var answer=0
//graph에 0만 아니면 이동은 가능
//꽃이 만들어지면 이동 제거
//도달한 적이 없는 데로만 퍼지기 가능
//조합으로 r과 g 세트를 생성
//생성된 조합으로 시뮬레이션 최댓값 갱신
//시뮬레이션할 때마다 그래프 복제하여 사용(원본 그래프 있어야 함)


//visited first : turn, second : color
fun simulation(n:Int, m: Int, spread: Array<Array<Pair<Int,Int>>>): Int{
    var sum=0
    val q: Queue<Node> = LinkedList()
    for(node in startList){
        q.add(node)
        spread[node.r][node.c]= Pair(-2,-1)
    }

    var turn=1
    while(q.isNotEmpty()){
        val size = q.size
        //한 턴에 두 배양액이 만나야만 ++
        for(i in 0 until size){
            val cur = q.poll()
            //꽃이 핀 부분은 스킵
            if(spread[cur.r][cur.c].first==0) continue
            for(i in 0 until 4){
                val nr = cur.r+dir[i][0]
                val nc = cur.c+dir[i][1]
                if(nr !in 0 until n || nc !in 0 until m) continue
                if(graph[nr][nc]==0) continue
                //꽃 피우기
                if(spread[nr][nc].first==turn){
                    if(spread[nr][nc].first>=0 && spread[nr][nc].second != cur.color) {
                        sum++
                        spread[nr][nc] = Pair(0,-1)
                    }
                }
                //새로 방문
                else if(spread[nr][nc].first==-1){
                    spread[nr][nc] = Pair(turn,cur.color)
                    q.add(Node(nr,nc,cur.color))
                }
                //이미 방문
                else continue
            }
        }
        turn++
    }
    return sum
}


fun combination(searchIdx: Int, resultIdx: Int,cnt: Int, size: Int, n: Int, m: Int, g: Int, r: Int){
    //g, r 모두 선별
    if(g==0 && r==0){
        answer = answer.coerceAtLeast(simulation(n,m,Array(n){Array(m){Pair(-1,-1)}}))
        return
    }
    //남은 땅으로 배양액을 모두 사용할 수 없으면 중단
    if(size-cnt < g+r) return

    for(i in searchIdx until size){
        //그린 삽입
        if(g>0){
            startList[resultIdx] = Node(oilList[i].first, oilList[i].second, 0)
            combination(i+1,resultIdx+1,cnt+1,size,n,m,g-1,r)
        }
        //레드 삽입
        if(r>0) {
            startList[resultIdx] = Node(oilList[i].first, oilList[i].second, 1)
            combination(i+1,resultIdx+1,cnt+1,size,n,m,g,r-1)
        }
    }
}


fun main() = with(System.out.bufferedWriter()){

    //input
    val (n,m,g,r) = br.readLine().split(' ').map{it.toInt()}
    graph = Array(n){
        val tk = StringTokenizer(br.readLine())
        IntArray(m){ tk.nextToken().toInt()}
    }
    for(i in 0 until n){
        for(j in 0 until m){
            if(graph[i][j]==2){
                oilList.add(Pair(i,j))
            }
        }
    }
    startList = Array(g+r){Node(0,0,0)}
    //solve
    combination(0,0,0,oilList.size,n,m,g,r)

    //output
    write("$answer")

    close()
}
