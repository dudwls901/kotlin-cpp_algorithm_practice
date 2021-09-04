//https://programmers.co.kr/learn/courses/30/lessons/72411
class Solution {
    fun combination(idx : Int, order : String, courseType : Set<Int>, map : Array<MutableMap<String,Int>>,result : String){
        if(result.length>order.length) return
        if(courseType.indexOf(result.length)!=-1){
            val temp = String(result.toCharArray().sortedArray())
            map[result.length].put(temp,map[result.length].getOrDefault(temp,0)+1)
        }
        for(i in idx until order.length){
            combination(i+1,order,courseType,map,result+order[i])
        }
    }
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        var map = Array<MutableMap<String,Int>>(course[course.size-1]+1){mutableMapOf<String,Int>()}
        val courseType = course.toSet()
        
        for(i in orders.indices){
            combination(0,orders[i],courseType,map,"")
        }
        val answerCopy = ArrayList<String>()
        for(se in courseType){
            if(map[se].isEmpty())continue
            val list =map[se].toList().sortedWith(Comparator {a,b -> 
                when{
                    a.second < b.second ->1
                    a.second == b.second -> when{
                        a.first < b.first ->-1
                        else -> 1
                    }
                    else -> -1
                }}).toList()
            val cnt = list[0].second
            if(cnt<2) continue
            for(i in list){
                if(i.second!=cnt)break
                answerCopy.add(i.first)
            }
                
        }
        
        return answerCopy.toTypedArray().sortedArray()
    }
}
