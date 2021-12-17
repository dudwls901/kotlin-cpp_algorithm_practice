//https://www.acmicpc.net/problem/10451
//dfs
fun dfs(idx : Int, arr : List<Int> , visited : BooleanArray){
    visited[idx]=true
    val next = arr[idx]-1
    if(visited[next]) return
    dfs(next,arr,visited)
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    repeat(t){
        val n = br.readLine().toInt()
        val arr = br.readLine().split(' ').map{it.toInt()}
        var answer=0
        val visited = BooleanArray(n)
        for(i in 0 until n){
            if(visited[i])continue
            dfs(i,arr,visited)
            answer++
        }
        write("$answer\n")
    }
    close()
}
/*유니온 파인드
val br = System.`in`.bufferedReader()

fun getParent(x : Int, parent : IntArray) : Int{
    return if(x==parent[x]) x else getParent(parent[x],parent).also{parent[x]=it}
}

fun unionParent(x : Int, y : Int, parent : IntArray){
    val xx = getParent(x,parent)
    val yy = getParent(y,parent)

    if(xx>yy){
        parent[xx]=yy
    }
    else{
        parent[yy]=xx
    }
}
fun findParent(x : Int, y : Int, parent : IntArray) : Boolean{
    val xx = getParent(x,parent)
    val yy = getParent(y,parent)
    return xx==yy
}

fun main() = with(System.out.bufferedWriter()){

    val t = br.readLine().toInt()
    repeat(t){
        val n = br.readLine().toInt()
        val arr = br.readLine().split(' ').map{it.toInt()}
        val parent = IntArray(n){it}
        var answer=0
        for(i in 0 until n){
            if(!findParent(i,arr[i]-1,parent))
                unionParent(i,arr[i]-1,parent)
        }
        for(i in 0 until n){
            if(parent[i]==i) answer++
        }
        write("$answer\n")
    }
    close()
}
*/
