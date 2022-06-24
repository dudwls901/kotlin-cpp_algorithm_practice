//https://www.acmicpc.net/problem/17480
import java.util.*
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

/*
* 1.가능한 문자열 추출
* 2.추출한 문자열로 dfs하여 최종 문자열 추출 (중복 불가)
* */
val chArr = IntArray(26)
var len = 0
val resultSet = mutableSetOf<String>()

fun reverse(s: Int, e: Int, word: StringBuilder){
    for(i in s until (s+e)/2){
        word[e-1-(i-s)] = word[i].also{word[i] = word[e-1-(i-s)]}
    }
}

//e는 길이 (마지막 인덱스+1)
fun binaryDfs(s: Int, e: Int, word: StringBuilder){
    if(s>=e-1){
        if(!resultSet.contains(word.toString())){
            resultSet.add(word.toString())
        }
        return
    }
    val len = s+e
    var mid = (len)/2

    //왼쪽 reverse, 오른쪽 반띵
    reverse(s,mid,word)
    binaryDfs(mid,e,word)
    reverse(s,mid,word)

    //오른쪽 reverse, 왼쪽 반띵
    reverse(mid,e,word)
    binaryDfs(s,mid,word)
    reverse(mid,e,word)

    //길이가 홀수인 경우는 나누는 방법이 2가지
    if(len%2!=0){
        mid++
        //왼쪽 reverse, 오른쪽 반띵
        reverse(s,mid,word)
        binaryDfs(mid,e,word)
        reverse(s,mid,word)

        //오른쪽 reverse, 왼쪽 반띵
        reverse(mid,e,word)
        binaryDfs(s,mid,word)
        reverse(mid,e,word)
    }
}

fun canWord(idx: Int, word: String): Boolean {

    val tempChArr = IntArray(26) { chArr[it] }

    for (i in 0 until len) {
        if (tempChArr[word[idx + i] - 'a'] == 0) return false
        tempChArr[word[idx + i] - 'a']--
    }
    return true
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    br.readLine().split(' ').apply {
        for (i in 0 until this.size - 1 step 2) {
            val cnt = Character.getNumericValue(this[i + 1][0])
            chArr[this[i][0] - 'a'] = cnt
            len += cnt
        }
    }
    val word = br.readLine()

    //solve
    //가능한 문자열 추출
    for (i in 0 .. word.length - len) {
        if(canWord(i, word)){
            val subWord = word.substring(i,i+len)
            //가능한 문자열로 최종 문자열 찾기
            binaryDfs(0,subWord.length,StringBuilder(subWord))
        }
    }
    //output
    write("${resultSet.size}")
    close()
}
