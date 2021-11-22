//https://www.acmicpc.net/problem/2920
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val input = br.readLine().split(' ').map{it.toInt()}
    var asc = input[0] < input[1]
    var pre = input[1]
    for(i in 2 until input.size){
        //ascending
        if(asc){
            if(pre > input[i]){
                write("mixed")
                close()
                return
            }
        }
        //descending
        else{
            if(pre < input[i]){
                write("mixed")
                close()
                return
            }
        }
        pre = input[i]
    }
    if(asc){
        write("ascending")
    }
    else{
        write("descending")
    }
    close()
}
