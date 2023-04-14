//https://school.programmers.co.kr/learn/courses/30/lessons/176962
//정렬, stack, 구현이 중요
import java.util.*
data class Plan(
    val name: String,
    val start: Int,
    val period: Int
)
class Solution {
    fun solution(plans: Array<Array<String>>): Array<String> {
        val answer = Array<String>(plans.size){""}
        val myPlans = plans.map{
            Plan(
                it[0],
                it[1].toMinute(),
                it[2].toInt()
            )
        }.sortedBy{it.start}
        val stk = Stack<Plan>()
        var curPlan = myPlans[0]
        var idx = 0
        //현재 종료된 시간, 멈춘 과제의 남은 기간 갱신이 중요
        for(i in 1 until myPlans.size){
            val plan = myPlans[i]
            var curEndTime = curPlan.start + curPlan.period
            if(curEndTime < plan.start){ //다음 과제 이전에 진행중이던 과제가 끝난 경우
                answer[idx++] = curPlan.name
                while(stk.isNotEmpty()){//멈춘 과제들 검사
                    //멈춘 과제의 start를 현재 시간으로 갱신
                    val newPlan = stk.pop().copy(
                       start = curEndTime
                    )
                    //멈춘 과제의 종료 시간을 갱신
                    val newEndTime = newPlan.start + newPlan.period

                    if(newEndTime < plan.start){ //다음 과제 이전에 멈춘 과제가 끝난 경우
                        answer[idx++] = newPlan.name
                        curEndTime = newEndTime
                    }else if(newEndTime == plan.start){// 멈춘 과제 끝남과 동시에 다음 과제인 경우
                        answer[idx++] = newPlan.name
                        break
                    }else{ // 멈춘 과제 안 끝났는데 다음 과제 해야 하는 경우
                        stk.push(
                            newPlan.copy(
                                period = newEndTime - plan.start
                            )
                        )
                        break
                    }
                }
                curPlan = plan
            }else if(curEndTime == plan.start){ // 진행중이던 과제 끝남과 동시에 다음 과제인 경우
                answer[idx++] = curPlan.name
                curPlan = plan
            }else{// 진행중이던 과제 안 끝났는데 다음 과제 해야 하는 경우
                stk.push(
                    curPlan.copy(
                        period = curEndTime - plan.start
                    )
                )
                curPlan = plan
            }
        }
        //남은 진행중인 plan 정리
        curPlan?.let{
            answer[idx++] = it.name
        }
        //남은 멈춘 plan 정리
        while(stk.isNotEmpty()){
            answer[idx++] = stk.pop().name
        }
        
        return answer
    }
    
    fun String.toMinute(): Int{
        val (h,m) = this.split(":").map{it.toInt()}
        return h*60 + m
    }
}
