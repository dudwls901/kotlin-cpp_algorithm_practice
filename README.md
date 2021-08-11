## 🟣Kotlin/Java를 이용한 알고리즘 문제 풀이
####   👇c++을 이용한 풀이는 아래의 블로그에 게시했습니다.
 <a href="http://ongveloper.tistory.com">
    <img 
        src="https://img.shields.io/badge/-Tech%20Blog-655ced?style=flat&link=https://ongveloper.tistory.com"
         style="height : auto; margin-left : 10px; margin-right : 10px;"/>
</a>

---

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

✅kotlin 함수에서 파라미터는 모두 값이 변하지 않는 Immutable이다. (val이 생략된 형태)<br>

<details markdown="1">
<summary>✅kotlin 함수에서 배열을 매개 변수로 받았을 때</summary>
<pre>
<code>
fun change(arr : MutableList<Int>){
    arr[2]=30
}

fun main(){
    val arr = MutableList<Int>(5,{0})
    println(arr[2])
    change(arr)
    println(arr[2])

}
</pre>
</code>
result 
0
30
</details>

<details markdown="1">
<summary>✅ArrayList는 c++의 vector를 대체할 수 없다ㅜ</summary>

kotlin/java의 ArrayList는 동적 크기라는 점에서 일반 배열과 차이가 있다.<br>
.add()등의 함수로 원소를 추가할 수 있는데<br>
c++의 vector와 다르게 ArrayList는 크기를 초기화할 수 없다.<br>
c++의 vector와 원소를 추가하는 방식은 같다.<br>
.add()함수로 현재 ArrayList의 크기가 3이라고 할 때,<br>
원소를 추가하게 되면 ArrayList의 크기를 키운 후 새로운 공간에 더 큰 메모리를 잡은 후<br>
기존의 ArrayList의 요소를 복사하고 원소를 추가한다.<br>
다만, c++에선 체감하지 못 했지만, 코틀린은 속도가 느려서 알고리즘 문제 풀이를 할 때,<br>
ArrayList 자료구조로 .add() 혹은 .removeLast()를 많이 사용하면 시간이 오래 걸리기 때문에 <br>
웬만하면 리스트의 크기를 미리 지정하고 일반 배열로 처리하자.<br>
ex) 조합 알고리즘<br>

ArrayList 원소 추가 방식
더 큰 메모리를 잡은 후 기존 메모리의 복사를 통해 크기를 늘린다.
이 때 항상 여유 메모리를 두고 메모리를 추가한다.
이러한 ArrayList의 특성 때문에 값이 자주 변경되어야 할 때는 ArrayList를 사용하는 것이 좋지 않다.


</details>


<details markdown="1">
<summary>✅토큰의 끝까지 입력받기</summary>
val tk = StringTokenizer(readLIne())<br>
while(tk.hasMoreTokens()){<br>
arr[i] = Integer.parseInt(tk.nextToken())<br>
}<br>
</details>

<details markdown="1">
<summary>✅소수점 자르기</summary>
String.format("%.3f", cnt / n*100)
</details>

<details markdown="1">
<summary>✅for문의 index (자바와의 차이점)</summary>
<br>
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
</details>

<details markdown="1">
<summary>✅다양한 모습의 버퍼</summary>
<br>
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
</details>



<details markdown="1">
<summary>✅입출력 속도</summary>
<br>
BufferedReader/Writer faster than Scanner faster than readLine(),print()
</details>

<details markdown="1">
<summary>✅버퍼 사용법</summary>
<br>
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
</details>

<details markdown="1">
<summary>✅int형변환 속도</summary>
<br>
Integer.parseInt() faster than .toInt()
</details>



<details markdown="1">
<summary>✅입력 분리 </summary>
<br>
StringTokenizer faster than split
</details>

<details markdown="1">
<summary>✅입력 분리 저장</summary>
<br>
val (a,b) = br.readLine().split(' ').map{Integer.parseInt(it)}
</details>


