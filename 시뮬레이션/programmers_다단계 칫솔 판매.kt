//https://programmers.co.kr/learn/courses/30/lessons/77486
//코드1.재귀
//이름 순 값 출력
//완탐가능
//최대 10000원 -> 5번 올라감
//seller 10만
//O(50만)
class Solution {

    val edge = mutableMapOf<String,String>()
    val result =  mutableMapOf<String,Int>()

    fun simulation(enroll: Array<String>, referral: Array<String>, who: String, cost: Int){
        //나만 갖고 끝
        if(cost/10<1){
            result.put(who,result.getOrDefault(who,0)+cost)
        }
        else{
            var yourCost = (cost*0.1).toInt()
            var myCost =  cost - yourCost
            result.put(who,result.getOrDefault(who,0)+myCost)
            if(who=="-") return
            simulation(enroll,referral,edge[who]!!, yourCost)
        }
    }

    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        //preset
        for(i in enroll.indices){
            edge[enroll[i]] = referral[i]
        }

        //solve
        for(i in seller.indices){
            simulation(enroll, referral, seller[i], amount[i]*100)
        }

        //output
        val answer = IntArray(enroll.size){
            result.getOrDefault(enroll[it],0)
        }

        return answer
    }
}
//코드2.반복문
//이름 순 값 출력
//완탐가능
//최대 10000원 -> 5번 올라감
//seller 10만
//O(50만)
class Solution {

    val edge = mutableMapOf<String,String>()
    val idxMap =  mutableMapOf<String,Int>()


    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        var answer = IntArray(enroll.size)
        //preset
        for(i in enroll.indices){
            edge[enroll[i]] = referral[i]
            idxMap[enroll[i]] = i
        }

        //solve
        for(i in seller.indices){
            var cost = amount[i]*100
            var who = seller[i]
            while(who!="-") {
                if (cost / 10 == 0) {
                    answer[idxMap[who]!!]+=cost
                    break
                } else {
                    var yourCost = cost /10
                    var myCost = cost - yourCost
                    answer[idxMap[who]!!]+=myCost
                    who = edge[who]!!
                    cost = yourCost
                }
            }
        }

        return answer
    }
}
