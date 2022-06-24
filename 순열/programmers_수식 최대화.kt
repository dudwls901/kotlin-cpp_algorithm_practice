//https://programmers.co.kr/learn/courses/30/lessons/67257
import java.util.*
class Solution {
    /*
    1. 우선순위 조합 3!
    2. 순열로 구한 우선순위로 연산 (100/2) * 3
    */
    val operators = arrayOf('+','-','*')
    var answer = 0L

    fun cal(op: Char, left: Long, right: Long): Long{
        return when(op){
            '+' -> left+right
            '-' -> left-right
            else -> left*right
        }
    }

    fun solve(order: Array<Int>, numArr: ArrayList<Long>, opArr: ArrayList<Char>){
        for(o in order){
            val curOp = operators[o]
            //이전 연산자 위치
            var i =0
            while(i < opArr.size){
                //현재 순서 연산자라면 연산
                val op = opArr[i]
                if(op==curOp){
                    numArr[i] = cal(op, numArr[i],numArr[i+1])
                    numArr.removeAt(i+1)
                    opArr.removeAt(i)
                    i--
                }
                i++
            }
        }
        answer = answer.coerceAtLeast(Math.abs(numArr[0]))
    }

    fun solution(expression: String): Long {
        //preset
        val numArr = ArrayList<Long>()
        val opArr = ArrayList<Char>()
        var num = StringBuilder()
        for(ch in expression){
            if(ch.isDigit()){
                num.append(ch)
            }
            else{
                if(num.isNotEmpty()){
                    numArr.add(num.toString().toLong())
                    num.clear()
                }
                opArr.add(ch)
            }
        }
        if(num.isNotEmpty()){
            numArr.add(num.toString().toLong())
        }
        //permutation
        for(a in 0 until 3){
            for(b in 0 until 3){
                for(c in 0 until 3){
                    if(a!=b && b!=c && a!=c){
                        //solve
                        solve(arrayOf(a,b,c), ArrayList<Long>(numArr), ArrayList<Char>(opArr))
                    }
                }
            }
        }
        return answer
    }
}
