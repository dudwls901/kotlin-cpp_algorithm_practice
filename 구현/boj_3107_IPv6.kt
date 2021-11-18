//https://www.acmicpc.net/problem/3107
import java.io.InputStreamReader
import java.io.BufferedReader

fun main() = with(System.out.bufferedWriter()){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    var answer=""
    var partCnt=0
     for(i in input.indices){
        if(input[i]==':'){
            partCnt++;
        }
    }
    var len=0
    var skip=false
    for(i in input.length-1 downTo 0){
        if(skip==true){
            skip=false
            continue
        }
        if(input[i]==':'){
            while(len++<4){
                answer = '0'+answer
            }
            if(i-1>=0 && input[i-1]==':'){
                var cnt = 8-partCnt
                if( i-1==0){
                    cnt++
                }
                while(cnt--!=0){
                    answer = "0000" +answer
                }
                skip=true
                len=0
                continue
            }
            len=0
        }
        else{
            answer=input[i] +answer
            len++
        }
    }
    if(len!=0){
        while(len++<4){
            answer = '0'+answer
        }
    }
    var idx=3
    for(i in answer.indices){
        write("${answer[i]}")
        if(i==idx && i!=answer.length-1){
            write(":")
            idx+=4
        }
    }
    close()
}
