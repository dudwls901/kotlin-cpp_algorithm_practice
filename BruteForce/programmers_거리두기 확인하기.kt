//https://programmers.co.kr/learn/courses/30/lessons/81302
class Solution {
    val dis1 = arrayOf(
        arrayOf(1,-1),
        arrayOf(1,0),
        arrayOf(1,1),
        arrayOf(0,1)
    )
    fun solution(places: Array<Array<String>>): IntArray {
        var answer = IntArray(places.size){1}
        
        for(p in places.indices){
            val place = places[p]
            label@for(r in 0 until 5){
                for(c in 0 until 5){
                    if(place[r][c]!='P') continue
                    //dis1인 경우 검사
                    for(i in dis1.indices){
                        val nr = r+dis1[i][0]
                        val nc = c+dis1[i][1]
                        if(nr !in 0 until 5 || nc !in 0 until 5) continue
                        //P인 경우만 검사
                        if(place[nr][nc]!='P') continue
                        //대각
                        if(i%2==0){
                            if(place[r+1][c]!='X' || place[nr-1][nc]!='X'){
                                answer[p] = 0
                                break@label
                            }   
                        }
                        //인접
                        else{
                            answer[p]=0
                            break@label
                        }
                    }
                    //dis2인 경우 검사
                    val nr=r+2
                    val nc=c+2
                    if((nr <5 && place[nr][c]=='P'&& place[nr-1][c]!='X')||
                            (nc<5 && place[r][nc]=='P' && place[r][nc-1]!='X')
                            ){
                        answer[p]=0
                        break@label
                    }
                }
            }   
        }
            
        return answer
    }
}
