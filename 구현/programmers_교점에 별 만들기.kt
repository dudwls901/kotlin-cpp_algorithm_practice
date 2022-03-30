//https://programmers.co.kr/learn/courses/30/lessons/87377
class Solution {
    
    val INF = Int.MAX_VALUE
    
    var maxY=-INF
    var maxX=-INF
    var minY=INF
    var minX=INF
    
    fun solution(line: Array<IntArray>): Array<String> {
        val xyArr = ArrayList<Pair<Int,Int>>()
        
        for(i in line.indices){
            for(j in i+1 until line.size){
                val (A,B,E) = line[i].map{it.toLong()}
                val (C,D,F) = line[j].map{it.toLong()}

                val adbc = A*D-B*C
                val bfed = B*F-E*D
                val ecaf = E*C-A*F
                //평행한 경우
                if(adbc == 0L) continue
                //정수가 아닌 경우
                if(bfed%adbc!=0L || ecaf%adbc!=0L) continue
                
                val x = (bfed/adbc).toInt()
                val y = (ecaf/adbc).toInt()

                //x,y저장
                xyArr.add(Pair(x,y))
                
                //최대 최소 갱신
                maxX = maxX.coerceAtLeast(x)
                minX = minX.coerceAtMost(x)
                maxY = maxY.coerceAtLeast(y)
                minY = minY.coerceAtMost(y)
                
            }
        }
    
        //별 찍기
        val graph = Array(maxY-minY+1){CharArray(maxX-minX+1){'.'}}
    
        for(xy in xyArr){
            val r = maxY-xy.second
            val c = xy.first-minX
            graph[r][c]='*'
        }
        
        val answer = Array(graph.size){String(graph[it])}

        return answer
    }
}
