//https://www.acmicpc.net/problem/2563
// 전체 도화지의 크기 100x100
// 색종이의 수  n <=100
// 색종이의 크기 10x10
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()

    val graph = Array(100){BooleanArray(100)}
    var answer=0
    while(n--!=0){
        val (x,y) = br.readLine().split(' ').map { it.toInt() }
        for(i in x until x+10){
            for(j in y until y+10){
                if(graph[i][j]) continue
                graph[i][j]=true
                answer++
            }
        }
    }
    write("$answer")
    close()
}
