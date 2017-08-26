import java.util.*;
import java.io.*;
//imports

public class Assignment2//class for running the main parts of the program, like selecting the file
{
   public static void main(String [] args)//main method
   {
      try
      {
         File file = new File(args[0]);
         Scanner inFile = new Scanner(file);
      }
      catch(ArrayIndexOutOfBoundsException AIOBe)
      {
         System.out.println("You did not provide any run arguments, or you provided them incorrectly.");
      }
      catch(FileNotFoundException FNFe)
      {
         System.out.println("Your file could not be found.");
      }
      
      //Graph g = new Graph(1);
      
      
      
   }//end main
}//end Assignment2 class