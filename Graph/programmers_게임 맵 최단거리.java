//https://programmers.co.kr/learn/courses/30/lessons/1844
import java.util.*;
class Node{
    int r;
    int c;
    int dis;
    Node(int r, int c, int dis){
        this.r = r;
        this.c = c;
        this.dis = dis;
    }
}

class Solution {

    static int[][] dir = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
    };
    static int bfs(int[][] maps){
        Queue<Node> q = new LinkedList<>();
        int n = maps.length;
        int m = maps[0].length;
        q.add(new Node(0,0,1));
        maps[0][0] = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i=0; i<4; i++){
                int nr = cur.r+ dir[i][0];
                int nc = cur.c + dir[i][1];
                if(nr <0 || nr >= n || nc < 0 || nc >= m ) continue;
                //end
                if(nr == n-1 && nc == m-1){
                    return cur.dis + 1;
                }
                if(maps[nr][nc]==0) continue;
                q.add(new Node(nr,nc,cur.dis+1));
                maps[nr][nc] = 0;
            }
        }
        return -1;
    }
    public int solution(int[][] maps) {
        return bfs(maps);
    }
}
