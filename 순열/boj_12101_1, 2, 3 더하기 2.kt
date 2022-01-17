//https://www.acmicpc.net/problem/12101
val br = System.`in`.bufferedReader()

//n을 1,2,3으로 나타내고 사전순정렬해서 m번째 값 출력
//없으면 -1
val result = arrayListOf(StringBuffer())
fun permutation(sum : Int, n : Int, strBfr : StringBuffer){

    val newBfr = StringBuffer(strBfr);

    if(sum>=n){
        if(sum==n){
            result.add(newBfr);
        }
        return;
    }

    for(i in 1 .. 3){
        permutation(sum+i,n,newBfr.append(i.toString()))
        newBfr.deleteCharAt(newBfr.length-1)
    }
}

fun main() = with(System.out.bufferedWriter()){

    val (n,m) = br.readLine().split(' ').map{it.toInt()}

    permutation(0,n, StringBuffer())
    result.sortBy{it.toString()}
    if(m !in result.indices){
        write("-1")
    }
    else{
        for(i in result[m].indices){
            if(i==result[m].length-1){
                write("${result[m][i]}")
            }
            else
            write("${result[m][i]}+")
        }
    }
    close()
}
