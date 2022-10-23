//https://www.acmicpc.net/problem/1718
val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()){
    val line = StringBuilder(br.readLine())
    val password = br.readLine()
    for(i in line.indices){
        if(line[i]==' ')continue
        line[i] = Char(((26+(line[i]-'a')-(password[i%password.length]-'a'+1))%26)+'a'.code)
    }
    write(line.toString())
    close()
}
