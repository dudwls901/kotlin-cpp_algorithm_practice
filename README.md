## 🟣Kotlin/Java를 이용한 알고리즘 문제 풀이
####   c++을 이용한 풀이는 아래의 블로그에 게시했습니다.
  <a href="http://ongveloper.tistory.com">
    <img 
        src="https://img.shields.io/badge/-Tech%20Blog-655ced?style=flat&link=https://ongveloper.tistory.com"
         style="height : auto; margin-left : 10px; margin-right : 10px;"/>
</a>

### 알고리즘 문제 풀이를 위한 팁 [Kotlin/Java]
---
#### 🟥자주 사용하는 라이브러리, 함수, 프로퍼티
<details markdown="1">
<summary>import kotlin.math.*</summary>

``` kotlin

max(a,b)
min(a,b)
abs(a)
sqrt(a)

```

</details>

```

arr.max()
arr.min()
arr.average()
arr.maxOrNull()
arr.minOrNull()
arr.indexOf()
arr.lastIndexOf()

```

---

✅for문의 index (자바와의 차이점)<br>
<pre>
<code>
    //java code
    int i;
    for(i=0; i<5;i++){
        
    }
    System.out.println(i);
</code>
</pre>
<br>
코틀린의 i는 for문 내부에서 관리하기 때문에<br>
for문 바깥에서 사용할 수 없음<br>
<pre>
<code>
    //kotlin
    var i :Int
    for(i in 0 until 5){

    }
    println(i)//error : i를 초기화할 것
</code>
</pre>

✅다양한 모습의 버퍼<br>
<details markdown="1">
<summary>1.접기/펼치기(❤import도 필요 없으며 가장 간결하다 )</summary>
<pre>
<code>
fun main() = with(System.`in`.bufferedReader()){
    with(System.out.bufferedWriter()){
        var t = Integer.parseInt(readLine())
        for(i in 1..t){
            var token = StringTokenizer(readLine())
            write("Case #$i: ${Integer.parseInt(token.nextToken())+Integer.parseInt(token.nextToken())}\n")
        }
        flush()
        close()
    }
    close()
}
</code>
</pre>
</details>

<details markdown="1">
<summary>2.접기/펼치기</summary>
<pre>
<code>
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    with(BufferedWriter(OutputStreamWriter(System.out))){
        var t = Integer.parseInt(readLine())
        for(i in 1..t){
            var token = StringTokenizer(readLine())
            write("Case #$i: ${Integer.parseInt(token.nextToken())+Integer.parseInt(token.nextToken())}\n")
        }
        flush()
        close()
    }
    close()
}
</code>
</pre>
</details>

<details markdown="1">
<summary>3.접기/펼치기</summary>
<pre>
<code>
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = Integer.parseInt(br.readLine())
    for(i in 1 .. t){
        val token = StringTokenizer(br.readLine())
        bw.write("Case #$i: ${Integer.parseInt(token.nextToken())+Integer.parseInt(token.nextToken())}\n")
    }
    bw.flush()
    bw.close()
    br.close()
}

</code>
</pre>
</details>
  
✅입출력 속도<br>
BufferedReader/Writer faster than Scanner faster than readLine(),print()<br>

✅버퍼 사용법<br>
import java.io.BufferedReader<br>
import java.io.BufferedWriter<br>
import java.io.InputStreamReader<br?
import java.io.OutputStreamWriter<br>


val br = BufferedReader(InputStreamReader(System.`in`)<br>
val bw = BufferedWriter(OutputStreamReader(System.out)<br>

BufferedReader, BufferedWriter 사용 후 항상 닫아주기<br>
안 닫으면 버퍼에 남아 있음<br>
br.close()<br>
bw.close()<br>

✅int형변환 속도<br>
Integer.parseInt() faster than .toInt()<br>

✅입력 분리 저장 <br>
StringTokenizer faster than split<br>

✅입력 분리 저장<br>
val (a,b) = br.readLine().split(' ').map{Integer.parseInt(it)}<br>
