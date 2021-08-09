//https://www.acmicpc.net/submit/1330

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

//StringTokenizer faster than split
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val token = StringTokenizer(br.readLine())
    val a = Integer.parseInt(token.nextToken())
    val b = Integer.parseInt(token.nextToken())    
  //val (a,b) = br.readLine().split(' ').map{Integer.parseInt(it)}
    if(a>b)
      println('>')
    else if(a<b)
      println('<')
    else if(a==b)
      println("==")
    
}
