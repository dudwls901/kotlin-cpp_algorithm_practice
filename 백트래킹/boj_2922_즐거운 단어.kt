//https://www.acmicpc.net/problem/2922
val br = System.`in`.bufferedReader()
val vowels = setOf<Char>('A', 'E', 'I', 'O', 'U')
var answer = 0L
fun main() = with(System.out.bufferedWriter()) {

    //input
    val input = br.readLine()
    //solve
    backTracking(input.contains('L'), 1, 1, 0, 0, 0, input)
    //output
    write("$answer")
    close()
}

fun backTracking(haveL: Boolean, vowelLine: Long, consonantLine: Long, idx: Int, vowelCnt: Int, consonantCnt: Int, input: String) {
    if (vowelCnt == 3 || consonantCnt == 3) return
    if (idx == input.length) {
        if (!haveL) return
        answer += vowelLine * consonantLine
        return
    }
    val ch = input[idx]
    if (ch == '_') {
        //모음
        backTracking(haveL, vowelLine * 5, consonantLine, idx + 1, vowelCnt + 1, 0, input)
        //L제외 자음
        backTracking(haveL, vowelLine, consonantLine * 20, idx + 1, 0, consonantCnt + 1, input)
        //L
        backTracking(true, vowelLine, consonantLine, idx + 1, 0, consonantCnt + 1, input)
    } else {
        if (vowels.contains(ch)) {//모음인 경우
            backTracking(haveL, vowelLine, consonantLine, idx + 1, vowelCnt + 1, 0, input)
        } else {
            //자음인 경우
            backTracking(haveL, vowelLine, consonantLine, idx + 1, 0, consonantCnt + 1, input)
        }
    }
}
