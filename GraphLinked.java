import java.util.*;
//imports

public class GraphLinked//class to represent the graph given in the file
{
   private int N;//number of nodes
   private LinkedList<Integer> adjList[];//the adjacency list
   
   GraphLinked(int n)//constructor
   {
      N = n;//set the N value(number of nodes) for the graph to little n from the param
      adjList = new LinkedList[n];//reset the adjList to be an array of LinkedList<Integer> of size n(each node will have its own list)
      for(int i = 0; i < n; ++i)
      {
         adjList[i] = new LinkedList();//for each node, give it its own adjacency list(creates the matrix)
      }
   }
   
   void addEdge(int n, int d)
   {
      adjList[n].add(d);
   }
   
   
   
}//end GraphLinked class