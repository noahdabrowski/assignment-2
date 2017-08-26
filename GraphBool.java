import java.util.*;
//imports

public class GraphBool//class to represent the graph given in the file
{
   private int N;//number of nodes
   private boolean[][] adj;//the adjacency matrix
   
   GraphBool(int n)//constructor
   {
      N = n;//set the N value(number of nodes) for the graph to little n from the param
      adj = new boolean[n][n];//reset the adj to be a boolean array size n x n
   }
   
   void addEdge(int i, int j)
   {
      adj[i][j] = true;
   }
   void removeEdge(int i, int j)
   {
      adj[i][j] = false;
   }
   boolean hasEdge(int i, int j)
   {
      return adj[i][j];
   }
   
   
   
}//end Graph class