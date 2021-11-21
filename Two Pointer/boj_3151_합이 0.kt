//https://www.acmicpc.net/problem/3151
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    //입력값 정렬
    val input = br.readLine().split(' ').map { it.toInt() }.sorted()
    var answer=0L
    //하나 고정, 2개 더한 값(투 포인터)
    for(i in 0 until input.size-2) {

        var left = i+1
        var right = input.size-1
        var cnt=0
        while(left<right ){

            //합이 0일 때
            if(input[i]+input[left]+input[right]==0){
                if(input[left]==input[right]){
                    answer+=right-left
                    cnt=0
                }
                else {
                //cnt 한 번 구한 건 재사용
                    if(cnt==0) {
                        var idx = right
                        while (idx > left && input[i] + input[left] + input[idx--] == 0) {
                            cnt++
                        }
                    }
                    answer+=cnt
                }
                left++
            }
            //합이 0보다 작을 때
            else if(input[i]+input[left]+input[right]<0){
                left++
                cnt=0
            }
            //합이 0보다 클 때
            else{
                right--
                cnt=0
            }
        }
    }

    write("$answer")

    close()
}
