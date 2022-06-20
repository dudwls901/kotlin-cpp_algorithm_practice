//https://www.acmicpc.net/problem/2263
val br = System.`in`.bufferedReader()
val bw = System.out.bufferedWriter()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()
lateinit var inOrder: List<Int>
lateinit var inIndex: IntArray
lateinit var postOrder: List<Int>
fun getRoot(start: Int, end: Int, postStart: Int,  postEnd: Int){
    if(postStart>postEnd) return
    var rootIdx = inIndex[postOrder[postEnd]]
    val leftSize = rootIdx - start
    bw.write("${inOrder[rootIdx]} ")
    //왼쪽
    getRoot(start, rootIdx-1, postStart, postStart + leftSize-1)
    //오른쪽
    getRoot(rootIdx+1, end, postStart+leftSize, postEnd-1)
}

fun main(){
    //input
    val n = getInt()
    inOrder = getIntList()
    postOrder = getIntList()
    inIndex = IntArray((n+1))
    for(i in inOrder.indices){
        inIndex[inOrder[i]] = i
    }
    //solve
    getRoot(0,n-1,0,n-1)

    bw.close()
}
