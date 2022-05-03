//https://programmers.co.kr/learn/courses/30/lessons/86052
class Solution {
    var resultArr = ArrayList<Int>()
    lateinit var visited: Array<Array<BooleanArray>>
    //상우하좌
    //d+3 %4 L
    //d+1 %4 R
    val dir = arrayOf(
        arrayOf(-1,0),
        arrayOf(0,1),
        arrayOf(1,0),
        arrayOf(0,-1)
    )
    fun simulation(grid: Array<String>, r: Int, c: Int, d: Int, n: Int, m: Int){
        var nr = r
        var nc = c
        var nd = d
        var dis = 0
        while(true){
            //check
            if(visited[nr][nc][nd]) break

            visited[nr][nc][nd] = true
            //next
            when(grid[nr][nc]){
                'L'-> nd = (nd+3)%4
                'R'-> nd = (nd+1)%4
                else-> {}
            }
            nr = (nr + dir[nd][0]+n)%n
            nc = (nc + dir[nd][1]+m)%m
            dis++

        }
        resultArr.add(dis)
    }

    fun solution(grid: Array<String>): IntArray {
        //solve
        //각 노드별 4방향 모두 탐색
        val n = grid.size
        val m = grid[0].length
        visited = Array(n){Array(m){BooleanArray(4)} }
        for(r in grid.indices){
            for(c in grid[r].indices){
                for(d in 0 until 4){
                    if(visited[r][c][d]) continue
                    simulation(grid,r,c,d,n,m)
                }
            }
        }
        //output
        return resultArr.sorted().toIntArray()
    }
}
