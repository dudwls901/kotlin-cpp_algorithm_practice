//https://www.acmicpc.net/problem/18868
val br = System.`in`.bufferedReader()
//m 우주 개수 2<=m<=10
//n 행성 개수 3<=n<=100
//서로 조건만 같으면 됨

lateinit var universe: Array<IntArray>

fun check(uni1: IntArray, uni2: IntArray, size: Int):Int{
    for(i in 0 until size){
        for(j in i+1 until size){
            //세 조건 중 하나만 일치하면 패스
            var isSame=false
            if((uni1[i]<uni1[j]) && (uni2[i]<uni2[j])){
                isSame=true
            }
            else if((uni1[i]>uni1[j]) && (uni2[i]>uni2[j])){
                isSame = true
            }
            else if((uni1[i]==uni1[j]) && (uni2[i]==uni2[j]) ){
                isSame = true
            }
            //세 조건 중 하나라도 만족하지 못하면 false
            if(!isSame) return 0
        }
    }
    return 1
}


fun main() = with(System.out.bufferedWriter()){

    val(n,m) = br.readLine().split(' ').map{it.toInt()}
    universe = Array(n){br.readLine().split(' ').map{it.toInt()}.toIntArray()}
    var answer=0


    //두 쌍
    for(i in 0 until n){
        for(j in i+1 until n){
            //유효성 검사
            answer += check(universe[i],universe[j],m)
        }
    }

    write("$answer")
    close()
}
