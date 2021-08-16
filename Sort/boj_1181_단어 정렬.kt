//https://www.acmicpc.net/problem/1181

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(System.out.bufferedWriter()) {
    val br = BufferedReader(InputStreamReader(System.`in`))
//    val path = "C:\\Kotlin\\HelloKotlin\\app\\src\\main\\java\\com\\example\\hellokotlin\\input.txt"
//    val br = File(path).bufferedReader()
    var t = Integer.parseInt(br.readLine())
    val set = mutableSetOf<String>()
    for (i in 0 until t) {
        set.add(br.readLine())
    }
    val resultSet = set.sortedWith(Comparator { a, b ->
        when {
            a.length < b.length -> -1
            a.length == b.length -> when {
                a < b -> -1
                else -> 1
            }
            else -> 1
        }
    })
    for (item in resultSet) {
        write("$item\n")
    }
    close()
}
