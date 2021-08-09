## 🟣Kotlin/Java를 이용한 알고리즘 문제 풀이
####   c++을 이용한 풀이는 아래의 블로그에 게시했습니다.
  <a href="http://ongveloper.tistory.com">
    <img 
        src="https://img.shields.io/badge/-Tech%20Blog-655ced?style=flat&link=https://ongveloper.tistory.com"
         style="height : auto; margin-left : 10px; margin-right : 10px;"/>
</a>

### 알고리즘 문제 풀이를 위한 팁 [Kotlin/Java]

✅<br>
BufferedReader/Writer faster than Scanner faster than readLine(),print()<br>

✅<br>
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

✅<br>
Integer.parseInt() faster than .toInt()<br>

✅<br>
StringTokenizer faster than split<br>

✅<br>
val (a,b) = br.readLine().split(' ').map{Integer.parseInt(it)}<br>
