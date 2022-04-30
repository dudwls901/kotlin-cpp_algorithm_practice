//https://programmers.co.kr/learn/courses/30/lessons/12945
//반복문
class Solution {
    fun solution(n: Int): Int {
        var arr = arrayOf(1,1,1)
        if(n==2) return 1
        repeat(n-2){
            arr[2] = (arr[0]+arr[1])%1234567
            arr[0] = arr[1]
            arr[1] = arr[2]
        }
        return arr[2]
    }
}
//재귀+메모이제이션
class Solution {
    lateinit var arr: IntArray
    fun solution(n: Int): Int {
        arr = IntArray(n+1)
        arr[1] = 1
        return fibonacci(n)
    }
    tailrec fun fibonacci(n: Int): Int{
        if(n<2) return arr[n]
        if(arr[n]>0) return arr[n]
        return  ((fibonacci(n-1)+ fibonacci(n-2))%1234567).also { arr[n] = it }
    }
}
