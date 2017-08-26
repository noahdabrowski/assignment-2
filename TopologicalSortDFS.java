import java.util.*;
//imports

public class TopologicalSortDFS//topo sort using DFS
{
   Graph graph;//needs a graph to operate on
   
   String sortedOrder;//string for the sorted order
   
   long time;//this is the operating time of this algorithm
   
   public TopologicalSortDFS(Graph g)
   {
      graph = g;//give it it's graph
      time = 0;//initial time is 0
      
      time = topoSort();//this runs the algorithm, and also sets the time it took to complete the algorithm
   }
   
   public long topoSort()//this is the actual algorithm
   {
      if(graph.valid)//if the graph is valid(AKA its a DAG(Directed Acyclic Graph))
      {
         long startTime = System.nanoTime();//start the timer(kinda)
         
         Stack stack = new Stack();//new stack
         
         int n = graph.N;//redeclare n so we dont have to do graph.N every time
         
         boolean visited[] = new boolean[n];//make boolean array to show which nodes have been visited
         
         for(int i = 0; i < n; i++)//for each node
         {
            visited[i] = false;//set visited to false
         }
         
         for(int i = 0; i < n; i++)//for each node
         {
            if(visited[i] == false)//if the node has not been visited
            {
               topoSortRecur(i,visited,stack);//call the recursive method for this node
            }
         }
         
         String temp = "";//temp string to hold the values of the stack
         while(stack.empty() == false)//while there are values in the stack
         {
            temp = temp + stack.pop() + "";//add the next value into the temp string
            if(!(stack.empty()))//if the stack has another value
            {
               temp = temp + ", ";//add a comma
            }
         }
         setOrder(temp);//set the sortedOrder to what you got from the stack
         
         long endTime = System.nanoTime();//stop the timer(kinda)
         long totalTimeEstimate = endTime - startTime;//figure out total time
         setTime(totalTimeEstimate);//set the total time
         return totalTimeEstimate;//return the time
      }
      else//if the graph wasnt valid
      {
         System.out.println("The graph entered is not valid. One or more of it's nodes is adjacent to itself. Or something like that.");//error message
         return -1;//return an impossible time to make sure it quits
      }
   }
   
   public void topoSortRecur(int n, boolean visited[], Stack stack)//recursive function for topoSort
   {
      visited[n] = true;//set current node as visited
      
      Integer i;//helper integer
      
      Iterator<Integer> it = graph.adjList[n].iterator();//make an iterator to go through each node in node n's adjacency list
      while(it.hasNext())//while there are nodes it hasnt looked at yet
      {
         i = it.next();//set i to the next node
         if(!visited[i])//if it hasnt been visited yet,
         {
            topoSortRecur(i, visited, stack);//recur
         }
      }
      stack.push(new Integer(n));//push current vertex to stack, storing result
   }
   
   public void setTime(long time)//method to easily set the time after an algorithm run
   {
      time = this.time;//set the time
   }
   public long getTime()//method to easily get the time after an algorithm run
   {
      return time;//get the time
   }
   
   public void setOrder(String sorted)//method to set the sorted order after an algorithm run
   {
      sortedOrder = sorted;//set the order
   }
   public String getOrder()//method to get the sorted order after an algorithm run
   {
      return sortedOrder;//get the sorted order
   }
   
   public String toString()//toString method to display the results
   {
      String returnVal = "The following set of values is the result of a topographical sort using DFS:\n";//value to be returned. Will be added on to
      
      returnVal = returnVal + sortedOrder;//add the sorted order
      
      return returnVal;//return
   }
   
}//end class