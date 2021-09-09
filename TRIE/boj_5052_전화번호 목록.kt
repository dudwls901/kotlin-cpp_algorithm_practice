//https://www.acmicpc.net/problem/5052
import java.util.*
class Trie(var finish : Boolean, var node : MutableMap<Char,Trie>){

    fun insert(word : String){
        var children : Trie = this
        for(ch in word){
            //노드에 ch엣지가 연결되어 있으면 이동
            if(children.node.containsKey(ch)){
                children = children.node[ch]!!
            }
            else{ //엣지가 연결되어 있지 않으면 새로 생성 후 연결
                children.node[ch] = Trie(false, mutableMapOf<Char,Trie>())
                children = children.node[ch]!!
            }
        }
        //단어의 끝에 finish
        children.finish=true
    }
    fun check(word :String):Boolean{
        var children =this
        for(ch in word){
            //엣지를 따라서 이동 중간에 finish가 있으면 일관성 x(어느 번호가 word의 접두어가 되는 경우)
            if(children.node.containsKey(ch)){

                if(children.finish){//중간에 끝난 문자가 있으면 no
                    return false
                }
                children = children.node[ch]!!
            }
        }
        //word 검사 시 문제가 없으면 yes
        return true
    }
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    var t = Integer.parseInt(br.readLine())
    while(t--!=0) {
        val n = Integer.parseInt(br.readLine())
        var answer = "YES"
        val root = Trie(false, mutableMapOf())
        val input = Array<String>(n){""}
        for(i in 0 until n){
            input[i] = br.readLine()
            root.insert(input[i])
        }
        for(i in 0 until n){
            if(!root.check(input[i])){
                answer="NO"
                break
            }
        }
        write("${answer}\n")
    }


    close()
}
