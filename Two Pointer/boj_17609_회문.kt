//https://www.acmicpc.net/problem/17609
val br = System.`in`.bufferedReader()

var answer=-1
fun solve(s: String, left: Int, right: Int, isDeleted: Boolean, state: Int){
    if(left>=right){
        //이미 회문의 값이 0이나 1인 경우 2를 넣지 않는다
        if(state==2){
            if(answer==-1)
            answer=state
        }
        else{
            answer=state
        }
        return
    }
    //같지 않으면
    if(s[left]!=s[right]){
        //이미 삭제한 경우 회문 x
        if(isDeleted){
            if(answer==-1) {
                answer = 2
            }
            return
        }
        //왼쪽 삭제, 오른쪽 삭제 둘 다 안 되는 경우 회문x
        var next =0
        if(s[left+1]==s[right]){
            solve(s,left+1,right, true, 1)
            next++
        }
        if(s[left]==s[right-1]){
            solve(s,left,right-1, true, 1)
            next++
        }
        if(next==0){
            if(answer==-1) {
                answer = 2
            }
            return
        }
    }
    //같으면
    else {
        solve(s, left + 1, right - 1, isDeleted, state)
    }
}

fun main() = with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()

    for(i in 0 until n){
        val input = br.readLine()
        solve(input,0,input.length-1,false,0)
        write("$answer\n")
        answer=-1
    }

    close()
}
