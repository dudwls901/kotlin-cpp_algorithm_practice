//https://school.programmers.co.kr/learn/courses/30/lessons/161989
//1
class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        val wall = BooleanArray(n){true}
        for(sec in section){
            wall[sec-1] = false
        }
        for(i in wall.indices){
            if(wall[i].not()){
                paint(wall,i,m,n)
                answer++
            }
        }
        return answer
    }
    
    fun paint(wall: BooleanArray, cur: Int, len: Int, n: Int){
        for(i in 0 until len){
            if(cur+i >= n) return
            wall[cur+i] = true
        }
    }
}
//2
class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        var next = 0
        for(sec in section){
            if(next < sec){
                answer++
                next = sec + m-1
            }
        }
        return answer
    }
}
