## ๐ฃKotlin/C++/Java๋ฅผ ์ด์ฉํ ์๊ณ ๋ฆฌ์ฆ ๋ฌธ์  ํ์ด
####   ๐ํ์ด๋ ์๋์ ๋ธ๋ก๊ทธ์ ๊ฒ์ํ์ต๋๋ค.
 <a href="http://ongveloper.tistory.com">
    <img 
        src="https://img.shields.io/badge/-Tech%20Blog-655ced?style=flat&link=https://ongveloper.tistory.com"
         style="height : auto; margin-left : 10px; margin-right : 10px;"/>
</a>

---

### ์๊ณ ๋ฆฌ์ฆ ๋ฌธ์  ํ์ด๋ฅผ ์ํ ํ [Kotlin/c++/Java]
---
#### ๐ฅ[Kotlin]์์ฃผ ์ฌ์ฉํ๋ ๋ผ์ด๋ธ๋ฌ๋ฆฌ, ํจ์, ํ๋กํผํฐ
<details markdown="1">
<summary>import kotlin.math.*</summary>

``` kotlin

max(a,b)
min(a,b)
abs(a)
sqrt(a)

```

</details>

```Kotlin

arr.max()
arr.min()
arr.average()
arr.maxOrNull()
arr.minOrNull()
arr.indexOf()
arr.lastIndexOf()
arr.sortWith(compareBy({it.name}, {it.price}))
arr.minBy { it.price }
arr.filter { it -> it > 0}.forEach{ e -> print("$it ") }
onEach : ๊ฐ ์์๋ฅผ ๋๋ค์์ผ๋ก ์ฒ๋ฆฌํ ํ ์ปฌ๋ ์์ ๋ฐํ! ์์ ์์  ๋ถ๊ฐ (print๋ฑ์ ์ฒ๋ฆฌ์ ์ฌ์ฉ)
forEach,forEachIndexed : ๊ฐ ์์๋ฅผ ๋๋ค์์ผ๋ก ์ฒ๋ฆฌ, ์์ ์์  ๊ฐ๋ฅ
map, mapIndexed : ๊ฐ ์์๋ฅผ ๋๋ค์์ผ๋ก ์ฒ๋ฆฌํ ํ ์ปฌ๋ ์์ ๋ฐํ! ์์๋ฅผ ๋ณต์ฌํ๊ณ  ํธ์งํจ(๊ธฐ์กด ๋ฆฌ์คํธ์ ์์ ์ํฅ x,๊ธฐ์กด ์ปฌ๋ ์์ ๋ฆฌ์คํธ๋ฅผ ์์ ํ ๋ฆฌ์คํธ๋ฅผ ์ป์ ๋ ์ฌ์ฉ)
mapNotNull : Null์ ์ ์ธํ๊ณ  ์์ ์ ์ฉํด ์๋ก์ด ์ปฌ๋ ์ ๋ฐํ
fold: ์ด๊ธฐ๊ฐ๊ณผ ์ ํด์ง ์์ ๋ฐ๋ผ ์ฒ์์์๋ถํฐ ๋ ์์์ ์ ์ฉํ๋ฉฐ ๊ฐ์ ์์ฑ
reduce: fold์ ๋์ผํ์ง๋ง ์ด๊ธฐ๊ฐ์ ์ฌ์ฉํ์ง ์์
foldRight, reduceRight: ์ค๋ฅธ์ชฝ๋ถํฐ ์์

```

---

<details markdown="1">
<summary>โ ์ฝํ ๋ฌธ์  ํต์ฌ ์ ํ</summary>
<br>
<pre>
1. bfs + ํ๋ผ๋ฉํธ๋ฆญ 
 - (๊ฐ์  ๊ฐ์, ๋ธ๋ ์, ๊ฐ์ค์น ๊ฐ) ๋ชจ๋ ํด ๋ ์์ฌ
 - ํฌ๋ฃจ์ค์นผ, ํ๋ฆผ, ๋ค์ต์ผ๋ก ํ๋ฆด ์๋ ์์
2. ํฌ ํฌ์ธํฐ or ๋์  ํฉ
 - ์ฐ์๋ ๊ฐ๋ค์ ํฉ์ ์๊ตฌํ  ๋
3. ์๊ฐ ๊ด๋ จ ๋ฌธ์  (์ต์ ๋จ์๋ก ํต์ผ)
4. ์๋ฎฌ๋ ์ด์
 - ๋ฐฐ์ด ๋ค์ง๊ธฐ or ๋๋ฆฌ๊ธฐ๋ ๋นก๊ตฌํ, ์ด๋์ ๋ ํํ๋ฆฟํ ํด๋์
 - bfs ํน์ dfs + ์ํ์ธ ๊ฒฝ์ฐ ๋ง์
5. ํธ๋ฆฌ
 - ๊ทธ๋ํ or ํธ๋ฆฌ ํ์
 - ๊ฐ์ ์ ๋ค์ง์ด ์ ๋ผ๊ฑฐ๋ ๋ญ ํ๋ฉด ๋ ์ด์ ์ด๋ํ  ์ ์๊ฒ ๊ฐ์ ์ด ๋ฐ๋๊ฑฐ๋...
6. ์กฐํฉ + ์์ด ํ๋ฌ์ค ์ํ ํน์ ์ค๋ณต ์กฐํฉ or ์ค๋ณต ์์ด 
 - ex ์นด๋ธ2022 ์๊ถ ๋ฌธ์ 
7. bfs ์์ฉ
 - ex ์๊ณผ ๋๋, ๋ฒฝ ๋ถ์๊ณ  ์ด๋ํ๊ธฐ ๋ฑ
 - ๋ญ ๋ฌ๊ณ  ๋ค๋
 - data class ๋ง๋ค์ด์ ์ํ๊ฐ ๋ค๊ณ  ๋๊ธฐ์
8. ํ์์์ n ์์ผ๋ฉด ๋นํธ๋ง์คํน ๊ณ ๋ ค

</pre>
</details>

<details markdown="1">
<summary>โ capitalize() deprecated in kotlin1.5</summary>
<br>
<pre>
capitalize๋ ์ฝํ๋ฆฐ 1.5๋ถํฐ deprecated๋์๋ค.
์ด๋ replaceFirstChar ๋ฑ ์ฌ๋ฌ ๋ฐฉ๋ฒ์ผ๋ก ๋์ฒดํ  ์ ์๋๋ฐ,
๊ธฐ์กด์ capitalize ๋์  ํ์ฅํจ์ ๋ฑ์ ์ด์ฉํ์ฌ ์ข ๋ ๋ชฉ์ ์ด ๋ถ๋ชํ๊ณ  ๋ชํํ ์ด๋ฆ์ ์ฌ์ฉํ๋ ๊ฒ์ ๊ถ์ฅํ๋ค.
s.split(' ').joinToString(" ") { it.lowercase().replaceFirstChar { it.uppercase() } }
</details>


<details markdown="1">
<summary>โ fold, reduce</summary>
<br>
<pre>
<code>
val list = listOf(1,2,3,4,5,6)
println(list.fold(4) { total, next -> total + next }) //4 + 1 + ... + 6 = 25
println(list.ford(1)) { total, next -> total * next}) // 1 * 1 * 2 * ... * 6 = 720
println(list.reduce { total, next -> total + next })


</code>
</details>

<details markdown="1">
<summary>โ ์ปฌ๋ ์ ๋ฐ๋ณต๋ฌธ ๋ ์ผ๋ฌด์ง๊ฒ ์ฐ๊ธฐ</summary>
<br>
<pre>
<code>
val arr = listOf(1,2,3)
val returnedList1 = list.onEach{ println(it) }// ์ฝ๋ ์์ ๋ฐํ, element๋ฅผ ๋ณ๊ฒฝํ  ์ ์๊ณ  ์ด๋ ํ ์ฒ๋ฆฌ๋ ๊ฐ๋ฅ
val returnedList2 = list.map{it*2} //์ฝ๋ ์์ ๋ฐํ, element ๋ณ๊ฒฝํ  ์ ์์
list.forEach { print("$it ")}
list.forEachIndexed {idx, value -> println("$idx $value")}

</code>
</details>


<details markdown="1">
<summary>โ ๋ฐฐ์ด ํํํ (๋ค์ฐจ์ -> ๋จ์ผ ๋ฐฐ์ด) </summary>
<br>
<pre>
flatten() : ๋ค์ฐจ์ ๋ฐฐ์ด์ ๋จ์ผ ๋ฐฐ์ด๋ก ์์ฑ
Array์๋ง ์ฌ์ฉ ๊ฐ๋ฅ (IntArray, Collection ์ฌ์ฉ ๋ถ๊ฐ)
<code>
    val arr1 = arrayOf(arrayOf(1,2,3), arrayOf(4,5,6))
    println(arr1.flatten())
// [1,2,3,4,5,6]
</code>
</details>


<details markdown="1">
<summary>โ ์ฒด์ด๋ ์์ (feat. ํํฐ๋ง) </summary>
<br>
<pre>
์ฒด์ด๋ : ๋ฉ์๋๋ค ์ฐ๊ฒฐ
<code>
val fruits = arrayOf("banana", "avocado", "apple", "kiwi")
fruits
.filter {it.startsWith("a")}
.sortedBy { it }
.map {it.toUpperCase() }
.forEach {println(it)}
</code>
</pre>
</details>


<details markdown="1">
<summary>โ dfs vs bfs (feat. String Result) </summary>
<br>
<pre>
dfs๋ผ๋ฉด
sb.append(next)
dfs()
sb.deleteCharAt(lastIdx)
๋ก, StringBuilder์ ์ด์ ์ ์ด๋ฆด ์ ์๋๋ฐ,

bfs ๊ฐ์ ๊ฒฝ์ฐ
sb.append(next)
q.add(sb)
sb.deleteCharAt(lastIdx)
์ด๋ฐ ์์ผ๋ก ํ๊ฒ ๋๋ฉด ๋ชจ๋ ๊ฐ์ sb๋ฅผ ์ฐธ์กฐํ๊ฒ ๋์ด string๊ฐ์ด ์ํ๋ ๋๋ก ๋์ค์ง ์๋๋ค.
๋ฐ๋ผ์ ํ์ ๋ฌธ์์ด์ ์ฝ์ํ  ๋๋ง๋ค ์ด์ฐจํผ DeepCopy๋ก ๋ฃ์ด์ฃผ์ด์ผ ํ๋ StringBuilder์ ์ด์ ์ ์ด๋ฆด ์ ์์ด ๊ทธ๋ฅ String์ผ๋ก ํ๋ค
// q.add(StringBuilder(sb))
</pre>
</details>


<details markdown="1">
<summary>โ String vs StringBuilder vs StringBuffer </summary>
<br>
<pre>
String : ๋ฐ์ดํฐ ์ ์ ๋ฐ๋ ๋
StringBuilder, StringBuffer : ๋ฐ์ดํฐ ์์ฃผ ๋ฐ๋ ๋
StringBuilder : ์ค๋ ๋์ธ์ดํ X
StringBuffer : ์ค๋ ๋ ์ธ์ดํ O
</pre>
</details>



<details markdown="1">
<summary>โ temp ์์ด swap -> xor swap</summary>
<br>
<pre>
X โ X XOR Y
Y โ X XOR Y
X โ X XOR Y
</pre>
</details>


<details markdown="1">
<summary>โ Kotlin String.capitalize() : ์ฒซ ๋ฒ์งธ ๋ฌธ์ ๋๋ฌธ์ํ!</summary>
<br>
<pre>
String.capitalize() returns a copy of this string having its first letter upper-cased.
<code>
class Solution {
     fun solution(s: String): String {
          return s.toLowerCase().split(" ").map {
                it.capitalize()
            }.joinToString(" ")
    }
}
</code>
</pre>
</details>

<details markdown="1">
<summary>โ ์ง์ ๋ณํ ์ถ๋ ฅ </summary>
<pre>
<code>
    println(Integer.toHexString(100))	// 10์ง์ 100 -> 16์ง์ 
    println(Integer.toOctalString(100))	// 10์ง์ 100 -> 8์ง์ 144
    println(Integer.toBinaryString(100))// 10์ง์ 100 -> 2์ง์ 01100100
</code>
</pre>
</details>

<details markdown="1">
<summary>โ 0์ผ๋ก ์ฑ์์ ์๋ฆฟ์ ๋ง์ถ๊ธฐ -> String.format("%04d",num)</summary>
<pre>
<code>
write("${String.format("%0${k+1}d", maxAns)}\n${String.format("%0${k+1}d", minAns)}")
</code>
</pre>
</details>


<details markdown="1">
<summary>โ ๋ ๊ฐ์ ๊ทธ๋ํ๋ฅผ ๋น๊ตํ๋ ์คํฌ </summary>
ํฐ ๊ทธ๋ํ๋ฅผ ํ๋ ๋๊ณ , ๊ฐ์ด๋ฐ ํ๋ ๊ทธ๋ํ ๊ณ ์ , ๋๋จธ์ง ๊ทธ๋ํ๋ฅผ ํ ์นธ์ฉ ์ด๋ํ๋ฉด์ ๋น๊ต
<br>
์ง ๋์ด ํธ์ : https://ongveloper.tistory.com/526
</details>

<details markdown="1">
<summary>โ ์๋ ฅ ํํ๋ฆฟ </summary>
<br>
<pre>
<code>
fun getIntGraph() = br.readLine().split(' ').map { it.toInt() }
</code>
</pre>
</details>

<details markdown="1">
<summary>โ sortBy faster than sortWith </summary>
<br>
<pre>
<code>
//sortWith
fun ArrayList<Tree>.customSort() {
    this.sortWith { a, b ->
        when {
            a.age < b.age -> -1
            a.age == b.age -> 0
            else -> 1
        }
    }
}
//sortBy
tree.sortedBy { it.age }
//thenBy
sortedNode.sortWith(compareByDescending<Node> { it.y }.thenBy { it.x })
 </code>
</pre>
</details>

<details markdown="1">
<summary>โ Deque๋ฅผ ์ด์ฉํ์ฌ ์ ๋ ฌ ์ค์ด๊ธฐ </summary>
<br>
<pre>
<code>
//์๋ก ๊ฐ์ด ์ถ๊ฐ๋  ๋ addFirst ํน์ addLast๋ก ์กฐ์  ๊ฐ๋ฅ
//๊ฐ์ ๋บ ๋๋ pollFirst ํน์ pollLast
//https://www.acmicpc.net/problem/16235
val tree= ArrayDeque<Tree>()
tree.sortBy{it.age} // ์ต์ด ํ ๋ฒ๋ง ์ ๋ ฌ ํ ๋๋จธ์ง๋ addFirst, addLast๋ฑ์ผ๋ก ์ ๋ ฌ ์ ์ง
 </code>
</pre>
</details>


โ double/float.NaN์ผ๋ก ์ค์ validation 

<details markdown="1">
<summary>โ trim()์ผ๋ก ๋น ๋ฌธ์์ด ์ฐพ๊ธฐ </summary>
<br>
<pre>
https://kkh0977.tistory.com/709
<code>
	var str_one = " he l lo"
	var str_two = " "

	println("str_one ๋ฌธ์์ด ๋น๊ฐ ํ์ธ : "+str_one.trim().isEmpty()) // false
	println("str_two ๋ฌธ์์ด ๋น๊ฐ ํ์ธ : "+str_two.trim().isEmpty()) // true

 </code>
</pre>
</details>


<details markdown="1">
<summary>โ Java ์ปค์คํ ์ ๋ ฌ </summary>
<br>
<pre>
<code>
class Edge implements Comparable<'Edge'>{
    public long dis;
    public int from;
    public int to;
    Edge(long dis, int from, int to){
        this.from = from;
        this.dis = dis;
        this.to = to;
    }
     
    @Override
    public int compareTo(Edge edge) {
        if(this.dis < edge.dis) {
            return -1;
        }
        else if(this.dis > edge.dis) {
            return 1;
        }
        return 0;
    }
}
//๊ฐ์  dis ๊ธฐ์ค ์ค๋ฆ์ฐจ์
Collections.sort(edge);

 </code>
</pre>
</details>



โ swap -> a = b.also{b = a}

โ ์๊ฐ ๊ด๋ จ ๋ฌธ์  dd:hh:mm:ss๋ ํญ์ ๋จ์ ํต์ผ


<details markdown="1">
<summary>โ๋นํธ๋ง์คํน<br> </summary>
<br>
<pre>
<code>
  val a = 0b00000011 
  val b = 0b00001100 
  Integer.bitCount(a xor b) // 4
  // a xor b == 15(0b00001111) 
 
 Integer.toBinaryString(num) //ex) 000111010
 str.toInt(2)

 </code>
</pre>
</details>

โforeach{}๋ Collection์ ์ ๋ฆฌ https://hwan-shell.tistory.com/245

โ๋ฐฐ์ด ์ค๋ณต ๊ฐ ์ ๊ฑฐ -> val newArr : List<Int> = arr.distinct()

โindexOf๋ O(N) -> set์์ ์์ ์ฐพ์ ๋ contains์ฌ์ฉ O(1)


โCharArray to String -> val str = String(chArr)

โLong.MAX_VALUE = 10^18~~~<br>

โ์์์  ์์งธ ์๋ฆฌ์์ ๋ฐ์ฌ๋ฆผ ํ ๋์งธ ์๋ฆฌ๊น์ง ์ถ๋ ฅ : write(String.format("%.2f", round(answer*100) /100))<br>

<details markdown="1">
<summary>โKotlin 2์ฐจ์ ๊ทธ๋ํ ์๋ ฅ <br> </summary>
<br>
<pre>
<code>
    val graph = Array(n){r->
        val st = StringTokenizer(br.readLine())
        IntArray(m){c->
            val node = st.nextToken().toInt()
            if(node ==2){
              sr = r
              sc = c
            }
            node
        }
    }

 </code>
</pre>
</details>
 


<details markdown="1">
<summary>โ๋ฐฑ์ค ๋ฉ๋ชจ๋ฆฌ ์ด๊ณผ ์ ํ๋ค<br> </summary>
<br>
<pre>
1.๊ฑฐ๋ํ๊ณ  sparse(๋๋ฌธ๋๋ฌธํ) ๋งคํธ๋ฆญ์ค ๋์ฌ ๋ 2์ฐจ์ ๋ฐฐ์ด๋ก ํ ๋นํ  ์
//์๋ณธ ๋ฐฐ์ด์ ํฐ๋ฐ ์ค์  ๋ค๋ฃจ๋ ๊ฐ์ด ๋๋ฌธ๋๋ฌธํ๊ฒ ์๋ ๊ฒฝ์ฐ
//์ฟ ํก์ด๋ ์๋ง์กด ๋ชจ๋  ์ ์  ์ฅ๋ฐ๊ตฌ๋์ ๋ด๊ธด ์ํ
//์นด๋ ๊ฒฐ์  ๋ด์ญ : ๋ชจ๋  ์์์  x ์ฌ๋๋ณ ์นด๋ ๊ฐ์
//๋ทํ๋ฆญ์ค ์ํ ๋ ์ดํ : ๋ฌด๋น์ ์ฒด x ์ ์  ์ ์ฒด
//๋ด๋ถ ๊ฐ์ ๋๋ฌธ๋๋ฌธํ์ง๋ง ์ด๋ฅผ ํ๋ ฌ๋ก ๊ด๋ฆฌํ๋ ค๋ฉด ์ ์ฒด ํฌ๊ธฐ๊ฐ ๊ฒ๋๊ฒ ์ปค์ผ ํ๋
//sparse ํน์ฑ์ ๋ง๊ฒ ์๋ฃ๊ตฌ์กฐ๋ฅผ ์ค๊ณํด์ผ ํจ
//svdํด์ ์ญํ๋ ฌ ํด์ ๊ทธ ๊ฐ๋ง ์ด์ฉ ๋ธ๋ผ๋ธ๋ผ

![da](https://user-images.githubusercontent.com/66052467/142765955-37001b24-c4ef-4394-a5c1-59d802e3dbc9.png)

2.ํจ์์ ๋ฐฐ์ด ํต์งธ๋ก ๋ฃ์๋ค๊ฐ ํฐ์ง๋ ๊ฒฝ์ฐ(ํจ์ ํ๋ผ๋ฏธํฐ๋ก ํฌ๊ธฐ๊ฐ ํฐ ๋ฐฐ์ด)
3.์คํ ํ ์ฌ์ด์ฆ ์ ์  ์ปค์ง ๋ (visited ์ฒดํฌ ๋ฑ ์ ํด์)
4. ๊น์ด๊ฐ ๋ง ์ ๋ ์ด์์ ์ฌ๊ท๋ฅผ ๋๋ฆฌ๋ฉด ์คํ์ ํจ์ ๋ง์ด ๋ค์ด๊ฐ์ ๋ฉ๋ชจ๋ฆฌ ์ด๊ณผ
5. ์ง์ญ ๋ณ์ ์ฌ์ด์ฆ ์ปค์ ์คํ ์์ญ ํฐ์ง๋ ๊ฒฝ์ฐ
6. ์ํ ์ ์ฅํ๋ ๋ฐฐ์ด ๋์  ํ ๋นํด์ ์์ฒญ ์ปค์ก์ ๋
7. ์ฌ๋ผ์ด๋ฉ ์๋์ฐ ๋ฌธ์  ๊ทธ๋ฅ ํ ๋
8. ๋ฉ๋ชจ์ด์ ์ด์ ์ ํด๋ ๋๋๋ฐ ๋ฉ๋ชจ์ด์ ์ด์ ํ๋ค๊ฐ 

</pre>
</details>
 
โ์ด๋ถ ํ์์ start๋ ๋ฐฐ์ด ๋ด์ ์ธ๋ฑ์ค, end๋ ๋ฐฐ์ด ๋(๋ฐ๊นฅ) ์ธ๋ฑ์ค (์ด๊ธฐ์๋ start=0 end =arr.end())<br>
โ์ต์ ์คํจ๋ ํธ๋ฆฌ๋ฅผ ๋ง๋๋ ํฌ๋ฃจ์ค์นผO(ElogE), ํ๋ฆผ ์๊ณ ๋ฆฌ์ฆ์O(ElogV), ๊ฐ์ ์ด ๋ง์ ๊ฒฝ์ฐ๋ ํ๋ฆผ, ๊ฐ์ ์ด ์ ์ ๊ฒฝ์ฐ๋ ํฌ๋ฃจ์ค์นผ์ด ์ ๋ฆฌํ๋ค <br>
โ์กฐํฉ n 16๊น์ง, ์์ด n 13์ ๋๊น์ง <br>
โc++/ ์กฐํฉ ๊ฒฐ๊ณผ ์ถ๋ ฅ ์๋ ์์ 1.๋ฌธ์์ด 2. ๋ฐฐ์ด 3.๋ฒกํฐ <br>
โc++/ ๋ฐฐ์ด ์ ์ญ๋ณ์ ์ ์ธ int arr[๋ฐฑ๋ง] ๊ฐ๋ฅ, ์ง์ญ๋ณ์ ์ ์ธ int arr[๋ฐฑ๋ง]ํฐ์ง int arr[์ญ๋ง] <br>

โset์ ๋ฌด์ธ๊ฐ๋ฅผ ์ ์ฅํ์ฌ ์ค๋ณต์ ์์ ๋ ๊ฒ๋ณด๋ค ๋ฐฐ์ด๋ก ์ค๋ณต ์์ ๋ ๊ฒ ๋น ๋ฆ. ex(boj_21922_ํ๋ถ ์ฐ๊ตฌ์ ๋ฏผ์)<br>

โํฌ๋ฃจ์ค์นผ๋ก๋ ์ ๋๊ณ  ํ๋ฆผ์ผ๋ก๋ง ํ ์ ์๋ ๋ฌธ์ ๊ฐ ์๋ค. ๋ฐ๋๋ก ํฌ๋ฃจ์ค์นผ์ ํ๋ฆผ์ผ๋ก ๋ชจ๋ ํ ์ ์๋ค.<br>
โN>12์ด๋ฉด ์กฐํฉ ์ ์ฐ๋๊ฒ ์ข์<br>

<details markdown="1">
<summary>โit.first๊ธฐ์ค ๋ด๋ฆผ์ฐจ์, ๊ฐ์ผ๋ฉด it.seconde๊ธฐ์ค ์ค๋ฆ์ฐจ์ sortWith(compareBy {}.thenBy)<br> </summary>
<br>
<pre>
<code>
 score.sortWith(compareByDescending<Pair<Int, String>> { it.first }.thenBy { it.second })
 </code>
</pre>
</details>
 
 
<details markdown="1">
<summary>โํน์  ๋ฌธ์์ด์ ํฌํจํ ๋ฌธ์์ด๋ค์ ๋ณํ<br> </summary>
<br>
<pre>
<code>
val arr = Array<String>(10){""}
 arr.filter{it.contains("abc")}.forEach{it.replace("abc","ddd")}
</code>
</pre>
</details>

<details markdown="1">
<summary>โArrayList<String> to Array<String><br></summary>
<br>
<pre>
<code>
  val strList = ArrayList<String>()<br>
  val arr : Array<String> = strList.toTypedArray() <br>
</code>
</pre>
</details>


<details markdown="1">
<summary>โ๊น์ ๋ณต์ฌ์ ์์ ๋ณต์ฌ<br> </summary>
<br>
<pre>
Kotlin์์  ๋ฐฐ์ด์ ์๋ณธ ์์ดํ์ ์๋ก ๋ง๋ค์ด ์๋ก ๋ง๋๋ ๊ฐ์ฒด์ ์ถ๊ฐํ  ๊ฒฝ์ฐ๋ ๊น์ ๋ณต์ฌ, ๋๋จธ์ง๋ ์์ ๋ณต์ฌ์ด๋ค.
์์ ๋ณต์ฌ : ์๋ณธ์ ๊ฐ์ด ๋ฐ๋
๊น์ ๋ณต์ฌ : ์๋ณธ์ ๊ฐ์ด ๋ฐ๋์ง ์์
<code>
val arr = intArrayOf(1,2,3)

//์์ ๋ณต์ฌ
val arrCopy = arr 
arrCopy[0]=5 // arr[0] ==5๋ก ๋ฐ๋

//์์ ๋ณต์ฌ
val arrCopy = arr.copyOf()
arrCopy[0]=5 //arr[0] ==5๋ก ๋ฐ๋

//๊น์ ๋ณต์ฌ
val arrCopy = IntArray(3)
for(i in arr.indices){
 arrCopy[i] = arr[i]
}
arrCopy[0]=5 // arr[0]==1 ์ ๋ฐ๋


 //์์ ๋ณต์ฌ
 val src1 = arrayListOf(arrayOf("ICN", "A"), arrayOf("ICN", "B"), arrayOf("B", "ICN"))
 val copiedForEachAdd = ArrayList<Array<String>>()
 src1.forEach { copiedForEachAdd.add(it) } // for each add
 copiedForEachAdd[0][0]="changed" //src1[0][0] == "ICN" ์ ๋ฐ๋
 src1.forEach{print(it.contentToString())}
 println()
 
 //๊น์ ๋ณต์ฌ
 val src2 = arrayListOf(arrayOf("ICN", "A"), arrayOf("ICN", "B"), arrayOf("B", "ICN"))
 val copiedForEachAddCopyOf = ArrayList<Array<String>>()
 copiedForEachAddCopyOf[0][0]="changed" //src2[0][0] == "ICN" ์ ๋ฐ๋
 src2.forEach { copiedForEachAddCopyOf.add(it.copyOf()) }// for each add copy of
 src2.forEach{print(it.contentToString())}
</code>
</pre>

</details>

โval (from,to) = List(2){Integer.parseInt(tk.nextToken())}<br>
//nextToken ์์ ๋๊น์ง ๊ณ์ <br>


<details markdown="1">
<summary>โPriorityQueue ์ ๋ ฌ ์ปค์คํ<br> </summary>
<br>
<pre>
<code>
//๋ค์ต์คํธ๋ผ ์ฌ์ฉ pq
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
<summary>โCollection ์ ๋ ฌ ์ปค์คํ<br> </summary>
<br>
<pre>
<code>
//๋ฌธ์์ด์ ๊ธธ์ด ๊ธฐ์ค ์ค๋ฆ์ฐจ์, ๊ธธ์ด๊ฐ ๊ฐ๋ค๋ฉด ์ฌ์ ์ ์ค๋ฆ์ฐจ์
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
<summary>โPriorityQueue ๋ด๋ฆผ์ฐจ์ ์ ์ธ ๋ ๊ฐ์ง ๋ฐฉ์<br> </summary>
<br>
<pre>
<code>
 val pq1= PriorityQueue<Int>({a,b -> b-a})
 val pq2 = PriorityQueue<Int>(Collections.reverseOrder())
 
</code>
</pre>

</details>

โ 55.coreceAtMost(60) //return 55<br>

<details markdown="1">
<summary>โ?.(์ธ์ดํ์ฝ), !!(non-null ๋จ์  ๊ธฐํธ) </summary>
<br>
<pre>
<code>
fun main(){
 var str1 : String? = null
 println("str1.length = ${str1?.length}") //result : null
 //?.(์ธ์ดํ์ฝ) : ์์ ๋ณ์๊ฐ null์ผ ์ ๋ค์ length๋ฅผ ์คํํ์ง ์๊ณ  null์ ๋ฐํ
 //์ธ์ดํ์ฝ์ ์ฌ์ฉํ์ง ์์ผ๋ฉด ์ปดํ์ผ์๋ฌ ๋ฐ์
 
 println("str1.length =${str1!!.length}") //npe๋ฐ์
 // !!(non-null ๋จ์  ๊ธฐํธ) : ์์ ๋ณ์๊ฐ ๋์ด ์๋๊บผ๋ผ๊ณ  ๋จ์ ํ๋ค.
 // !!์ฌ์ฉ์ ์ปดํ์ผ ์๋ฌ๋ ๋ฐ์ํ์ง ์์ผ๋ npe ๋ฐํ์์๋ฌ ๋ฐ์
 
 val len = if(str1 !=null) str1.length else -1 //์๋ ํ ๋ณํ์ ํตํด str1์ด null์ด ์๋์ด ํ์ธ๋๋ฉด str์ non-null์ํ๊ฐ ๋๋ฉฐ, str1.length๋ฅผ ์ฌ์ฉํ  ์ ์๋ค.
 val len = str1?.length ?: -1 //์์ ์์ ์ธ์ดํ์ฝ๊ณผ ์๋น์ค ํํ์์ผ๋ก ๊ฐ๊ฒฐํ๊ฒ ๋ณํ
 //str1?.length๊ฐ null์ด๋ฉด -1์ ๋ฐํ null์ด ์๋๋ฉด str1.length๋ฅผ ๋ฐํ  
 
}

</code>
</pre>

</details>

โkotlin ํจ์์์ ํ๋ผ๋ฏธํฐ๋ ๋ชจ๋ ๊ฐ์ด ๋ณํ์ง ์๋ Immutable์ด๋ค. (val์ด ์๋ต๋ ํํ)<br>

<details markdown="1">
<summary>โkotlin ํจ์์์ ๋ฐฐ์ด์ ๋งค๊ฐ ๋ณ์๋ก ๋ฐ์์ ๋</summary>
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

<!--
<summary>โArrayList๋ c++์ vector๋ฅผ ๋์ฒดํ  ์ ์๋คใ</summary>

kotlin/java์ ArrayList๋ ๋์  ํฌ๊ธฐ๋ผ๋ ์ ์์ ์ผ๋ฐ ๋ฐฐ์ด๊ณผ ์ฐจ์ด๊ฐ ์๋ค.<br>
.add()๋ฑ์ ํจ์๋ก ์์๋ฅผ ์ถ๊ฐํ  ์ ์๋๋ฐ<br>
c++์ vector์ ๋ค๋ฅด๊ฒ ArrayList๋ ํฌ๊ธฐ๋ฅผ ์ด๊ธฐํํ  ์ ์๋ค.<br>
c++์ vector์ ์์๋ฅผ ์ถ๊ฐํ๋ ๋ฐฉ์์ ๊ฐ๋ค.<br>
.add()ํจ์๋ก ํ์ฌ ArrayList์ ํฌ๊ธฐ๊ฐ 3์ด๋ผ๊ณ  ํ  ๋,<br>
์์๋ฅผ ์ถ๊ฐํ๊ฒ ๋๋ฉด ArrayList์ ํฌ๊ธฐ๋ฅผ ํค์ด ํ ์๋ก์ด ๊ณต๊ฐ์ ๋ ํฐ ๋ฉ๋ชจ๋ฆฌ๋ฅผ ์ก์ ํ<br>
๊ธฐ์กด์ ArrayList์ ์์๋ฅผ ๋ณต์ฌํ๊ณ  ์์๋ฅผ ์ถ๊ฐํ๋ค.<br>
๋ค๋ง, c++์์  ์ฒด๊ฐํ์ง ๋ชป ํ์ง๋ง, ์ฝํ๋ฆฐ์ ์๋๊ฐ ๋๋ ค์ ์๊ณ ๋ฆฌ์ฆ ๋ฌธ์  ํ์ด๋ฅผ ํ  ๋,<br>
ArrayList ์๋ฃ๊ตฌ์กฐ๋ก .add() ํน์ .removeLast()๋ฅผ ๋ง์ด ์ฌ์ฉํ๋ฉด ์๊ฐ์ด ์ค๋ ๊ฑธ๋ฆฌ๊ธฐ ๋๋ฌธ์ <br>
์ฌ๋งํ๋ฉด ๋ฆฌ์คํธ์ ํฌ๊ธฐ๋ฅผ ๋ฏธ๋ฆฌ ์ง์ ํ๊ณ  ์ผ๋ฐ ๋ฐฐ์ด๋ก ์ฒ๋ฆฌํ์.<br>
ex) ์กฐํฉ ์๊ณ ๋ฆฌ์ฆ<br>

ArrayList ์์ ์ถ๊ฐ ๋ฐฉ์
๋ ํฐ ๋ฉ๋ชจ๋ฆฌ๋ฅผ ์ก์ ํ ๊ธฐ์กด ๋ฉ๋ชจ๋ฆฌ์ ๋ณต์ฌ๋ฅผ ํตํด ํฌ๊ธฐ๋ฅผ ๋๋ฆฐ๋ค.
์ด ๋ ํญ์ ์ฌ์  ๋ฉ๋ชจ๋ฆฌ๋ฅผ ๋๊ณ  ๋ฉ๋ชจ๋ฆฌ๋ฅผ ์ถ๊ฐํ๋ค.
์ด๋ฌํ ArrayList์ ํน์ฑ ๋๋ฌธ์ ๊ฐ์ด ์์ฃผ ๋ณ๊ฒฝ๋์ด์ผ ํ  ๋๋ ArrayList๋ฅผ ์ฌ์ฉํ๋ ๊ฒ์ด ์ข์ง ์๋ค.


</details>


<details markdown="1">
-->
<summary>โํ ํฐ์ ๋๊น์ง ์๋ ฅ๋ฐ๊ธฐ</summary>
val tk = StringTokenizer(readLIne())<br>
while(tk.hasMoreTokens()){<br>
arr[i] = Integer.parseInt(tk.nextToken())<br>
}<br>
</details>

<details markdown="1">
<summary>โ์์์  ์๋ฅด๊ธฐ</summary>
String.format("%.3f", cnt / n*100)
</details>

<details markdown="1">
<summary>โfor๋ฌธ์ index (์๋ฐ์์ ์ฐจ์ด์ )</summary>
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
์ฝํ๋ฆฐ์ i๋ for๋ฌธ ๋ด๋ถ์์ ๊ด๋ฆฌํ๊ธฐ ๋๋ฌธ์<br>
for๋ฌธ ๋ฐ๊นฅ์์ ์ฌ์ฉํ  ์ ์์<br>
<pre>
<code>
    //kotlin
    var i :Int
    for(i in 0 until 5){

    }
    println(i)//error : i๋ฅผ ์ด๊ธฐํํ  ๊ฒ
</code>
</pre>
</details>

<details markdown="1">
<summary>โ๋ค์ํ ๋ชจ์ต์ ๋ฒํผ</summary>
<br>
<details markdown="1">
<summary>1.์ ๊ธฐ/ํผ์น๊ธฐ(โคimport๋ ํ์ ์์ผ๋ฉฐ ๊ฐ์ฅ ๊ฐ๊ฒฐํ๋ค )</summary>
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
<summary>2.์ ๊ธฐ/ํผ์น๊ธฐ</summary>
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
<summary>3.์ ๊ธฐ/ํผ์น๊ธฐ</summary>
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
<summary>โ์์ถ๋ ฅ ์๋</summary>
<br>
BufferedReader/Writer faster than Scanner faster than readLine(),print()
</details>

<details markdown="1">
<summary>โ๋ฒํผ ์ฌ์ฉ๋ฒ</summary>
<br>
import java.io.BufferedReader<br>
import java.io.BufferedWriter<br>
import java.io.InputStreamReader<br?
import java.io.OutputStreamWriter<br>


val br = BufferedReader(InputStreamReader(System.`in`)<br>
val bw = BufferedWriter(OutputStreamReader(System.out)<br>

BufferedReader, BufferedWriter ์ฌ์ฉ ํ ํญ์ ๋ซ์์ฃผ๊ธฐ<br>
์ ๋ซ์ผ๋ฉด ๋ฒํผ์ ๋จ์ ์์<br>
br.close()<br>
bw.close()<br>
</details>

<details markdown="1">
<summary>โintํ๋ณํ ์๋</summary>
<br>
Integer.parseInt() faster than .toInt()
</details>



<details markdown="1">
<summary>โ์๋ ฅ ๋ถ๋ฆฌ  </summary>
<br>
StringTokenizer faster than split
</details>

<details markdown="1">
<summary>โ์๋ ฅ ๋ถ๋ฆฌ ์ ์ฅ</summary>
val (a,b) = br.readLine().split(' ').map{Integer.parseInt(it)}<br>
val st = StringTokenizer(br.readLine())<br>
val (a,b) = List(2) {st.nextToken().toInt()}
</details>


