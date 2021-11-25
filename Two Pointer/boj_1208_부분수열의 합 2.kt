//https://www.acmicpc.net/problem/1208
val sumMap= mutableMapOf<Long,Long>()
var cnt=0L
fun preSum(idx : Int, n : Int, input : LongArray, sum : Long){
    if(idx==n){
        sumMap.put(sum,sumMap.getOrDefault(sum,0)+1)
        return
    }
    preSum(idx+1,n,input,sum+input[idx])
    preSum(idx+1,n,input,sum)
}

fun leftSum(idx : Int, n : Int, input : LongArray, sum : Long, s: Int){
    if(idx==n) {
        cnt += sumMap.getOrDefault(s - sum, 0)
        return
    }

    leftSum(idx+1, n, input, sum+input[idx],s)
    leftSum(idx+1, n, input, sum,s)
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val (n,s) = br.readLine().split(' ').map{it.toInt()}
    val input = br.readLine().split(' ').map{it.toLong()}.toLongArray()

    preSum(n/2,n, input, 0)
    
    leftSum(0,n/2,input,0,s)
    if(s==0)cnt--
    write("$cnt")
    close()
}
// fun preSum(idx : Int, n : Int, input : LongArray, sum : Long, arr : ArrayList<Long>){
//     if(idx==n){
//         arr.add(sum)
//         return
//     }
//     preSum(idx+1,n,input,sum+input[idx], arr)
//     preSum(idx+1,n,input,sum, arr)
// }

// fun main() = with(System.out.bufferedWriter()){
//     val br = System.`in`.bufferedReader()
//     val (n,s) = br.readLine().split(' ').map{it.toInt()}
//     val input = br.readLine().split(' ').map{it.toLong()}.toLongArray()


//     val leftSum = ArrayList<Long>()
//     val rightSum = ArrayList<Long>()
//     //반으로 나눠서 두 수의 합 배열 생성
//     preSum(0,n/2, input, 0, leftSum)
//     preSum(n/2, n, input, 0, rightSum)

//     //두 배열 정렬
//     leftSum.sort()
//     rightSum.sort()

//     //투 포인터
//     var answer=0L
//     var p1 = 0
//     var p2 = rightSum.size-1
//     var cnt=1
//     while(p1<leftSum.size && p2 >=0){
//         if(leftSum[p1] + rightSum[p2]==s.toLong()){
//             if(cnt==1){
//                 var idx=p2
//                 while(--idx>=0 && rightSum[idx]==rightSum[p2]){
//                     cnt++
//                 }
//             }
//             answer+=cnt
//             p1++
//         }
//         //s보다 작을 때
//         else if(leftSum[p1] + rightSum[p2]<s.toLong()){
//             p1++
//             cnt=1
//         }
//         //s보다 클 때
//         else{
//             p2--
//             cnt=1
//         }
//     }

//     if(s==0)answer--
//     write("$answer")
//     close()
// }
