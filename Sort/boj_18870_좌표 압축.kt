//https://www.acmicpc.net/problem/18870
//이분 탐색
val br = System.`in`.bufferedReader()

fun main() =with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    var arr = br.readLine().split(' ').map{it.toInt()}
    val sortedArr = arr.distinct().sorted()
    for(i in 0 until n){
        write("${sortedArr.binarySearch(arr[i])} ")
    }

    close()
}
/*해시
val br = System.`in`.bufferedReader()

fun main() =with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    var arr = br.readLine().split(' ').map{it.toInt()}
    val sortedArr = arr.distinct().sorted()
    val hashMap = HashMap<Int,Int>()
    var idx=0
    sortedArr.forEach {
        hashMap[it]=idx++
    }

    for(i in 0 until n){
        write("${hashMap.get(arr[i])} ")
    }

    close()
}
*/
