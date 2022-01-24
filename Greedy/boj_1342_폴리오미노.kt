//https://www.acmicpc.net/problem/1343
//jb code
fun main() = with(System.out.bufferedWriter()){
    val input = br.readLine()!!.replace("XXXX", "AAAA").replace("XX", "BB")
    write("${if ('X' in input) -1 else input}")
    close()
}
//my code
val br = System.`in`.bufferedReader()
fun main() = with(System.out.bufferedWriter()){
    val input = StringBuffer(br.readLine())

    var len=0
    var i=0
    while(i <= input.length){
        if(i<input.length && input[i]=='X'){
            len++
        }
        else{
            if(len%2!=0){
                write("-1")
                close()
                return
            }
            else{
                var cur =i-len
                repeat(len/4){
                    for(j in 0 until 4){
                        input.setCharAt(cur++,'A')
                    }
                }
                len %= 4

                repeat(len/2){
                    for(j in 0 until 2){
                        input.setCharAt(cur++,'B')
                    }
                }
                len=0
            }
        }
        i++
    }
    write("$input")
    close()
}
