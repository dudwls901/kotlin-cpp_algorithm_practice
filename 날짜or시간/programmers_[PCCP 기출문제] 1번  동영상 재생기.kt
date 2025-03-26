//https://school.programmers.co.kr/learn/courses/30/lessons/340213
class Solution {
    val String.seconds: Int
        get() {
            val (min, sec) = this.split(":")
            return min.toInt() * 60 + sec.toInt()
        }
    val Int.formattedTime: String
        get() {
            val min = this / 60
            val sec = this % 60
            return String.format("%02d:%02d", min, sec)
        }

    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        var answer = pos.seconds
        commands.forEach { command ->
            when (command) {
                "prev" -> {
                    answer = if (answer >= op_start.seconds && answer < op_end.seconds) {
                        op_end.seconds - 10
                    } else if (answer - 10 >= op_start.seconds && answer - 10 <= op_end.seconds) {
                        op_end.seconds
                    } else {
                        (answer - 10).coerceAtLeast(0)
                    }
                }
                "next" -> {
                    answer = if (answer >= op_start.seconds && answer < op_end.seconds) {
                        op_end.seconds + 10
                    } else if (answer + 10 >= op_start.seconds && answer + 10 <= op_end.seconds) {
                        op_end.seconds
                    } else {
                        (answer + 10).coerceAtMost(video_len.seconds)
                    }
                }
            }
        }
        return answer.formattedTime
    }
}
