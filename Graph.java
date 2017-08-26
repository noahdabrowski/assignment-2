import java.util.*;
//imports

public class Graph//class to represent the graph given in the file
{
   int N;//number of nodes
   LinkedList<Integer> adjList[];//the adjacency list
   boolean valid;//whether or not this is a valid graph for topo sort
   
   public Graph(int n, int[][] matrix)//constructor
   {
      N = n;//set the N value(number of nodes) for the graph to little n from the param
      adjList = new LinkedList[n];//reset the adjList to be an array of LinkedList<Integer> of size n(each node will have its own list)
      for(int i = 0; i < n; i++)
      {
         adjList[i] = new LinkedList();//for each node, give it its own adjacency list(similar to a matrix)
      }
      
      populateGraph(matrix);//populate the graph properly with the values from the adjacency matrix
      valid = checkValidity(matrix);//set the validity of the graph
   }
   
   public void populateGraph(int[][] matrix)//method to populate the graph with the proper values from the adjacency matrix
   {
      for(int i = 0; i < N; i++)//for row(the node to be compared to)
      {
         for(int j = 0; j < N; j++)//for column(each other node to compare to this node)
         {
            if(matrix[i][j] == 1)//if the value at said vertex is 1(adjacent)
            {
               addEdge(i,j);//add an edge to its list
            }
         }
      }
   }
   
   public boolean checkValidity(int[][] matrix)//method to check if the graph is valid
   {
      boolean valid = true;//assume the graph is valid
      
      for(int i = 0; i < N; i++)//for row(the node to be compared to)
      {
         for(int j = 0; j < N; j++)//for column(each other node to compare to this node)
         {
            if(i == j)//if the node is being compared to itself
            {
               if(matrix[i][j] == 1)//if the value at said vertex is 1(adjacent)
               {
                  valid = false;//set valid to false, because that means that its adjacent to itself and cant be sorted
               }
            }
         }
      }
      return valid;//return the validity
   }
   
   public void addEdge(int n, int t)//method to add an edge
   {
      adjList[n].add(t);//add the target(t) node to the adjacency list of node n, which is in the main linkedlist adjList
   }
   
   public String toString()//toString method for testing mostly
   {
      String returnVal = "Adjacency Lists:\n";//set initial message
      
      for(int i = 0; i < adjList.length; i++)//for each adjacency list in the array of linkedlists
      {
         returnVal = returnVal + "Adjacency for node " + i + ": ";//denote what node you are displaying adjacency for
         for(int j = 0; j < adjList[i].size(); j++)//for each element in the adjacency list for the current node
         {
            returnVal = returnVal + adjList[i].get(j);//add the value to the list of adjacent values
            if(j != (adjList[i].size() - 1))//if it isnt the last element in this list
            {
               returnVal = returnVal + ",";//add a comma between values
            }
         }
         if(i != (adjList.length - 1))//if it isnt the last element in the list
         {
            returnVal = returnVal + "\n";//add a newline for the next node
         }
      }
      return returnVal;//return the string
   }
}//end Graph class