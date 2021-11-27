//https://www.acmicpc.net/problem/1283
import java.util.*
//1<=n<=30
//한 줄당 5개 단어 이하
//한 단어당 10개 글자 이하
fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val alphaSet = mutableSetOf<Char>()

    for(i in 0 until n){
        val sen = br.readLine().split(' ')
        var idx=0
        var wordPass=true
        while(idx<sen.size){
            //해당 단어가 단축키 지정이 되지 않았다면
            if(alphaSet.indexOf(sen[idx][0])==-1){
                //단어의 첫 글자의 대소문자를 알파셋에 넣기
                alphaSet.add(sen[idx][0].toLowerCase()).also{ alphaSet.add(sen[idx][0].toUpperCase())}
                wordPass=false
                break
            }
            idx++
        }
        //모든 단어가 단축키 지정이 된 경우
        if(wordPass){
            var senPass = false
            for(i in 0 until sen.size){
                for(j in 0 until sen[i].length){
                    if (alphaSet.indexOf(sen[i][j]) == -1 && !senPass) {
                        //알파벳 감싸서 출력
                        write("[${sen[i][j]}]")
                        alphaSet.add(sen[i][j].toLowerCase()).also { alphaSet.add(sen[i][j].toUpperCase()) }
                        senPass = true
                    }else{
                        //해당 단어의 대소문자를 알파벳에 넣기, 알파벳 그대로 출력
                        write("${sen[i][j]}")
                    }
                }
                write(" ")
            }
        }
        //단축키 지정이 되지 않은 단어가 있는 경우
        else{
            for(i in 0 until sen.size){
                if(i==idx){
                    write("[${sen[i][0]}]${sen[i].substring(1)} ")
                }
                else{
                    write("${sen[i]} ")
                }
            }
        }
        write("\n")
    }

    close()
}
