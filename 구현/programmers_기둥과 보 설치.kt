//https://programmers.co.kr/learn/courses/30/lessons/60061
class Solution {
    val state = Array(2){Array(102){BooleanArray(102)}}
    fun destroy(r : Int, c : Int, n : Int, kind : Int){
        //삭제하고 남은 기둥과 보가 조건에 어긋나지 않는지 체크
        state[kind][r][c]=false
        for(i in 0 .. n){
            for(j in 0 .. n){
                if(state[0][i][j]){
                    //조건에 어긋난다면 삭제 불가 -> 다시 살리고 종료
                    if(!canInstall(i,j,n,0)){
                        state[kind][r][c]=true
                        return
                    }    
                }
                if(state[1][i][j]){
                    //조건에 어긋난다면 삭제 불가 -> 다시 살리고 종료
                    if(!canInstall(i,j,n,1)){
                        state[kind][r][c]=true
                        return
                    }    
                }
                
            }
        }
    }
    
    fun canInstall(r : Int, c : Int, n : Int, kind : Int) : Boolean{
        //기둥 설치
        var check = false
        if(kind==0){
            if(r==n|| state[1][r][c]){
                check=true
            }
            else if(r<n && state[0][r+1][c]){
                check=true
            }
            else if(c>0 && state[1][r][c-1]){
                check=true  
            }
        }
        //보 설치
        else{
            if(c in 1 .. n-1 && state[1][r][c-1] && state[1][r][c+1]){
                check=true
            }
            else if(r<n &&c<n &&(state[0][r+1][c] || state[0][r+1][c+1])){
                check =true
            }
        }
        return check
    }
    
    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        var answer = ArrayList<IntArray>()
        //kind==0 기둥 1보
        //order==0 삭제 1설치
        for(input in build_frame){
            val (c,r,kind,order) =input
            when{
                //설치
                order==1 -> if(canInstall(n-r,c,n,kind)) state[kind][n-r][c]=true
                //삭제
                else -> destroy(n-r,c,n,kind)
            }
        }
        for(c in 0 .. n){
            for(r in n downTo 0){
                if(state[0][r][c]){
                    answer.add(intArrayOf(c,n-r,0))
                }
                if(state[1][r][c]){
                    answer.add(intArrayOf(c,n-r,1))
                }
            }
        }
        
        return answer.toTypedArray()
    }
}
