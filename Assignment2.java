import java.util.*;
import java.io.*;
//imports

public class Assignment2//class for running the main parts of the program, like selecting the file
{
   public static void main(String [] args)//main method
   {
      try//try statements are good programming :)
      {
         File file = new File(args[0]);//set the file to be the file whose name is in the run args in spot 0
         Scanner inFile = new Scanner(file);//make scanner

         int n = getNFromFile(file, inFile);//get the n value to build the graph(also remove it from the file)
         int[][] matrix = readFromFile(file, inFile, n);//build the adjacency matrix that was given in the file, to be used in making
         //an easier representation(adjacency lists)
         
         Graph g = new Graph(n, matrix);
         //System.out.print(g.toString());
         
      }
      catch(ArrayIndexOutOfBoundsException AIOBe)//explained by the error message
      {
         System.out.println("You did not provide any run arguments, or you provided them incorrectly.");//neat error message
      }
      catch(FileNotFoundException FNFe)//also explained by error message
      {
         System.out.println("Your file could not be found.");//neato error message
      }
      
   }//end main
   
   public static int getNFromFile(File file, Scanner inFile)//method to get the n value from the file
   {
      int n = inFile.nextInt();//find the N value that is on the first line of the file
      String garbage = inFile.nextLine();//get rid of the garbage line
      return n;//return n
   }
   
   public static int[][] readFromFile(File file, Scanner inFile, int n)//method to read from the given file. Returns a 2d array
   {
      //the n value is already gone, and so is the garbage newline that it was on. We can start building the matrix immediately
      int[][] temp = new int[n][n];//make the temporary 2d array that will store the adjacency matrix
      
      int lineCount = 0;//keep track of what line we are on
      
      while(inFile.hasNextLine())//while the file still has lines to read
      {
         String tempLine = inFile.nextLine();//make a string with the text from the line for easier reading
         Scanner tempScanner = new Scanner(tempLine);//make a scanner to scan the string specifically
         tempScanner.useDelimiter(" ");//they are space separated, so set the delimiter to be a space
         
         for(int i = 0; i < n; i++)//for each node
         {
            temp[lineCount][i] = tempScanner.nextInt();//set the adjacency value for the current node, denoted by the line count
         }
         
         lineCount++;//increment the line count since we finished a line
      }
      
      return temp;//return the adjacency matrix
   }
   
}//end Assignment2 class