package org.practice.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class AvoidingCitiesBST1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        int src=sc.nextInt();
        int dest= sc.nextInt();
        int[] curseArr=new int[n];
        boolean init=false;
        for(int i=0;i<curseArr.length;i++)
        {
            curseArr[i]= sc.nextInt();
        }
        if(curseArr[src]==1 || curseArr[dest]==1)
        {
            System.out.println(-1);
        }
        else
        {
            ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                graph.add(new ArrayList<>());
            }
            for(int i=0;i<m;i++)
            {
                int u= sc.nextInt();
                int v= sc.nextInt();
                if(curseArr[u]==0 && curseArr[v]==0)
                {
                    graph.get(u).add(v);
                    graph.get(v).add(u);
                }
            }
            Queue<Integer> queue=new LinkedList<>();
            queue.add(src);
            curseArr[src]=1;
            int[] dis=new int[n];
            AtomicInteger found = new AtomicInteger();
            while(!queue.isEmpty())
            {

                int par=queue.poll();
                graph.get(par).forEach(child->
                {
                    if(curseArr[child]==0)
                    {
                        if(child==dest)
                        {
                            found.set(1);
                        }
                        curseArr[child]=1;
                        dis[child]=dis[par]+1;
                        queue.add(child);
                    }
                });
            }
            if(found.get()==1)
            {
                System.out.println(dis[dest]);
            }
            else
            {
                System.out.println(-1);
            }

        }
        }
}