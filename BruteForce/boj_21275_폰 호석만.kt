//https://www.acmicpc.net/problem/21275
val br = System.`in`.bufferedReader()
//최대 2^63 Long
//a에서 큰 숫자 ~35진법
//b에서 큰 숫자 ~35진법
//이중 포문
var X =-1L
var A=-1
var B=-1
fun main() = with(System.out.bufferedWriter()){
    //input
    val input = br.readLine()
    var minA=0
    var minB=0
    var max=0
    for(ch in input){
        if(ch.isDigit()){
            max = max.coerceAtLeast(Character.getNumericValue(ch))
        }
        else {
            max = max.coerceAtLeast(ch - 'a' + 10)
        }
        if(ch==' '){
            minA=max+1
            max=0
        }
    }
    minB = max+1
    val (a,b) = input.split(' ')

    //solve
    for(i in minA .. 36){
        var x=0L
        for(ch in a){
            if(ch.isDigit()){
                x = x*i + Character.getNumericValue(ch)
            }
            else{
                x = x*i + (ch-'a'+10)
            }
        }
        //long 벗어난 경우
        if(x<0L) break

        //b구하기
        label@for(j in minB .. 36){
            if(i==j) continue
            var y=0L
            for(ch in b){
                if(ch.isDigit()){
                    y = y*j + Character.getNumericValue(ch)
                }
                else{
                    y = y*j +(ch-'a'+10)
                }
                if(y>x) break@label
            }
            
            if(x==y){
                if(X!=-1L){
                    write("Multiple")
                    close()
                    return
                }
               X=x
               A=i
               B=j
            }
        }
    }
//outpu
    if(X==-1L){
        write("Impossible")
    }
    else{
        write("$X $A $B")
    }

    close()
}
