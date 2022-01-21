//https://www.acmicpc.net/problem/1629
val br = System.`in`.bufferedReader()

fun pow(a : Long, b : Long, c : Long) : Long{
    if(b==1L){
        return a
    }
    else{
        val temp = pow(a,b/2,c)
        if(b%2==0L){
            return (temp * temp) % c
        }
        else{
            return ((temp * temp) % c * a) % c
        }
    }
}

fun main() = with(System.out.bufferedWriter()){

    val (a, b, c) = br.readLine().split(' ').map{it.toLong()}

    write("${pow(a%c,b,c)}")

    close()
}
