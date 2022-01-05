//https://www.acmicpc.net/problem/3020
val INF = 987654321
val br = System.`in`.bufferedReader()
// 2<= n <=200000
// 2<= h <=500000
fun main() = with(System.out.bufferedWriter()){
    val (n,h) = br.readLine().split(' ').map{it.toInt()}
    //n은 항상 짝수
    val arr = IntArray(n/2)
    val reverseArr = IntArray(n/2)
    for(i in 0 until n){
        if(i and 1 ==1){
            reverseArr[i/2] = br.readLine().toInt()
        }
        else{
            arr[i/2] = br.readLine().toInt()
        }
    }
    arr.sort()
    reverseArr.sort()

    var result = INF
    var answer=0
    for(high in 1 .. h){
        var forVal = n/2-lowerBound(0,n/2,arr,high)
        var reverseVal = n/2-lowerBound(0,n/2,reverseArr,h+1-high)
        if(result==forVal+reverseVal){
            answer++
        }
        else if(result > forVal+reverseVal){
            result = forVal+reverseVal
            answer=1
        }
    }
    write("$result $answer")
    close()
}
fun lowerBound(start : Int, end : Int, arr : IntArray,high : Int) : Int{
    var s = start
    var e = end

    while(s<e){
        val mid = (s+e)/2

        if(arr[mid]>=high){
            e =mid
        }
        else{
            s=mid+1
        }
    }
    return e
}
