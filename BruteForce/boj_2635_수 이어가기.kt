//https://www.acmicpc.net/problem/2635
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()

    var answer =0
    var answerArr = ArrayList<Int>()
    for(i in 1 .. n){
        var list = ArrayList<Int>()
        list.add(n)
        list.add(i)
        var curIdx=2
        while(true){
            val next = list[curIdx-2]-list[curIdx-1]
            if(next<0) break
            list.add(next)
            curIdx++
        }
        if(answerArr.size < list.size){
            for(i in list.indices){
                if(i < answerArr.size){
                    answerArr[i] = list[i]
                }
                else{
                    answerArr.add(list[i])
                }
            }
        }
    }
    write("${answerArr.size}\n")
    for(num in answerArr){
        write("$num ")
    }
    close()
}
