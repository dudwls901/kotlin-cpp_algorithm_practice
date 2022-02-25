//https://www.acmicpc.net/problem/16943
val br = System.`in`.bufferedReader()
var answer = -1
var result = 0
fun permutation( a: String, b: String, visited: BooleanArray){
    if(result.toString().length==a.length){
        if(result<b.toInt())
            answer = answer.coerceAtLeast(result)
        return
    }

    for(i in a.indices){
        if(visited[i]) continue
        visited[i] =  true
        result = result*10 + (a[i]-'0')
        permutation(a,b,visited)
        visited[i] = false
        result /= 10
    }
}

fun main() = with(System.out.bufferedWriter()){

    val (a,b) = br.readLine().split(' ')
	//a의 길이가 b보다 길다면 c는 모두 b보다 크다
	if(a.length>b.length){
        write("-1")
        close()
        return
    }
    permutation(a,b,BooleanArray(a.length))

    write("$answer")
    close()
}
