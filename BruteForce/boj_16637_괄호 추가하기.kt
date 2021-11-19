//https://www.acmicpc.net/problem/16637
import kotlin.math.*

val visited = BooleanArray(10)
val chArr = ArrayList<Char>()
var answer : Long =-99999999999999
fun cal(ch : Char, a : Long, b: Long):Long{
    if(ch=='+'){
        return a+b
    }
    else if(ch=='-'){
        return a-b
    }
    else{
        return a*b
    }
}

fun dfs(intArr : ArrayList<Long>, idx : Int){
    var result=0
    val intArrCopy= LongArray(intArr.size)
    for(i in intArr.indices){
        intArrCopy[i] =intArr[i]
    }

    for(i in chArr.indices){
        if(visited[i])continue
        if(i+1 in chArr.indices &&visited[i+1]){
            intArrCopy[i+2] = cal(chArr[i],intArrCopy[i],intArrCopy[i+2])
            continue
        }
        intArrCopy[i+1]= cal(chArr[i], intArrCopy[i], intArrCopy[i + 1])
    }

    answer = max(intArrCopy[intArrCopy.size-1],answer)
    var i = idx
    while(i in chArr.indices){
        if(i-1>=0 && visited[i-1]) {
            i++
            continue
        }
        val temp = intArr[i+1]
        intArr[i+1]=cal(chArr[i],intArr[i],intArr[i+1])
        visited[i]=true
        dfs(intArr,i+1)
        intArr[i+1] = temp
        visited[i]=false
        i++
    }
}

fun main() = with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val input = br.readLine()
    val intArr = ArrayList<Long>()

    for(i in input.indices){
        if(input[i].isDigit()){
            intArr.add(Character.getNumericValue(input[i]).toLong())
        }
        else{
            chArr.add(input[i])
        }
    }
    dfs(intArr, 0)
    write("$answer")
    close()
}
