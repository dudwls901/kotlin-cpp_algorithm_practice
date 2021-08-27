//https://www.acmicpc.net/problem/7453
import java.util.StringTokenizer
fun main()= with(System.out.bufferedWriter()){
    val br = System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    val arr = Array<LongArray>(4){LongArray(n)}
    val arr1 = LongArray(n*n)
    val arr2 = LongArray(n*n)
    var ans = 0L
    for(i in 0 until n){
        val tk = StringTokenizer(br.readLine())
        for(j in 0 until 4){
            arr[j][i] = tk.nextToken().toLong()
        }
    }
    for(i in 0 until n){
        for(j in 0 until n){
            arr1[i*n+j] = arr[0][i] + arr[1][j]
            arr2[i*n+j] = arr[2][i] + arr[3][j]
        }
    }

    arr1.sort()
    arr2.sort()

    var p1 = 0
    var p2 = arr2.size-1

    while(p1<arr1.size && p2>=0){
        if(arr1[p1]+arr2[p2]==0L){
            var i = p1
            var cnt1=0L
            while(i <arr1.size && arr1[i]==arr1[p1]){
                cnt1++
                i++
            }
            p1=i
            i =p2
            var cnt2 =0L
            while(i>=0&&arr2[i]==arr2[p2]){
                cnt2++
                i--
            }
            ans+=cnt1*cnt2
            p2=i
        }
        else if(arr1[p1]+arr2[p2]<0){
            p1++
        }
        else{
            p2--
        }
    }
    write("$ans")
    close()
}
