//https://www.acmicpc.net/problem/10972
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    //solve
    val answer = getIntList().toIntArray().apply {
        //바꿀 위치 탐색
        for (i in this.size - 2 downTo 0) {
            var min = Int.MAX_VALUE
            var minIdx = 0
            //i 우측에 있는 것보다 i가 작다면 바꾸기
            for (j in i+1 until this.size) {
                //i 우측에 있는 것중 i보다 크면서 가장 작은 값 찾고 swap
                if (this[i] < this[j]) {
                    if(min > this[j]){
                        min = this[j]
                        minIdx = j
                    }
                }
            }
            //swap, i 이후의 값들은 오름차순 정렬
            if(min!=Int.MAX_VALUE){
                this[i] = this[minIdx].also { this[minIdx] = this[i] }
                this.sort(i + 1, this.size)
                return@apply
            }
        }
        //i보다 작은 값이 없다 -> 순열의 가장 마지막 (전체 내림차순)이므로 -1 출력
        write("-1")
        close()
        return@with
    }
    //output
    write(answer.joinToString(" "))
    close()
}
