//https://programmers.co.kr/learn/courses/30/lessons/60058
import java.util.*
class Solution {
    //올바른 문자열인지 확인
    fun isRight(str: String):Boolean{
        val stk = Stack<Char>()
        for(i in 0 until str.length){
            if(str[i]=='('){
                stk.add('(')
            }
            else{
                if(stk.isEmpty()){
                    return false
                }
                else{
                    stk.pop()
                }
            }
        }
        return true
    }
    //재귀 함수 구현
    fun solve(w : String):String{
        var answer=""
        if(w.length==0) return answer
        var u =""
        var v =""
        var op=0
        var cl=0
        for(i in 0 until w.length){
            u +=w[i]
            if(w[i]=='('){
                op++
            }
            else{
                cl++
            }
            if(op==cl){
                v = w.substring(i+1,w.length)
                break
            }
        }
        //uv구했음
        //u가 올바르다면
        if(isRight(u)){
            answer+=u
            answer+=solve(v)
        }
        else{
            var temp ="("+solve(v)+")"
                var removeU = u.substring(1,u.length-1)
                for(ch in removeU){
                    if(ch=='('){
                        temp+=')'
                    }
                    else{
                        temp+='('
                    }
                }
            answer+=temp
        }
         return answer
    }
    fun solution(p: String): String {
        //괄호의 짝수는 맞다.
        //u는 균형잡힐때까지
        var w= p

        
        return solve(w)
    }
}
