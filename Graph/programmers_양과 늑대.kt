//https://programmers.co.kr/learn/courses/30/lessons/92343
class Solution {

    //0양 1늑
    lateinit var edge: Array<ArrayList<Int>>
    //해당 노드에 양,늑대 보유 상태 방문 체크
    lateinit var visited: Array<Array<BooleanArray>>
    var answer=1

    fun dfs(info: IntArray,cur: Int, sheep: Int, wolf: Int){

        answer = answer.coerceAtLeast(sheep)

        for(next in edge[cur]){

            var nextSheep = sheep
            var nextWolf = wolf
            if(info[next]==0){
                nextSheep++
            }
            else if(info[next]==1){
                nextWolf++
            }
            if(nextSheep<=nextWolf) continue
            if(visited[next][nextSheep][nextWolf]) continue

            val copyInfo = IntArray(info.size){
                info[it]
            }
            copyInfo[next] = -1
            visited[next][nextSheep][nextWolf] = true

            dfs(copyInfo,next, nextSheep, nextWolf)
            visited[next][nextSheep][nextWolf]=false
        }

    }

    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        //preset
        edge = Array(info.size){ArrayList()}
        visited = Array(info.size){Array(info.size+1){BooleanArray(info.size+1)} }
        for(e in edges){
            edge[e[0]].add(e[1])
            edge[e[1]].add(e[0])
        }
        info[0]=-1
        visited[0][1][0]=true
        dfs(info,0,1,0)

        return answer
    }
}
