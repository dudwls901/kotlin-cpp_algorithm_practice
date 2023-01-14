//https://www.acmicpc.net/problem/6443
val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().trim().toInt()
fun main() {

    //input
    val bw = System.out.bufferedWriter()
    repeat(getInt()) {
        //solve
        val word = br.readLine()
        val words = IntArray(26)
        word.forEach {
            words[(it - 'a')]++
        }
        backTracking(0, words, CharArray(word.length), bw)
    }
    bw.close()
}


fun backTracking(idx: Int, words: IntArray, result: CharArray, bw: java.io.BufferedWriter) {
    if (idx == result.size) {
        bw.write("${String(result)}\n")
        return
    }
    for(i in words.indices){
        if(words[i]==0) continue
        result[idx] = 'a'+i
        words[i]--
        backTracking(idx+1, words, result, bw)
        words[i]++
    }
}
