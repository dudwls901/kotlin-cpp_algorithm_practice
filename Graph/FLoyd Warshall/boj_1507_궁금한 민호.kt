//https://www.acmicpc.net/problem/1507
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){
    val n = br.readLine().toInt()
    val minDis = Array(n){br.readLine().split(' ').map{it.toInt()}}
    var answer =0
    val customMinDis = Array(n){r->
        IntArray(n){c->
            minDis[r][c]
        }
    }
    for(k in 0 until n){
        for(i in 0 until n){
            for(j in 0 until n){
                if(i==k || k==j) continue
                if(minDis[i][j]==minDis[i][k]+minDis[k][j]){
                    customMinDis[i][j]=0
                }
                else if(minDis[i][j] > minDis[i][k]+minDis[k][j]){
                    write("-1")
                    close()
                    return
                }
            }
        }
    }
    for(i in 0 until n-1 ){
        for(j in i+1 until n){
            answer+=customMinDis[i][j]
        }
    }
    write("$answer")
    close()
}
