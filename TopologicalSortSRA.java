import java.util.*;
//imports

public class TopologicalSortSRA//topo sort using SRA
{
   Graph graph;//needs a graph to operate on
   
   String sortedOrder;//string for the sorted order
   
   long time;//this is the operating time of this algorithm
   
   public TopologicalSortSRA(Graph g)
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
         int n = graph.N;//redeclare n so we dont have to do graph.N every time
         
         Stack stack = new Stack();//new stack
         
         boolean visited[] = new boolean[n];//make boolean array to show which nodes have been visited
         
         for(int i = 0; i < n; i++)//for each node
         {
            visited[i] = false;//set visited to false
         }
         
         int nodesLeft = n;//start with n nodes left since thats the starting amount of nodes
         
         while(!(nodesLeft == 0))//while there are still nodes left
         {
            for(int i = 0; i < n; i++)//for each node
            {
               if(visited[i] == false)//if the node has not been visited
               {
                  if(nodesLeft == 1)//if the node is the last node,
                  {
                     visited[i] = true;//set it as visited
                     stack.push(new Integer(i));//push the node to stack, storing the result and completing the loop
                     break;//we are done, break out
                  }
                  
                  boolean hasIncomingEdge = false;//assume that it has no incoming edges to start
                  
                  for(int j = 0; j < n; j++)//for each node(to compare to the current node being visited)
                  {
                     Integer z;//helper integer
                     if(!visited[j])//if the node at j hasnt been visited(removed) already(because if it has been removed, it cant affect anything with its edges anymore
                     {
                        Iterator<Integer> it = graph.adjList[j].iterator();//make an iterator to go through each node in node j's adjacency list
                        while(it.hasNext())//while there are nodes it hasnt looked at yet
                        {
                           z = it.next();//set z to the next node
                           boolean alreadyVisited = false;//assume that the current node(z) has not yet been removed
                        
                           for(int k = 0; k < n; k++)//for each node
                           {
                              if(visited[k] && (k == z))//if it has been visited already, and we are currently looking at that node,
                              {
                                 alreadyVisited = true;//set it to be already visited
                                 break;//we dont need to stay in this loop since we already found one true value
                              }
                           }
                           if((z == i) && (!(alreadyVisited)))//if z is equal to i(incoming edge) and it hasnt already been removed
                           {
                              hasIncomingEdge = true;//there is an incoming edge, cant remove this one
                              break;//break loop, we already found one incoming edge
                           }
                        }
                     }
                  }
                  if(!hasIncomingEdge)//if i doesnt have an incoming edge,
                  {
                     visited[i] = true;//set it visited(removed)
                     stack.push(new Integer(i));//push current node to stack, storing result
                     break;//break the loop, we only want to remove one node at a time
                  }
               }
            }
            
            int falseCount = 0;//count the false values
            for(int i = 0; i < n; i++)
            {
               if(visited[i] == false)//if not visited
               {
                  falseCount++;//increment false count
               }
            }
            nodesLeft = falseCount;//nodes left = falses
         }
         
         String temp = "";//temp string to hold the values of the stack
         while(stack.empty() == false)//while there are values in the stack
         {
            if((!temp.equals("")))//if the stack isnt empty
            {
               temp = ", "+ temp;//add a comma
            }
            temp = "" + stack.pop() + temp;//add the next value into the temp string
         }
         setOrder(temp);//set the sortedOrder to what you got from the stack
         
         long endTime = System.nanoTime();//stop the timer(kinda)
         long totalTimeEstimate = endTime - startTime;//figure out total time
         setTime(totalTimeEstimate);//set the total time
         return totalTimeEstimate;//return the time
      }
      else//if the graph wasnt valid
      {
         System.out.print("The graph entered is not valid. One or more of it's nodes is adjacent to itself. Or something like that.");//error message
         return -1;//return an impossible time to make sure it quits
      }
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
      String returnVal = "The following set of values is the result of a topographical sort using SRA:\n";//value to be returned. Will be added on to
      
      returnVal = returnVal + sortedOrder;//add the sorted order
      
      return returnVal;//return
   }
}//end class