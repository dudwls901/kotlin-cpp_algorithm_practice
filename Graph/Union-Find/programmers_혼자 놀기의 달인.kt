//https://school.programmers.co.kr/learn/courses/30/lessons/131130
//dfs
class Solution {
    fun dfs(cur: Int, groupId: Int, cards: IntArray, group: IntArray) {
        if (group[cur] > 0) return
        group[cur] = groupId
        val next = cards[cur] - 1
        return dfs(next, groupId, cards, group)
    }

    fun solution(cards: IntArray): Int {
        val group = IntArray(cards.size) { 0 }
        var groupId = 1
        for (i in cards.indices) {
            if (group[i] > 0) continue
            dfs(i, groupId, cards, group)
            groupId++
        }
        return group
            .groupBy { it }
            .map { it.value.size }
            .sortedDescending()
            .takeIf { it.size >= 2 }
            ?.subList(0, 2)
            ?.reduce { a, b -> a * b }
            ?: 0
    }
}
