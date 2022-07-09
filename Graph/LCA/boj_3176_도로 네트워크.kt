//https://www.acmicpc.net/problem/3176
val br = System.`in`.bufferedReader()
fun getIntList() = br.readLine().split(' ').map { it.toInt() }
fun getInt() = br.readLine().toInt()

const val TREE_HEIGHT = 18

//v = 10만, 노드 번호
//h = 18, 부모 깊이 (2^h)
var n = 0
var k = 0
lateinit var parent: Array<IntArray>
lateinit var minRoads: Array<IntArray>
lateinit var maxRoads: Array<IntArray>
lateinit var depth: IntArray
lateinit var edge: Array<ArrayList<Pair<Int, Int>>>

fun dfs(cur: Int, d: Int) {
    depth[cur] = d

    for (next in edge[cur]) {
        if (depth[next.first] > 0) continue
        dfs(next.first, d + 1)
        parent[next.first][0] = cur
        minRoads[next.first][0] = next.second
        maxRoads[next.first][0] = next.second
    }
}

fun fillParent() {
    for (d in 1 until TREE_HEIGHT) {
        for (node in 2..n) {
            parent[node][d] = parent[parent[node][d - 1]][d - 1]
            // 도로네트워크 추가
            minRoads[node][d] =
                minRoads[node][d - 1].coerceAtMost(minRoads[parent[node][d - 1]][d - 1])
            maxRoads[node][d] =
                maxRoads[node][d - 1].coerceAtLeast(maxRoads[parent[node][d - 1]][d - 1])
        }
    }
}

fun lca(a: Int, b: Int): Pair<Int, Int> {
    var min = Integer.MAX_VALUE
    var max = -1
    var start = a
    var end = b
    var diff = depth[start] - depth[end]
    var i = 0

    //높이 조정
    while (diff > 0) {
        if (diff % 2 == 1) {
            min = min.coerceAtMost(minRoads[start][i])
            max = max.coerceAtLeast(maxRoads[start][i])
            start = parent[start][i]
        }
        diff = diff shr 1
        i++
    }
    //높이가 같은데 둘이 같은 수라면 종료
    if (start == end) return Pair(min, max)
    for (d in TREE_HEIGHT - 1 downTo 0) {
        if (parent[start][d] != 0 && parent[start][d] != parent[end][d]) {
            min = min.coerceAtMost(minRoads[start][d])
            min = min.coerceAtMost(minRoads[end][d])

            max = max.coerceAtLeast(maxRoads[start][d])
            max = max.coerceAtLeast(maxRoads[end][d])

            start = parent[start][d]
            end = parent[end][d]
        }
        min = min.coerceAtMost(minRoads[start][0])
        min = min.coerceAtMost(minRoads[end][0])

        max = max.coerceAtLeast(maxRoads[start][0])
        max = max.coerceAtLeast(maxRoads[end][0])
    }
    return Pair(min, max)

}

fun main() = with(System.out.bufferedWriter()) {

    //input
    n = getInt()
    parent = Array(n + 1) { IntArray(TREE_HEIGHT) }
    minRoads = Array(n + 1) { IntArray(TREE_HEIGHT){Int.MAX_VALUE} }
    maxRoads = Array(n + 1) { IntArray(TREE_HEIGHT) }
    depth = IntArray(n + 1)
    edge = Array(n + 1) { ArrayList() }

    repeat(n - 1) {
        val (from, to, dis) = getIntList()
        edge[from].add(Pair(to, dis))
        edge[to].add(Pair(from, dis))
    }
    k = getInt()

    //parent[v][0] 구하고 lca에 사용할 depth 구하기
    dfs(1, 1)

    //부모 채워주기
    fillParent()
    //a 와 b 경로의 최솟값은 공통 조상인 c, a->c, b->c의 최솟값
    //높이 맞춰주기
    //높이 맞춘 aa -> c vs b->c 의 최솟값과 a->aa값 비교
    repeat(k) {
        val (start, end) = getIntList()
        var ans: Pair<Int, Int>
        if (depth[start] < depth[end]) {
            ans = lca(end, start)
        } else {
            ans = lca(start, end)
        }
        write("${ans.first} ${ans.second}\n")
    }

    close()
}
