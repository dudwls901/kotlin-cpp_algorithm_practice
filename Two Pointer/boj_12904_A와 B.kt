//https://www.acmicpc.net/problem/12904
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
       val S = br.readLine()
    val T = br.readLine()
    var isReverse =false
    var s=0
    var e=T.length-1
    while(e-s+1!=S.length){
        if(isReverse){
            if(T[s]=='B'){
                isReverse=false
            }
            s++
        }
        else{
            if(T[e]=='B'){
                isReverse=true
            }
            e--
        }
    }
    if(isReverse){
        for(i in 0 until S.length){
            if(S[i]!=T[e-i]){
                write("0")
                close()
                return
            }
        }
    }
    else{
        for(i in 0 until S.length){
            if(S[i]!=T[s+i]){
                write("0")
                close()
                return
            }
        }
    }
    write("1")
    close()
}
