//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15StKqAQkCFAYD
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Edge implements Comparable<Edge>{
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
 
class Solution {
 
    static int n;
    static double E;
    static ArrayList<Edge> edge;
    static long answer=0;
    static long[] parent;
 
    static long getParent(long x) {
        if(parent[(int)x]==x) return x;
        else return parent[(int)x] = getParent(parent[(int)x]); 
    }
     
    static void unionParent(long a, long b) {
        a = getParent(a);
        b = getParent(b);
        if(a<b) {
            parent[(int)b] = a;
        }
        else {
            parent[(int)a] = b;
        }
    }
     
    static boolean findParent(long a, long b) {
        a = getParent(a);
        b = getParent(b);
        return a==b;
    }
    //크루스칼(유니온 파인드)
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // input
            n =Integer.parseInt(br.readLine());
            StringTokenizer tk = new StringTokenizer(br.readLine());
            long[] x = new long[n];
            long[] y = new long[n];
            for(int i=0;i< n ; i++) {
                x[i] = Long.parseLong(tk.nextToken());
            }
            tk = new StringTokenizer(br.readLine());
            for(int i=0; i<n;i ++) {
                y[i] = Long.parseLong(tk.nextToken());
            }
            E = Double.parseDouble(br.readLine());
            parent = new long[n];
            for(int i=0; i< n ; i++) {
                parent[i] =i;
            }
            //간선 저장
            edge = new ArrayList<Edge>();
            for(int i=0; i<n;i++) {
                for(int j=i+1; j<n; j++) {
                    long dis = (x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j]) * (y[i]-y[j]);
                    edge.add(new Edge(dis,i,j));    
                }
            }
            //간선 dis 기준 오름차순
            Collections.sort(edge);
             
            //solve
            for(Edge e : edge) {
                //연결되어있지 않다면
                if(!findParent(e.from, e.to)) {
                    unionParent(e.from, e.to);
                    answer+=e.dis;
                }
            }
            //output
            System.out.println("#" + t+" " + Math.round(E*answer));
             
            //reset
            answer=0;
        }
    }
}
