//https://www.acmicpc.net/problem/16719
val br = System.`in`.bufferedReader()

fun solve(str: String, result: CharArray, s: Int, e: Int){
    var minCh = 'Z'+1
    var minIdx = -1
    for(i in s until e){
        if(minCh > str[i]){
            minIdx = i
            minCh = str[i]
        }
    }
    if(minIdx!=-1){
        result[minIdx] = minCh
        //output
        for(i in result.indices) {
            print("${if (result[i].isLetter()) result[i] else ""}")
        }
        println()

        solve(str,result,minIdx+1,e)
        solve(str,result,s,minIdx)
    }

}

fun main(){
    //input, solve
    br.readLine().apply {
        solve(this, CharArray(length),0,length)
    }
}
