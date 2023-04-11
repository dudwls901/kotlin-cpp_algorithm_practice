//https://school.programmers.co.kr/learn/courses/30/lessons/178871
class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        val idxMap = mutableMapOf<String,Int>()
        for(i in players.indices){
            val player = players[i]
            idxMap[player] = i
        }
        for(call in callings){
            val callIdx = idxMap[call]!!
            players[callIdx-1] = call.also{
                idxMap[call] = callIdx-1
                idxMap[players[callIdx-1]] = callIdx
                players[callIdx] = players[callIdx-1]
            }
        }
        return players
    }
}
