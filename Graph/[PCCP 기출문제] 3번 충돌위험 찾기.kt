//https://school.programmers.co.kr/learn/courses/30/lessons/340211
import java.util.*

data class Robot(
    var r: Int,
    var c: Int,
    var m: Int,
    val routes: IntArray,
)

class Solution {

    fun move(robotQ: Queue<Robot>, points: Array<IntArray>) {
        for (i in robotQ.indices) {
            val robot = robotQ.poll()

            var dr = points[robot.routes[robot.m + 1] - 1][0]
            var dc = points[robot.routes[robot.m + 1] - 1][1]
            //목적지 도달한 로봇
            if (robot.r == dr && robot.c == dc) {
                //다음 목표 설정
                robot.m++
                //로봇 종료
                if (robot.m == robot.routes.size - 1) continue
                dr = points[robot.routes[robot.m + 1] - 1][0]
                dc = points[robot.routes[robot.m + 1] - 1][1]
            }
            //로봇 이동
            if (robot.r > dr) robot.r--
            else if (robot.r < dr) robot.r++
            else if (robot.c > dc) robot.c--
            else if (robot.c < dc) robot.c++
            robotQ.add(robot)
        }
    }

    fun solution(points: Array<IntArray>, routes: Array<IntArray>): Int {
        var answer = 0
        val robotQ: Queue<Robot> = LinkedList()
        robotQ.addAll(
            routes.map {
                Robot(
                    r = points[it[0] - 1][0],
                    c = points[it[0] - 1][1],
                    m = 0,
                    routes = it,
                )
            }
        )
        while (robotQ.isNotEmpty()) {
            val overlaps = mutableMapOf<String, Int>()
            robotQ.forEach {
                overlaps["${it.r},${it.c}"] = overlaps.getOrDefault("${it.r},${it.c}", 0) + 1
            }
            answer += overlaps.count { it.value > 1 }
            move(robotQ, points)
        }
        return answer
    }
}
