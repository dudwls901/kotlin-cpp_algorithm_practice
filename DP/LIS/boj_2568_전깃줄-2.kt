//https://www.acmicpc.net/problem/2568
fun biInsert(num : Int, dp : IntArray, start : Int, end : Int, lastIdx : Int) : Int{
    val mid = (start+end)/2
    if(start>=end){
        dp[mid] = num
        return mid
    }
    if(dp[mid]>num){
        return biInsert(num,dp,start,mid,lastIdx)
    }
    else{
        return biInsert(num,dp,mid+1,end,lastIdx)
    }
}

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val edge = Array<Pair<Int,Int>>(n){Pair(0,0)}
    val lis =  IntArray(n)
    val idxArr = IntArray(n)
    val used = BooleanArray(500001)
    for(i in 0 until n){
        val (from,to) = br.readLine().split(' ').map{it.toInt()}
        edge[i]= Pair(from,to)
    }
    edge.sortWith(Comparator{ a,b ->
        when{
            a.first < b.first -> -1
            else -> 1
        }
    })
    lis[0]=edge[0].second
    idxArr[0]=0
    var lisIdx=1
    for(i in 1 until edge.size){
        //이전 전깃줄이 현재 전깃줄보다 위에 연결된 경우
        if(lis[lisIdx-1]<edge[i].second){
            lis[lisIdx++]=edge[i].second
            idxArr[i]=lisIdx-1
        }
        else{
            val idx = biInsert(edge[i].second, lis,0, lisIdx,lisIdx-1)
            idxArr[i]=idx
        }
    }
    var len = lisIdx-1
    for(i in idxArr.size-1 downTo 0 ){
        if(len==idxArr[i]){
            used[edge[i].first]=true
            len--
        }
    }
    write("${n-lisIdx}\n")

    for(pair in edge){
        if(used[pair.first])continue
        write("${pair.first}\n")
    }
    close()
}
