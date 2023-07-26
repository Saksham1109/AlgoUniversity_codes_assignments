package org.practice.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class CompanyHierarchy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        boolean[] vis= new boolean[n];
        for(int i=1;i<n;i++)
        {
            arr[i]=sc.nextInt()-1;
        }
        ArrayList<ArrayList<Integer>> graph =new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<=n-1;i++)
        {
            graph.get(i).add(arr[i]);
            graph.get(arr[i]).add(i);
        }

    }
}
