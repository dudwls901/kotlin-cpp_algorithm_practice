//https://www.acmicpc.net/problem/20546
val br = System.`in`.bufferedReader()

fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

lateinit var costs: List<Int>
var junM = 0
var junS = 0
var sungM = 0
var sungS = 0
fun main() = with(System.out.bufferedWriter()){

    //input
    val n = getInt()
    junM = n
    sungM = n
    costs = getIntList()

    //solve
    var seq=1
    for(i in 0 until costs.size -1){
        val cost = costs[i]
        //준현
        var junCnt = junM/cost
        if(junCnt > 0){
            junS += junCnt
            junM -=  cost*junCnt
        }
        //성민
        if(i>0){
            //상승
            if(cost > costs[i-1]){
                if(seq>0) seq++ else seq = 1
                if(seq>=3){
                    //매도
                    sungM += cost* sungS
                    sungS = 0
                }
            }
            else{
                if(seq<0) seq-- else seq = -1
                if(seq<=-3){
                    val sungCnt = sungM/cost
                    //매수
                    if(sungCnt > 0){
                        sungS += sungCnt
                        sungM -= cost*sungCnt
                    }
                }
            }
        }
    }
    val jun = junM + junS*costs[13]
    val sung = sungM + sungS*costs[13]
    if(jun>sung){
        write("BNP")
    }
    else if( sung > jun){
        write("TIMING")
    }
    else write("SAMESAME")

    close()
}
