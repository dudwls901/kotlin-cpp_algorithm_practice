//https://www.acmicpc.net/problem/1411
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val input = Array<String>(n){""}
    for(i in 0 until n){
        input[i] =br.readLine()
    }

    var answer=0
    for(i in 0 until n){
        for(j in i+1 until n){
            answer+=canPair(input[i],input[j],IntArray(26){-1}, IntArray(26){-1})
        }
    }
    write("$answer")

    close()
}

fun canPair(a : String, b : String,visited1 : IntArray ,visited2 : IntArray) : Int {
    val left = a.toCharArray()
    val right = b.toCharArray()

    for(i in left.indices){
        if(visited1[left[i]-'a']==-1){
            if(visited2[right[i]-'a']!=-1)
                return 0
            visited1[left[i]-'a'] = right[i]-'a'
            visited2[right[i]-'a'] = left[i]-'a'

        }else{
            if(visited1[left[i]-'a']!=right[i]-'a'){
                return 0
            }
        }
    }
    return 1

}
