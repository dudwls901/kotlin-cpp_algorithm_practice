//https://programmers.co.kr/learn/courses/30/lessons/12939


//평균 수행시간 15초
class Solution {
    fun solution(s: String): String {
       var arr =s.split(" ").map{it.toInt()}
        return "${arr.min().toString()} ${arr.max().toString()}"
    }
}

//평균 수행시간 0.2초
import java.util.StringTokenizer
import kotlin.math.*
class Solution {
    fun solution(s: String): String {
      val tk = StringTokenizer(s)
      var max = Integer.parseInt(tk.nextToken())
      var min  = max
      while(tk.hasMoreTokens()){
          val num = Integer.parseInt(tk.nextToken())
          max = max(max,num)
          min = min(min,num)
      }
     return "$min $max"   
    }
}
