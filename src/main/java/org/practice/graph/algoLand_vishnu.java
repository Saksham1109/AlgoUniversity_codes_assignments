package org.practice.graph;

import java.util.*;

public class algoLand_vishnu {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Map<String, Integer>> arr = new ArrayList<>();
        for(int i = 0; i < n; i++)
            arr.add(new HashMap<>());
        int count = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int j = 0; j < m; j++){
            String str = sc.next();
            String str2 = sc.next();
            String str3 = sc.next();
            int a = 0;
            int b = 0;
            if (hm.containsKey(str))
                a = hm.get(str);
            else
            {
                a = count++;
                hm.put(str,a);
            }
            if (hm.containsKey(str2))
                b = hm.get(str2);
            else
            {
                b = count++;
                hm.put(str2, b);
            }
            arr.get(a).put(str3,b);
        }
        String source = sc.next();
        String dest = sc.next();
        int s = hm.get(source);
        int d = hm.get(dest);
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        String[] visited = new String[n];
        int[] visited2 = new int[n];
        visited[s] = "";
        visited2[s] = 0;
        while(!q.isEmpty()){
            int current = q.remove();
            for (Map.Entry<String, Integer> entry : arr.get(current).entrySet())
            {
                if (visited[entry.getValue()] == null){
                    q.add(entry.getValue());
                    visited[entry.getValue()] = visited[current] + "\n" + entry.getKey();
                    visited2[entry.getValue()] = visited2[current] + 1;
                }
            } }
        if (visited[d] == null){
            System.out.println("Impossible");
        }
        else{
            System.out.println(visited2[d] + "\n" + visited[d]);
        }
    }
}
