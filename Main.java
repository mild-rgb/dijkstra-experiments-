// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.*;
import java.lang.*;
import java.util.*;


class ShortestPath
{

    void printSolution(int dist[])
    {
        System.out.println(
                "Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    static final int V = 9; //number of nodes in graph
    int minDistance(int dist[], Boolean nodeChecked[]) //this function finds the node's closest neighbour
    {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if(nodeChecked[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    void dijksta(int graph[][], int src) //graph is given as a 2d array
    {
        int dist[] = new int[V];  //this stores the outputs
        Boolean nodeChecked[] = new Boolean[V]; //this records whether a node has been checked

        for(int i = 0; i < V; i++) //this sets nodes as being unchecked
        {
            dist[i] = Integer.MAX_VALUE;
            nodeChecked[i] = false;
        }

        dist[src] = 0; //the distance from the source is always zero

        for (int count = 0; count < V - 1; count++)
        {
            int u = minDistance(dist, nodeChecked); //yes, i can give arrays as function inputs - this takes all the connections to a node and returns the closest
            nodeChecked[u] = true;
            for (int v = 0; v < V; v++)
            {
                Boolean notChecked = (!nodeChecked[v] && graph[u][v] != 0);
                Boolean noConnection = (dist[u] != Integer.MAX_VALUE);
                Boolean closerRoute = (dist[u] + graph[u][v] < dist[v]);
                if(notChecked && noConnection && closerRoute)
                {
                    dist[v] = dist[u] + graph[u][v];
                    System.out.println(dist[v]);
                }
            }
        }
        printSolution(dist);
    }

    public static void main(String[] args)
    {
        ShortestPath t = new ShortestPath();
        InputWindow IW = new InputWindow();

        /* Let us create the example graph discussed above
         */
        int source = -1;
        while(source < 0)
        {
            try {
                source = IW.getInput();
                Thread.sleep(100); //if this is taken out then it loops too fast and doesn't
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }



        int graph[][] = new int[][] {
              //  1  2  3  4  5  6  7  8  9
                {0, 1, 0},
                {1, 0, 4},
                {0, 4, 0}}; //9



        // Function call

            t.dijksta(graph, IW.getInput());
            System.exit(0);



    }
}