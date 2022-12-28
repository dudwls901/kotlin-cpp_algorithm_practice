//https://www.acmicpc.net/problem/2477
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    val k = br.readLine().toInt()
    val arr = Array(6){Pair(0,0)}
    var maxHigh = 0
    var maxWidth = 0
    for(i in arr.indices){
        val (dir, value) = br.readLine().split(' ').map{it.toInt()}
        arr[i] = Pair(dir,value)
        when(dir){
            1,2 ->{
                maxWidth = maxWidth.coerceAtLeast(value)
            }
            3,4 ->{
                maxHigh = maxHigh.coerceAtLeast(value)
            }
        }

    }
    var emptyHigh = 0
    var emptyWidth = 0
    for(i in arr.indices){
        if(arr[i].first <=2){
            if(arr[(i+5)%6].second+arr[(i+1)%6].second == maxHigh){
                emptyWidth = arr[i].second
            }
        }
        else{
            if(arr[(i+5)%6].second+arr[(i+1)%6].second == maxWidth){
                emptyHigh = arr[i].second
            }
        }
    }

    write("${(maxWidth*maxHigh - emptyHigh * emptyWidth) * k}")

    close()
}
