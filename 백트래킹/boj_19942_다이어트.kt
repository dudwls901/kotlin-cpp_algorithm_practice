//https://www.acmicpc.net/problem/19942
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

var minNurients = IntArray(4)
lateinit var nurients: List<List<Int>>
lateinit var answerNurients: List<Int>
var answerCost = Int.MAX_VALUE


fun canMatch(resultNurients: IntArray): Boolean {
    return (resultNurients[0] >= minNurients[0] &&
            resultNurients[1] >= minNurients[1] &&
            resultNurients[2] >= minNurients[2] &&
            resultNurients[3] >= minNurients[3])
}

fun backTracking(n: Int, idx: Int, resultGredient: ArrayList<Int>, resultNurients: IntArray) {

    //이미 구한 식재료 최솟값 이상인 경우 필요 없음
    //사전순에서 밀리기 때문
    if (answerCost <= resultNurients[4]) {
        return
    }
    //최소 영양소를 넘기면 더 이상 식재료 추가할 필요 없음
    if (canMatch(resultNurients)) {
        answerNurients = resultGredient.toList()
        answerCost = resultNurients[4]
        return
    }

    //더 이상 검사할 식재료가 없음
    if (idx == n) {
        return
    }

    for (i in idx until n) {
        resultGredient.add(i)
        backTracking(
            n,
            i + 1,
            resultGredient,
            intArrayOf(
                resultNurients[0] + nurients[i][0],
                resultNurients[1] + nurients[i][1],
                resultNurients[2] + nurients[i][2],
                resultNurients[3] + nurients[i][3],
                resultNurients[4] + nurients[i][4]
            )
        )
        resultGredient.removeAt(resultGredient.lastIndex)
    }


}

fun main() = with(System.out.bufferedWriter()) {
    //input
    val n = getInt()
    minNurients = getIntList().toIntArray()
    nurients = List(n) { getIntList() }


    //solve
    backTracking(n, 0, ArrayList<Int>(), IntArray(5))

    //output
    if(answerCost== Int.MAX_VALUE){
        write("-1")
    }
    else {
        write("$answerCost\n")
        for (num in answerNurients) {
            write("${num + 1} ")
        }
    }

    close()
}
