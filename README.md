## 🟣Kotlin/C++를 이용한 알고리즘 문제 풀이
####   👇c++을 이용한 풀이는 아래의 블로그에 게시했습니다.
 <a href="http://ongveloper.tistory.com">
    <img 
        src="https://img.shields.io/badge/-Tech%20Blog-655ced?style=flat&link=https://ongveloper.tistory.com"
         style="height : auto; margin-left : 10px; margin-right : 10px;"/>
</a>

---

### 알고리즘 문제 풀이를 위한 팁 [Kotlin/c++]
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
✅이분 탐색의 start는 배열 내에 인덱스, end는 배열 끝(바깥) 인덱스 (초기에는 start=0 end =arr.end())<br>
✅최소 스패닝 트리를 만드는 크루스칼,프림 알고리즘은 둘 다 시간 복잡도가 O(ElogV)고, 간선이 많은 경우는 프림, 간선이 적은 경우는 크루스칼이 유리하다 <br>
✅조합 n 16까지, 순열 n 13정도까지 <br>
✅c++/ 조합 결과 출력 속도 순서 1.문자열 2. 배열 3.벡터 <br>
✅c++/ 배열 전역변수 선언 int arr[백만] 가능, 지역변수 선언 int arr[백만]터짐 int arr[십만] <br>

✅set에 무언가를 저장하여 중복을 없애는 것보다 배열로 중복 없애는 게 빠름. ex(boj_21922_학부 연구생 민상)<br>

✅크루스칼로는 안 되고 프림으로만 풀 수 있는 문제가 있다. 반대로 크루스칼은 프림으로 모두 풀 수 있다.<br>
✅N>12이면 조합 안 쓰는게 좋음<br>

<details markdown="1">
<summary>✅it.first기준 내림차순, 같으면 it.seconde기준 오름차순<br> </summary>
<br>
<pre>
<code>
 score.sortWith(compareByDescending<Pair<Int, String>> { it.first }.thenBy { it.second })
 </code>
</pre>
</details>
 
 
<details markdown="1">
<summary>✅특정 문자열을 포함한 문자열들을 변형<br> </summary>
<br>
<pre>
<code>
val arr = Array<String>(10){""}
 arr.filter{it.contains("abc")}.forEach{it.replace("abc","ddd")}
</code>
</pre>
</details>

<details markdown="1">
<summary>✅ArrayList<String> to Array<String><br></summary>
<br>
<pre>
<code>
  val strList = ArrayList<String>()<br>
  val arr : Array<String> = strList.toTypedArray() <br>
</code>
</pre>
</details>


<details markdown="1">
<summary>✅깊은 복사와 얕은 복사<br> </summary>
<br>
<pre>
Kotlin에선 배열의 원본 아이템을 새로 만들어 새로 만드는 객체에 추가할 경우는 깊은 복사, 나머지는 얕은 복사이다.
얕은 복사 : 원본의 값이 바뀜
깊은 복사 : 원본의 값이 바뀌지 않음
<code>
val arr = intArrayOf(1,2,3)

//얕은 복사
val arrCopy = arr 
arrCopy[0]=5 // arr[0] ==5로 바뀜

//얕은 복사
val arrCopy = arr.copyOf()
arrCopy[0]=5 //arr[0] ==5로 바뀜

//깊은 복사
val arrCopy = IntArray(3)
for(i in arr.indices){
 arrCopy[i] = arr[i]
}
arrCopy[0]=5 // arr[0]==1 안 바뀜


 //얕은 복사
 val src1 = arrayListOf(arrayOf("ICN", "A"), arrayOf("ICN", "B"), arrayOf("B", "ICN"))
 val copiedForEachAdd = ArrayList<Array<String>>()
 src1.forEach { copiedForEachAdd.add(it) } // for each add
 copiedForEachAdd[0][0]="changed" //src1[0][0] == "ICN" 안 바뀜
 src1.forEach{print(it.contentToString())}
 println()
 
 //깊은 복사
 val src2 = arrayListOf(arrayOf("ICN", "A"), arrayOf("ICN", "B"), arrayOf("B", "ICN"))
 val copiedForEachAddCopyOf = ArrayList<Array<String>>()
 copiedForEachAddCopyOf[0][0]="changed" //src2[0][0] == "ICN" 안 바뀜
 src2.forEach { copiedForEachAddCopyOf.add(it.copyOf()) }// for each add copy of
 src2.forEach{print(it.contentToString())}
</code>
</pre>

</details>

✅val (from,to) = List(2){Integer.parseInt(tk.nextToken())}<br>
//nextToken 없을 때까지 계속 <br>


<details markdown="1">
<summary>✅PriorityQueue 정렬 커스텀<br> </summary>
<br>
<pre>
<code>
//다익스트라 사용 pq
data class Node(val dis: Int, val r: Int, val c: Int)
   val pq = PriorityQueue(Comparator<Node> { a, b ->
        when {
            a.dis < b.dis -> -1 
            a.dis == b.dis -> 0
            else -> 1
        }

    })
</code>
</pre>
</details>


<details markdown="1">
<summary>✅Collection 정렬 커스텀<br> </summary>
<br>
<pre>
<code>
//문자열의 길이 기준 오름차순, 길이가 같다면 사전순 오름차순
    val set = mutableSetOf<String>()
    val resultSet = set.sortedWith(Comparator { a, b ->
        when {
            a.length < b.length -> -1
            a.length == b.length -> when {
                a < b -> -1
                else -> 1
            }
            else -> 1
        }
    })
</code>
</pre>

</details>

<details markdown="1">
<summary>✅PriorityQueue 내림차순 선언 두 가지 방식<br> </summary>
<br>
<pre>
<code>
 val pq1= PriorityQueue<Int>({a,b -> b-a})
 val pq2 = PriorityQueue<Int>(Collections.reverseOrder())
 
</code>
</pre>

</details>

✅ 55.coreceAtMost(60) //return 55<br>

<details markdown="1">
<summary>✅?.(세이프콜), !!(non-null 단정 기호) </summary>
<br>
<pre>
<code>
fun main(){
 var str1 : String? = null
 println("str1.length = ${str1?.length}") //result : null
 //?.(세이프콜) : 앞의 변수가 null일 시 뒤의 length를 실행하지 않고 null을 반환
 //세이프콜을 사용하지 않으면 컴파일에러 발생
 
 println("str1.length =${str1!!.length}") //npe발생
 // !!(non-null 단정 기호) : 앞의 변수가 널이 아닐꺼라고 단정한다.
 // !!사용시 컴파일 에러는 발생하지 않으나 npe 런타임에러 발생
 
 val len = if(str1 !=null) str1.length else -1 //자동 형 변환을 통해 str1이 null이 아님이 확인되면 str은 non-null상태가 되며, str1.length를 사용할 수 있다.
 val len = str1?.length ?: -1 //위의 식을 세이프콜과 엘비스 표현식으로 간결하게 변환
 //str1?.length가 null이면 -1을 반환 null이 아니면 str1.length를 반환  
 
}

</code>
</pre>

</details>

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


