//https://www.acmicpc.net/problem/12094
val br = System.`in`.bufferedReader()
var answer =0
var maxVal = 0
fun check(n : Int, graph : Array<IntArray>, temp : Array<IntArray>) : Boolean{
    var isSame = true
    for(i in 0 until n){
        for(j in 0 until n){
            maxVal = maxVal.coerceAtLeast(temp[i][j])
            if(graph[i][j]!=temp[i][j])
                isSame= false
        }
    }
    return isSame
}

fun move(i : Int, n : Int, temp : Array<IntArray>){
    when{
        //상
        i==0 ->{
            for(c in 0 until n){
                for(r in 0 until n-1){
                    //현재 칸에 블럭이 있는 경우 합치기
                    if(temp[r][c]!=0){
                        var idx=r+1
                        //아래측의 최초 블럭
                        while(idx<n && temp[idx][c]==0){
                            idx++
                        }
                        //아래측에 블럭이 없는 경우
                        if(idx==n) break
                        //숫자가 같은 경우
                        if(temp[r][c]==temp[idx][c]){
                            temp[r][c]*=2.also{temp[idx][c]=0}
                        }
                        //숫자가 다른 경우
                        else{
                            temp[r+1][c]=temp[idx][c].also{temp[idx][c]=0}
                        }
                    }
                }
                for(r in 0 until n){
                    //이동한 그래프의 최댓값 찾기
                    maxVal=maxVal.coerceAtLeast(temp[r][c])
                    //현재 칸에 블럭이 없는 경우 swap
                    if(temp[r][c]==0){
                        var idx=r+1
                        //아래측의 최초 블럭
                        while(idx<n &&temp[idx][c]==0){
                            idx++
                        }
                        //아래측에 블럭이 없는 경우
                        if(idx==n) break
                        //아래측에 블럭이 있는 경우 swap
                        temp[r][c]=temp[idx][c].also{temp[idx][c]=0}
                    }
                }
            }
        }
        //하
        i==1 ->{
            for(c in 0 until n){
                for(r in n-1 downTo 1){
                    //현재 칸에 블럭이 있는 경우 합치기
                    if(temp[r][c]!=0){
                        var idx=r-1
                        //위측의 최초 블럭
                        while(idx>=0 && temp[idx][c]==0){
                            idx--
                        }
                        //위측에 블럭이 없는 경우
                        if(idx<0) break
                        //숫자가 같은 경우
                        if(temp[r][c]==temp[idx][c]){
                            temp[r][c]*=2.also{temp[idx][c]=0}
                        }
                        //숫자가 다른 경우
                        else{
                            temp[r-1][c]=temp[idx][c].also{temp[idx][c]=0}
                        }
                    }
                }
                for(r in n-1 downTo 0){
                    //이동한 그래프의 최댓값 찾기
                    maxVal=maxVal.coerceAtLeast(temp[r][c])
                    //현재 칸에 블럭이 없는 경우 swap
                    if(temp[r][c]==0){
                        var idx=r-1
                        //위측의 최초 블럭
                        while(idx>=0 && temp[idx][c]==0){
                            idx--
                        }
                        //위측에 블럭이 없는 경우
                        if(idx<0) break
                        //위측에 블럭이 있는 경우 swap
                        temp[r][c]=temp[idx][c].also{temp[idx][c]=0}
                    }
                }
            }
        }
        //좌
        i==2 ->{
            for(r in 0 until n){
                for(c in 0 until n-1){
                    //현재 칸에 블럭이 있는 경우 합치기
                    if(temp[r][c]!=0){
                        var idx=c+1
                        //우측의 최초 블럭
                        while(idx<n && temp[r][idx]==0){
                            idx++
                        }
                        //우측에 블럭이 없는 경우
                        if(idx==n) break
                        //숫자가 같은 경우
                        if(temp[r][c]==temp[r][idx]){
                            temp[r][c]*=2.also{temp[r][idx]=0}
                        }
                        //숫자가 다른 경우
                        else{
                            temp[r][c+1]=temp[r][idx].also{temp[r][idx]=0}
                        }
                    }
                }
                for(c in 0 until n){
                    //이동한 그래프의 최댓값 찾기
                    maxVal=maxVal.coerceAtLeast(temp[r][c])
                    //현재 칸에 블럭이 없는 경우 swap
                    if(temp[r][c]==0){
                        var idx=c+1
                        //우측의 최초 블럭
                        while(idx<n && temp[r][idx]==0){
                            idx++
                        }
                        //우측에 블럭이 없는 경우
                        if(idx==n) break
                        //우측에 블럭이 있는 경우 swap
                        temp[r][c]=temp[r][idx].also{temp[r][idx]=0}
                    }
                }
            }
        }
        //우
        i==3 ->{
            for(r in 0 until n){
                for(c in n-1 downTo 1){
                    //현재 칸에 블럭이 있는 경우 합치기
                    if(temp[r][c]!=0){
                        var idx=c-1
                        //좌측의 최초 블럭
                        while(idx>=0 && temp[r][idx]==0){
                            idx--
                        }
                        //좌측에 블럭이 없는 경우
                        if(idx<0) break
                        //숫자가 같은 경우
                        if(temp[r][c]==temp[r][idx]){
                            temp[r][c]*=2.also{temp[r][idx]=0}
                        }
                        //숫자가 다른 경우
                        else{
                            temp[r][c-1]=temp[r][idx].also{temp[r][idx]=0}
                        }
                    }
                }
                for(c in n-1 downTo 0){
                    //이동한 그래프의 최댓값 찾기
                    maxVal=maxVal.coerceAtLeast(temp[r][c])
                    //현재 칸에 블럭이 없는 경우 swap
                    if(temp[r][c]==0){
                        var idx=c-1
                        //좌측의 최초 블럭
                        while(idx>=0 && temp[r][idx]==0){
                            idx--
                        }
                        //좌측에 블럭이 없는 경우
                        if(idx<0) break
                        //좌측에 블럭이 있는 경우 swap
                        temp[r][c]=temp[r][idx].also{temp[r][idx]=0}
                    }
                }
            }
        }
    }

}

fun dfs(cnt : Int, n : Int, graph : Array<IntArray>){

    if(cnt==10){
        return
    }

    for(i in 0 until 4){
        //copy
        val temp =  Array(n) { IntArray(n) }
        for(r in 0 until n){
            for(c in 0 until n){
                temp[r][c]=graph[r][c]
            }
        }
        maxVal=0
        //move
        move(i,n,temp)
        //check 함수에서 maxVal, 이전 그래프와 같은지 여부를 추출
        val isSame = check(n,graph,temp)
        //정답 갱신
        answer=answer.coerceAtLeast(maxVal)

        //이동했을 때 차이가 없다면 스킵
        if(isSame) continue

        //다음 그래프의 최댓값에서 남은 이동 횟수를 계산한 최댓값이 절대 최댓값이 나올 수 없으면 스킵
        if(maxVal shl (9-cnt) <=answer) continue
        dfs(cnt + 1, n, temp)
    }
}

fun main() =with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()

    val graph= Array(n){br.readLine().split(' ').map{it.toInt()}.toIntArray()}

    dfs(0,n,graph)
    write("$answer")
    close()
}
