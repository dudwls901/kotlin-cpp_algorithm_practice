//https://www.acmicpc.net/problem/20167
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
/*
* N개의 먹이
* 0부터 시작, 매초 1만큼 오른쪽으로 이동
* 최소 만족도 k이상 되거나 먹이가 없을 때는 그만 먹음 -> 다음 칸을 먹을지, 패스할지 선택 가능한 상태
* 탈피에너지 = 현재 연속 먹은 값 - 최소 만족도 만큼
* 애벌레 먹은 값 0으로 초기화
* 그래프의 끝에 도달했을 때는 남아있는 먹은값을 탈피에너지 계산해서 축적
* 현재 칸을 먹느냐 안 먹느냐 -> k보다 큰 값이 나올 때 얼마나 큰 값이 나올지로 판단
* */
lateinit var graph: List<Int>
var answer = 0

fun backTracking(n: Int,k: Int,idx: Int, eating: Boolean,cost: Int,result: Int){
    if(idx==n){
        answer = answer.coerceAtLeast(result)
        return
    }
    //아직 안 먹는중
    if(!eating){
        //안 먹을래~
        backTracking(n,k,idx+1,false, cost, result)
        //먹을래~
        val nextCost = cost + graph[idx]
        //만족해~
        if (nextCost >= k) {
            backTracking(n, k, idx + 1, false, 0, result + nextCost - k)
        }
        //아직이야~
        else {
            backTracking(n, k, idx + 1, true, nextCost, result)
        }
    }
    //먹는중
    else {
        val nextCost = cost + graph[idx]
        //만족해~
        if (nextCost >= k) {
            backTracking(n, k, idx + 1, false, 0, result + nextCost - k)
        }
        //아직이야~
        else {
            backTracking(n, k, idx + 1, true, nextCost, result)
        }
    }
}

fun main() = with(System.out.bufferedWriter()){
    //input
    val (n, k) = getIntList()
    graph = getIntList()

    //solve
    backTracking(n,k,0,false,0,0)
    //output
    write("$answer")

    close()
}
