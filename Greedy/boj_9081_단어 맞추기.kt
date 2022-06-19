//https://www.acmicpc.net/problem/9081
val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().toInt()

fun main() = with(System.out.bufferedWriter()){
    //input
    val n = getInt()
    repeat(n){
        val input = br.readLine().toCharArray()
        for(i in input.size-2 downTo 0){
            var biggerCh = Pair(Int.MAX_VALUE,0)
            for(j in i until input.size){
                if(input[i]<input[j]){
                    biggerCh = Pair(biggerCh.first.coerceAtMost(input[j].code),j)
                }
            }
            //i 번째 문자보다 우측에 문자가 크다면 그 큰 값중 최솟값을 i위치에 넣기
            //이후 i 번째 뒤에 문자들을 정렬
            if(biggerCh.first!=Int.MAX_VALUE){
                input[i] = biggerCh.first.toChar().also { input[biggerCh.second] = input[i] }
                input.sort(i+1,input.size)
                break
            }
        }
        write("${String(input)}\n")
    }
    close()
}
