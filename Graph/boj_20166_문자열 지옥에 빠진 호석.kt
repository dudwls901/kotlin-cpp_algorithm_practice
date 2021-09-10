//https://www.acmicpc.net/problem/20166
import kotlin.math.*
import java.util.*

val dir = arrayOf(
    intArrayOf(0,1),
    intArrayOf(0,-1),
    intArrayOf(1,0),
    intArrayOf(-1,0),
    intArrayOf(1,1),
    intArrayOf(-1,-1),
    intArrayOf(-1,1),
    intArrayOf(1,-1))

fun dfs(graph : Array<String>, map : MutableMap<String,Int>,n : Int, m : Int, maxK : Int, r : Int, c : Int,str : String){
    map.put(str,map.getOrDefault(str,0)+1)
    
    if(str.length==maxK)return

    for(i in dir.indices){
        var nR = (r+dir[i][0]+n)%n
        var nC = (c+dir[i][1]+m)%m
        dfs(graph,map,n,m,maxK,nR,nC,str+graph[nR][nC])
    }

}

fun makeMap(graph : Array<String>, map : MutableMap<String,Int>,n : Int, m : Int, maxK : Int){
    for(i in graph.indices){
        for(j in graph[i].indices){
            //각 시작점마다 dfs로 경로에 따라 생성되는 문자열 map에 저장
            //시작점이 다르므로 모두 다른 경로로 만들어진 문자열임
            dfs(graph,map,n,m,maxK,i,j,""+graph[i][j])
        }
    }
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var tk = StringTokenizer(br.readLine())
    val (n,m,k) = List(3){Integer.parseInt(tk.nextToken())}
    //그래프 입력
    val graph = Array<String>(n){""}
    for(i in 0 until n){
        graph[i]=br.readLine()
    }
    //신의 문자열 입력 및 이중 최대 길이 추출
    val godStr = Array<String>(k){""}
    var maxK = 0
    for(i in 0 until k){
        godStr[i] = br.readLine()
        maxK = max(maxK,godStr[i].length)
    }
    //map에 이동경로에 따른 문자열의 개수를 저장
    val map = mutableMapOf<String,Int>()
    makeMap(graph,map,n,m,maxK)

    for(i in 0 until k){
        if(map[godStr[i]]==null)
            write("0\n")
        else
            write("${map[godStr[i]]}\n")
    }

    close()
}
