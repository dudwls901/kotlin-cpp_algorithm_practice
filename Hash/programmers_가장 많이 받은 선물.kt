//https://school.programmers.co.kr/learn/courses/30/lessons/258712
class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val scores = friends.associateWith { 0 }.toMutableMap()
        val result = mutableMapOf<String, Int>()
        val records = gifts
            .groupingBy { it }.eachCount()
            .onEach {
                val (from, to) = it.key.split(" ")
                scores[from] = scores.getOrDefault(from, 0) + it.value
                scores[to] = scores.getOrDefault(to, 0) - it.value
            }
        for (i in friends.indices) {
            val name1 = friends[i]
            val score1 = scores[friends[i]] ?: 0
            for (j in i + 1 until friends.size) {
                val name2 = friends[j]
                val score2 = scores[friends[j]] ?: 0
                if (name1 == name2) continue
                val key1 = "$name1 $name2"
                val key2 = "$name2 $name1"
                if ((records[key1] ?: 0) < (records[key2] ?: 0)) {
                    result[name2] = result.getOrDefault(name2, 0) + 1
                } else if ((records[key1] ?: 0) > (records[key2] ?: 0)) {
                    result[name1] = result.getOrDefault(name1, 0) + 1
                } else {
                    if (score1 < score2) {
                        result[name2] = result.getOrDefault(name2, 0) + 1
                    } else if (score1 > score2) {
                        result[name1] = result.getOrDefault(name1, 0) + 1
                    }
                }
            }
        }
        return result.maxByOrNull { it.value }?.value ?: 0
    }
}
