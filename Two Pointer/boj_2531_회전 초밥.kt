//https://www.acmicpc.net/problem/2531
val br = System.`in`.bufferedReader()
//2<=n<=30000
//2<=d<=3000
//2<=k<=3000
//1<=c<=d
fun main() = with(System.out.bufferedWriter()){
    //가짓수의 최댓값 구하기

    val (n, d , k , c )= br.readLine().split(' ').map{it.toInt()}
    val set = IntArray(d+1)
    val input = IntArray(n){br.readLine().toInt()}

    var cnt=0
    var answer=0
    var e =0
    while(e<k){
        val next = input[e]
        if(set[next]==0){
            cnt++
        }
        set[next]++
        e++
    }
    if(set[c]==0){
        answer = answer.coerceAtLeast(cnt+1)
    }
    else{
        answer = answer.coerceAtLeast(cnt)
    }

    for(s in input.indices){
        if(set[input[s]]==1){
            cnt--
        }
        set[input[s]]--
        if(set[input[e]]==0){
            cnt++
        }
        set[input[e]]++
        e = (e+1)%n

        answer = if(set[c]==0){
            answer.coerceAtLeast(cnt+1)
        } else{
            answer.coerceAtLeast(cnt)
        }
        if(answer==k+1){
            break
        }
    }

    write("$answer")
    close()
}
