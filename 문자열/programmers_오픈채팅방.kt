//https://programmers.co.kr/learn/courses/30/lessons/42888
import java.util.StringTokenizer
class Solution {
    fun solution(record: Array<String>): Array<String> {
        //1<= record <=100000
        val idMap = mutableMapOf<String,String>()
        val result = ArrayList<Result>()
        for(i in record.indices){
            val tk = StringTokenizer(record[i])
            var b=0
            val order = tk.nextToken()
            val id = tk.nextToken()
            var name=""
            if(tk.hasMoreTokens()){
               name=tk.nextToken()
            }
            if(order=="Enter"){
                //enter
                result.add(Result(id,false))
                idMap[id]=name
            }
            //leave
            else if(order=="Leave"){
                result.add(Result(id,true))
            }
            //change
            else{
                idMap[id]=name
            }
        }

         val answer = Array<String>(result.size){""}
         for(i in answer.indices){
             if(result[i].leave)
             answer[i] = idMap[result[i].id]+"님이 나갔습니다."
             else
             answer[i] = idMap[result[i].id]+"님이 들어왔습니다."
         }
        
        return answer
    }
}
data class Result(var id : String , var leave : Boolean)
