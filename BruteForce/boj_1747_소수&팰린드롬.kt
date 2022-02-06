//https://www.acmicpc.net/problem/1747
const val MAX = 1003002
val br = System.`in`.bufferedReader()

val prime = BooleanArray(MAX)

fun makePrime(){
    prime[1]=true
    for(i in 2 until MAX){
        if(prime[i]) continue
        for(j in i*2 until MAX step i){
            prime[j]=true
        }
    }
}

fun main() = with(System.out.bufferedWriter()){

    var n = br.readLine().toInt()

    makePrime()
    
    while(true){
        if(!prime[n]){
           val str = n.toString()
           var left = 0
           var right =str.length-1
           while(left<right){
               if(str[left]!=str[right]){
                   break
               }
               left++
               right--
           }
           if(left>=right){
               write("$n")
               break
           }
       }
        n++
    }
    close()
}
