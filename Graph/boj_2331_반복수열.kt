//https://www.acmicpc.net/problem/2331
val br = System.`in`.bufferedReader()
//1<=A<=9999
//1<=P<=5
var answer=0
val cntArr = IntArray(300000)
fun dfs(cur : Int, p : Int , cnt : Int, a : Int){
    if(cntArr[cur]!=0) {
        if(cur==a)
            answer = 0
        else
            answer = cntArr[cur]-1
        return
    }

    cntArr[cur]=cnt

    //next
    var num = cur
    var next=0
    while(num>0){
        var pNum=num%10
        for(i in 1 until p){
            pNum *= num%10
        }
        next +=pNum
        num/=10
    }
    dfs(next,p,cnt+1, a)
}

fun main() = with(System.out.bufferedWriter()){
    val (a,p) = br.readLine().split(' ').map{it.toInt()}
    dfs(a,p, 1,a)
    write("$answer")
    close()
}
