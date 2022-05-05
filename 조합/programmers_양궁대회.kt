//https://programmers.co.kr/learn/courses/30/lessons/92342
class Solution {
    //10점부터 0점
    var answerArr = IntArray(11)
    var answerScore = 0

    fun cal(info: IntArray, comb: IntArray){
        var appeach = 0
        var lion = 0
        for(i in comb.indices){
            //어피치 win
            if(info[i]==0 && comb[i]==0 )continue
            if(info[i]>=comb[i]){
                appeach+=10-i
            }
            //라이언 win
            else{
                lion+=10-i
            }
        }

        //라이언 우승
        if(appeach<lion){
            if(answerScore<lion-appeach){
                answerScore=lion-appeach
                for(i in comb.indices){
                    answerArr[i] = comb[i]
                }
            }
            else if(answerScore==lion-appeach){
                for(i in comb.size-1 downTo  0){
                    if(answerArr[i]==comb[i]) continue
                    if(answerArr[i]>comb[i]) return
                    else break
                }
                for(i in comb.indices){
                    answerArr[i] = comb[i]
                }
            }
        }

    }


    fun findScoreSet(info: IntArray,comb: BooleanArray, n: Int, idx: Int, scoreSet: IntArray, cnt: Int){

        //정한 과녁 모두 쏘면 검사


        if(cnt==0){
            //n은 남아있을 수 있고 남은 n은 젤 낮은 대로 몰빵
            if(n>0) {
                for (i in scoreSet.size-1 downTo 0){
                    if(comb[i]){
                        scoreSet[i]+=n
                        break
                    }
                }
            }
            cal(info,scoreSet)

            return
        }

        for(i in idx until 11){

            if(!comb[i]) continue
            if(cnt!=1 && n<=info[i]) continue

            if(cnt==1){
                scoreSet[i] = n
                findScoreSet(info,comb,0,i+1, scoreSet,cnt-1)
            }
            else {
                scoreSet[i] = info[i] + 1
                findScoreSet(info,comb,n-(info[i]+1),i+1, scoreSet,cnt-1)
            }

            scoreSet[i] = 0
        }

    }



    fun combination(info: IntArray, comb: BooleanArray, n: Int, idx: Int){

        var cnt=0
        for(i in comb){
            if(i) cnt++
        }

            findScoreSet(info, comb, n, 0, IntArray(11),cnt)

        for(i in idx until 11){
            comb[i]=true
            combination(info,comb,n,i+1)
            comb[i]=false
        }
    }

    fun solution(n: Int, info: IntArray): IntArray {

        combination(info,BooleanArray(11),n, 0)

        //이길 수 없는 경우
        if(answerArr.maxOrNull()==0) return intArrayOf(-1)
        return answerArr
    }
}
