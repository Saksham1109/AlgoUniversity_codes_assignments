package org.practice.graph;

import java.util.*;
public class bigdiscs {
    public static long d2(long x1,long y1,long x2,long y2){
        return (x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2);
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int n = sc.nextInt();
            long[][] cirlces = new long[n][3];
            for(int i=0;i<n;i++){
                for(int j=0;j<3;j++){
                    cirlces[i][j] = sc.nextLong();
                }
            }
            solve(x,y,n,cirlces);
        }
    }
    public static void solve(int x,int y,int n,long[][] cirlces){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n+4;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            int idx = i+4;
            if(cirlces[i][0] - cirlces[i][2] <= 0)
                addEdge(adj,3,idx);

            if(cirlces[i][0] + cirlces[i][2] >= x)
                addEdge(adj,1,idx);

            if(cirlces[i][1] - cirlces[i][2] <= 0)
                addEdge(adj,2,idx);

            if(cirlces[i][1] + cirlces[i][2] >= y)
                addEdge(adj,0,idx);
        }

        for(int i=0;i<n;i++){
            int idxi = i+4;
            for(int j=i+1;j<n;j++){
                int idxj = j+4;

                if(d2(cirlces[i][0],cirlces[i][1],cirlces[j][0],cirlces[j][1]) <=
                        (cirlces[i][2] + cirlces[j][2]) * (cirlces[i][2]

                                + cirlces[j][2])){

                    addEdge(adj,idxi,idxj);

                }
            }
        }
//0-T
//1-R
//2-B
//3-L
        boolean[] TV = bfs(0,adj);
        boolean[] RV = bfs(1,adj);
        boolean ans = !(TV[2] || TV[3] || RV[2] || RV[3]);
        System.out.println(ans ? "YES" : "NO");
    }
    public static boolean[] bfs(int src,ArrayList<ArrayList<Integer>>
            adj){

        int n = adj.size();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(vis,false);
        q.add(src);
        vis[src] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int a: adj.get(node)){
                if(!vis[a]){
                    vis[a] = true;
                    q.add(a);
                }
            }
        }
        return vis;
    }
}