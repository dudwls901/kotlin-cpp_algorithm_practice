//https://programmers.co.kr/learn/courses/30/lessons/92335
class Solution {

    fun isPrime(num: Long): Int{
        if(num<=1) return 0

        for(i in 2 ..Math.sqrt(num.toDouble()).toLong()){
            if(num%i==0L) return 0
        }
        return 1
    }

    fun changeNum(n: Int, k: Int): String{
        val strBuilder = StringBuffer()
        var num = n
        while(num!=0){
            strBuilder.append(num%k)
            num /=k
        }
        return strBuilder.reverse().toString()
    }


    fun solution(n: Int, k: Int): Int {
        var answer=0

        var num=0L
         changeNum(n,k).apply {
             for(ch in this){
                 if(ch=='0'){
                     //조건 맞으면
                     answer+=isPrime(num)
                     num=0
                 }
                 else{
                     num = num*10 +Character.getNumericValue(ch)
                 }
             }
         }

        //남은 Num 처리
        answer+=isPrime(num)

        return answer
    }
}
