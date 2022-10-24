//https://www.acmicpc.net/problem/1713
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().trim().split(' ').map { it.toInt() }
fun getInt() = br.readLine().trim().toInt()

data class Student(
    val num: Int,
    var cnt: Int,
    val age: Int,
)
val comp = kotlin.Comparator<Student>{ a, b->
    when{
        a.cnt > b.cnt -> -1
        a.cnt == b.cnt -> {
            when{
                a.age > b.age -> -1
                a.age == b.age -> 0
                else -> 1
            }

        }
        else -> 1
    }
}

fun main() = with(System.out.bufferedWriter()) {

    val n = getInt()
    getInt()
    val arr = ArrayList<Student>()
    with(getIntList()) {
        this.forEachIndexed { idx, num ->
            val founded= arr.find { it.num == num }
            if(founded == null){
                if(arr.size==n) {
                    arr.sortWith(comp)
                    arr.removeAt(arr.lastIndex)
                }
                arr.add(Student(num,1,idx))
            }else{
                founded.cnt++
            }
        }
    }
    arr.sortWith(comp)
    write(arr.sortedBy { it.num }.map { it.num }.joinToString(" "))

    close()
}
