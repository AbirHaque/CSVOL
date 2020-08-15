import java.io.*;
import java.util.*;

public class Main
{
  public static void main(String[] args) throws Exception
  {
    BufferedReader in = new BufferedReader(new FileReader("main.csvol"));

    File currentFile = null;
    int lineNumber = 0;

    while(in.ready())
    {
      lineNumber++;
      String line = in.readLine();
      StringTokenizer tokenizer = new StringTokenizer(line, " ");
      String arg1 = tokenizer.nextToken();
      String arg2 = tokenizer.nextToken();
      String arg3 = tokenizer.nextToken();

      switch (arg1)
      {
        case "CREATE": //Create functions
          if (arg2.equals("FILE")) //Create file function       	
          {
            currentFile = new File(arg3 + ".csv");
            currentFile.createNewFile();
            currentFile = null;
          }
          //Code for functions

 
          break;
      	case "PULL": //Pull functions
          if (arg2.equals("FILE")) //Pull existing file function      	
          {
            currentFile = new File(arg3 + ".tdol");
          }
          //Code for functions

 
      		break;
      	case "DROP": //Drop function
		      currentFile = null;
      		break;
      	case "PRINT": //Print functions
          if (arg2.equals("ALL")) //Print all contents function    	
          {
            //Code for function
          }
          //Code for functions

 
      		break;
      	case "EDIT": //Edit functions
          //Code for functions

 
      		break;
      	case "DELETE": //Delete functions
          //Code for functions

 
      		break;
        default:
		      System.out.println("Error on line " + lineNumber);
      }
    }
  }
}