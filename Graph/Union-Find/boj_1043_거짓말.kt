//https://www.acmicpc.net/problem/1043
import java.util.StringTokenizer
import java.io.BufferedReader
import java.io.InputStreamReader

val parent = IntArray(51,{it})

fun getParent(x : Int) : Int{
    return if(parent[x]==x) x else getParent(parent[x]).also{ parent[x] = it}
}

fun unionParent(a : Int, b : Int){
    val num1 =getParent(a)
    val num2 = getParent(b)
    if(num1>num2){
        parent[num1]=num2
    }
    else{
        parent[num2]=num1
    }
}
// fun findParent(a : Int, b : Int):Boolean{
//     val num1 = getParent(a)
//     val num2 = getParent(b)
//     return if(num1==num2) true else false
// }


fun main() = with(System.out.bufferedWriter()) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var tk = StringTokenizer(br.readLine())
    val n = Integer.parseInt(tk.nextToken())
    val m = Integer.parseInt(tk.nextToken())
    val party = IntArray(m,{0})
    var answer=0

    //진실 아는 사람은 parent node를 0으로
    tk = StringTokenizer(br.readLine())
    var rn = Integer.parseInt(tk.nextToken())
    while(rn--!=0){
        unionParent(0,Integer.parseInt(tk.nextToken()))
    }

    //파티 input
    for(i in 0 until m) {
        tk = StringTokenizer(br.readLine())
        val len = Integer.parseInt(tk.nextToken())
        if(len >0){
            val num = Integer.parseInt(tk.nextToken())
            for(j in 1 until len){
                unionParent(num,Integer.parseInt(tk.nextToken()))
            }
            party[i]=parent[num]
        }
        //len==0 파티에 아무도 안 왔으면
        else{
            party[i]=-1
        }

    }
    for(i in party.indices){
        if(party[i]==-1 || getParent(party[i])!=0){
            answer++
        }
    }
    write("$answer")
    close()
    close()
}
