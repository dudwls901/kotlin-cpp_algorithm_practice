//https://www.acmicpc.net/problem/10973
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    //solve
    val answer = getIntList().toIntArray().apply {
        //바꿀 위치 탐색
        for (i in this.size-2 downTo 0) {
            var max = 0
            var maxIdx = 0
            //i 우측에 있는 것보다 i가 크다면 바꾸기
            for (j in i+1 until this.size) {
                //i 우측에 있는 것중 i보다 작으면서 가장 큰 값 찾고 swap
                if (this[i] > this[j]) {
                    if(max < this[j]){
                        max = this[j]
                        maxIdx = j
                    }
                }
            }
            //swap
            if(max!=0){
                this[i] = this[maxIdx].also { this[maxIdx] = this[i] }
                this.sortDescending(i+1, this.size)
                return@apply
            }
        }
        //i보다 작은 값이 없다 -> 순열의 가장 처음 (전체 오름차순)이므로 -1 출력
        write("-1")
        close()
        return@with
    }
    //output
    write(answer.joinToString(" "))
    close()
}
