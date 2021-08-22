//https://programmers.co.kr/learn/courses/30/lessons/42861
class Solution {
    fun getParent(parent : IntArray, x : Int): Int{
        return if(parent[x]==x) x else getParent(parent,parent[x]).also{ parent[x] = it}
    }
   fun unionParent(parent : IntArray, a : Int, b : Int){
       val x = getParent(parent, a)
       val y = getParent(parent, b)
       if(x<y){
           parent[y]=x
       }
       else{
           parent[x]=y
       }
   }
   fun findParent(parent : IntArray, a : Int, b : Int) : Boolean{
       val x = getParent(parent, a)
       val y = getParent(parent, b)
       return if(x==y) true else false
    }
    
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        val parent = IntArray(n){it}
        //비용 별로 오름차순
        costs.sortWith(Comparator(){a,b ->a[2]-b[2]})

        for(i in costs.indices){
            if(!findParent(parent,costs[i][0],costs[i][1])){
                //부모가 같지 않다면 (싸이클이 없다면)
                unionParent(parent,costs[i][0],costs[i][1])
                answer+=costs[i][2]
            }
        }
        return answer
    }
}
