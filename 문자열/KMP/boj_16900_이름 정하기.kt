//https://www.acmicpc.net/problem/16900
val br = System.`in`.bufferedReader()

fun makeTable(pattern : String) : IntArray{
    val table = IntArray(pattern.length)
    var j=0
    for(i in 1 until table.size){
        while(j>0 && pattern[i] !=pattern[j]){
            j = table[j-1]
        }
        if(pattern[i]==pattern[j]){
            table[i] = ++j
        }
    }
    return table
}

fun main() = with(System.out.bufferedWriter()){
    val (pattern, str) = br.readLine().split(' ')
    val k = str.toLong()
    val table =  makeTable(pattern)
    write("${pattern.length+(pattern.length-table[table.size-1])*(k-1)}")
    close()
}
