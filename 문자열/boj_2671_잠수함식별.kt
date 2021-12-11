//https://www.acmicpc.net/problem/2671
//100~1~
//01
fun dfa(str : String) : Boolean{
    var i = 0
    while(i<str.length){
//        println("$i ${str[i]}")
        //0으로 시작하는 패턴
        if(str[i]=='0'){
            if(i+1>=str.length) return false
            if(str[i+1]!='1') return false
            i+=2
        }
        //1로 시작하는 패턴
        else{
            if(i+3>=str.length) return false
            if(str[i+1]!='0' || str[i+2]!='0') return false
            i+=3
            while(i<str.length && str[i]=='0'){
                i++
            }
            //0만 이어지다가 1은 안 나오고 끝난 경우
            if(i>=str.length) return false
            i++
            while(i<str.length && str[i]=='1'){
                if(i+2<str.length && str[i+1]=='0' && str[i+2]=='0') break
                i++
            }

        }

    }
    return true
}

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val str = br.readLine()
    if(dfa(str)){
        write("SUBMARINE")
    }
    else {
        write("NOISE")
    }
    close()
}
