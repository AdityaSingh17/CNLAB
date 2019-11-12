// Write a program to find the shortest path between vertices using Bellman ford algorithm.

import java.io.*;
import java.util.*;
import java.io.DataInputStream;

class Edge
{
    int source;
    int dest;
    int weight;
}
class Bellman
{
    public static void BellmanFord(Edge edges[], int edgecount, int nodecount, int source)
    {
        int infinity=50000;
        int i, j;
        int distance[]=new int[nodecount];
        for(i=0; i<nodecount; i++)
        distance[i]=infinity;
        distance[source]=0;
        for(i=0; i<nodecount; i++)
        {
            boolean somethingchanged=false;
            for(j=0; j<edgecount; j++)
            {
                if(distance[edges[j].source]!=infinity)
                {
                    int new_distance=distance[edges[j].source]+edges[j].weight;
                    if(new_distance<distance[edges[j].dest])
                    {
                        distance[edges[j].dest]=new_distance;
                        somethingchanged=true;
                    }
                }
            }
            if(!somethingchanged)
            break;
        }
        for(i=0; i<edgecount; ++i)
        {
        if(distance[edges[i].dest]>distance[edges[i].source]+edges[i].weight)
        System.out.println("Negative edge weight cycles detected!!!");
        }
        for(i=0; i<nodecount; ++i)
        System.out.println("The shortest distance between nodes "+source+" & "+i+" is "+distance[i]);
    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        Edge edges[]=new Edge[16];
        for( int i=0; i<16; i++)
        {
            edges[i]=new Edge();
            // The edges have to be entered in Source-Destination-Weight format. 
            // If source and destination are same then weight = 0. (1-1-0,2-2-0)
            // If there is no edge between source and destination, then weight = 999.
            // This is for a graph with four vertices. The starting vertex is 1.
            System.out.print("Enter source: ");
            edges[i].source=in.nextInt();
            System.out.print("Enter destination: ");
            edges[i].dest=in.nextInt();
            System.out.print("Enter weight: ");
            edges[i].weight=in.nextInt();
            System.out.println();
        }
        BellmanFord(edges, 16, 5, 1);
    }
}
