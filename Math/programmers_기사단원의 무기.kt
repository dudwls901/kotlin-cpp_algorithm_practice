//https://school.programmers.co.kr/learn/courses/30/lessons/136798
class Solution {
    fun makePrime(number: Int): IntArray{
        val primes = IntArray(number+1){1}
        for(num in 2 .. number){
            for(i in num .. number step num){
                primes[i]++
            }
        }
        return primes
    }
    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer: Int = 0
        val primes = makePrime(number)
        var sum = 0
        for(i in 1 until primes.size){
            val num = primes[i]
            sum += if(num > limit) power else num
        }
        return sum
    }
}
