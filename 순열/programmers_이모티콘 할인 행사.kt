//https://school.programmers.co.kr/learn/courses/30/lessons/150368
data class Emoticon(
    val cost: Int,
    val sale: Int
)

class Solution {
    
    val sales = arrayOf(
        arrayOf(100,90),
        arrayOf(100,80),
        arrayOf(100,70),
        arrayOf(100,60)
    )
    val answer = ArrayList<IntArray>()
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        val myEmoticons = emoticons.map{
            Emoticon(it,0)
        }.toMutableList()
        permutation(0,users,myEmoticons)
        answer.sortWith(compareByDescending<IntArray>{it[0]}.thenByDescending{it[1]})
        return answer[0]
    }
    
    fun buying(users: Array<IntArray>, emoticons: MutableList<Emoticon>): IntArray{
        var plusCnt = 0
        var cost = 0
        for(user in users){
            var userCost = 0
            emoticons.forEach{
                if(it.sale >= user[0]) {
                    userCost+=it.cost
                }
            }
            if(userCost >= user[1]){
                plusCnt++
            }else{
                cost +=userCost
            }
        }
        return intArrayOf(plusCnt, cost)
    }
    
    fun permutation(idx: Int, users: Array<IntArray>, emoticons: MutableList<Emoticon>){
        //종료
        if(idx == emoticons.size){
            //check
            answer.add(buying(users, emoticons))
            return
        }
        
        for(i in sales.indices){
            val sale = sales[i]
            emoticons[idx] = Emoticon(emoticons[idx].cost/sale[0]*sale[1], i.getSale())
            permutation(idx+1, users, emoticons)
            emoticons[idx] = Emoticon(emoticons[idx].cost/sale[1]*sale[0], 0)
        }
    }
    
    fun Int.getSale() = when(this){
        0 -> 10
        1 -> 20
        2 -> 30
        3 -> 40
        else -> 0
    }
}
