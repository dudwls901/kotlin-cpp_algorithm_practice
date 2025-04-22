//https://www.acmicpc.net/problem/16508
val br = System.`in`.bufferedReader()
fun getStr() = br.readLine().trim()
fun getInt() = br.readLine().trim().toInt()

data class Book(
    val price: Int,
    val name: String,
)


lateinit var books: Array<Book>
var answer = Int.MAX_VALUE
fun canMakeWord(countTargetChars: IntArray, countSelectedChars: IntArray): Boolean {
    for (i in countTargetChars.indices) {
        if (countTargetChars[i] > countSelectedChars[i]) return false
    }
    return true
}

fun combination(len: Int, n: Int, countTargetChars: IntArray, countSelectedChars: IntArray, price: Int) {
    if (len == n) {
        if (canMakeWord(countTargetChars, countSelectedChars)) answer = answer.coerceAtMost(price)
        return
    }
    for (ch in books[len].name) {
        countSelectedChars[ch - 'A']++
    }
    combination(len + 1, n, countTargetChars, countSelectedChars, price + books[len].price)
    for (ch in books[len].name) {
        countSelectedChars[ch - 'A']--
    }
    combination(len + 1, n, countTargetChars, countSelectedChars, price)
}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val target = getStr()
    val countTargetChars = IntArray(26)
    for (ch in target) {
        countTargetChars[ch - 'A']++
    }
    val n = getInt()
    books = Array(n) {
        val (price, name) = getStr().split(' ')
        Book(price.toInt(), name)
    }
    //solve
    combination(0, n, countTargetChars, IntArray(26), 0)
    //output
    write("${if (answer == Int.MAX_VALUE) -1 else answer}")
    close()
}
