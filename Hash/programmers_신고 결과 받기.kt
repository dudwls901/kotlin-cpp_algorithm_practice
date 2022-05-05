//https://programmers.co.kr/learn/courses/30/lessons/92334
class Solution {

    val idMap = mutableMapOf<String,Int>()
    lateinit var reportedWho: Array<ArrayList<Int>>
    val reportCnt = mutableMapOf<String,Int>()

    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        //preset
        val answer = IntArray(id_list.size)
        for(i in id_list.indices){
            idMap[id_list[i]]=i
        }
        reportedWho = Array(id_list.size){ArrayList()}

        report.distinct().apply {
            this.forEach { line->
                val words = line.split(' ')
                reportedWho[idMap[words[1]]!!].add(idMap[words[0]]!!)
                reportCnt.put(words[1],reportCnt.getOrDefault(words[1],0)+1)
            }
        }
        reportCnt.forEach { s, i ->
            //k번 이상 신고당했으면
            if(i>=k){
                for(who in reportedWho[idMap[s]!!]){
                    answer[who]++
                }
            }
        }
        return answer
    }
}
