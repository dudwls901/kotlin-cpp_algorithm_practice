//https://www.acmicpc.net/problem/14658
val br = System.`in`.bufferedReader()

//1 <= n,m <= 500000 그래프 가로 세로
//1<= l <= 100000 트램펄린 길이
//1< k < =100 별똥별 수

fun main() = with(System.out.bufferedWriter()){

    val (m,n,l,k) = br.readLine().split(' ').map{it.toInt()}
    val star = Array(k){Pair(0,0)}
    for(i in 0 until k){
         br.readLine().split(' ').map{it.toInt()}.also{star[i] = Pair(it[0],it[1])}
    }
    var answer =0
    for(i in 0 until k){
        val x = star[i].first
        for(j in 0 until k){
            val y = star[j].second
            var sum=0
            for(a in 0 until k){
                val cX = star[a].first
                val cY = star[a].second
                if(x<= cX && cX <=x+l && y <= cY && cY <= y+l) sum++
            }
            answer = answer.coerceAtLeast(sum)
        }
    }
    write("${k-answer}")
    close()
}
