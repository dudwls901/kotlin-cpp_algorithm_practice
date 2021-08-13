import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
fun main() = with(System.out.bufferedWriter()) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var t = Integer.parseInt(br.readLine())
    var answer = 0L
    var gorilla = mutableMapOf<String, PriorityQueue<Int>>()
    while (t-- != 0) {
        val tk = StringTokenizer(br.readLine())
        val order = Integer.parseInt(tk.nextToken())
        val name = tk.nextToken()
        var cnt = Integer.parseInt(tk.nextToken())

        if (order == 1) {
            for (i in 0 until cnt) {
                if (gorilla.get(name) == null) {
                    gorilla.put(name, PriorityQueue<Int>(Collections.reverseOrder()))
                }
                gorilla[name]?.add(Integer.parseInt(tk.nextToken()))
            }
        } else {
            if (gorilla[name]!=null) {
                while (cnt-- != 0 && !gorilla[name]!!.isEmpty()) {
                    answer+=gorilla[name]!!.poll()

                }
            }

        }
    }
    write("$answer")
    close()
    br.close()
}


