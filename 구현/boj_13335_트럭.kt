//https://www.acmicpc.net/problem/13335
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val (n, w, l) = getIntList()
    var time = 0
    var weightSum = 0
    val bridge = IntArray(w)
    val trucks = getIntList()
    var idx=0
    //solve
    while(true){
        time++
        //다리 나가기
        if(bridge[w-1]>0){
            weightSum-= bridge[w-1]
            bridge[w-1] = 0
        }
        //한 칸씩 이동
        for(i in bridge.size-1 downTo 1){
            bridge[i] = bridge[i-1].also { bridge[i-1] = 0 }
        }
        //다리에 올리기
        if(idx<n) {
            if (weightSum + trucks[idx] <= l) {
                weightSum += trucks[idx]
                bridge[0] = trucks[idx++]
            }
        }
        //모든 트럭이 움직였고, 다리에 아무것도 남지 않은 경우
        if(idx==n && weightSum==0) break
    }
    //output
    write("$time")

    close()
}
