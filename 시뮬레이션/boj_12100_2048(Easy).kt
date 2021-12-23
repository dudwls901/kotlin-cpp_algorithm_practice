//https://www.acmicpc.net/problem/12100
val br = System.`in`.bufferedReader()
var answer=0
fun dfs(cnt : Int, n : Int, graph : Array<IntArray>){
    if(cnt==5){
        for(i in 0 until n){
            answer = answer.coerceAtLeast(graph[i].maxOrNull()!!)
        }
        return
    }
    for(i in 0 until 4){
        //copy
        val temp = Array(n){IntArray(n)}
        for(r in 0 until n){
            for(c in 0 until n){
                temp[r][c]=graph[r][c]
            }
        }
        //move
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
                    for(r in 0 until n-1){
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
                    for(r in n-1 downTo 1){
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
                    for(c in 0 until n-1){
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
                    for(c in n-1 downTo 1){
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
        dfs(cnt+1,n,temp)
    }
}

fun main() =with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()

    val graph= Array(n){br.readLine().split(' ').map{it.toInt()}.toIntArray()}

    dfs(0,n,graph)
    write("$answer")
    close()
}
