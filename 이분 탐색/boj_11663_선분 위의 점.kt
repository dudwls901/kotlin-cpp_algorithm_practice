//https://www.acmicpc.net/problem/11663
val br = System.`in`.bufferedReader()

lateinit var set : List<Int>

fun biSearch(start : Int, end : Int, findVal : Int) : Int{

    if(start>=end){
        return start
    }
    val mid = (start+end)/2

    return if(set[mid]==findVal){
        mid
    }
    else if(set[mid]<findVal){
        biSearch(mid+1,end,findVal)
    }
    else{
        biSearch(start,mid,findVal)
    }
}

fun main() = with(System.out.bufferedWriter()){

    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    set = br.readLine().split(' ').map{it.toInt()}.sorted()
    for(i in 0 until m){
        val (left,right) = br.readLine().split(' ').map{it.toInt()}

        val start = biSearch(0,n,left)
        var end = biSearch(0,n,right)

        if( end < n &&  right==set[end]){
            end++
        }
        write("${end-start}\n")
    }

    close()
}
