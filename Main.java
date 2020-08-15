/*
  CSVOL Interpreter
*/

import java.io.*;
import java.util.*;

public class Main
{
  public static void main(String[] args) throws Exception
  {
    BufferedReader in = new BufferedReader(new FileReader("main.csvol"));
    PrintWriter out = null;
    File currentFile = null;
    int lineNumber = 0;
    int columnCount = 0;
    int rowCount = 0;

    while(in.ready())
    {
      lineNumber++;
      String line = in.readLine();
      if (line.equals("") == false)
      {
        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        ArrayList<String> arguments = new ArrayList<String>();
        while(tokenizer.hasMoreTokens())
        {
          arguments.add(tokenizer.nextToken());
        }
        switch (arguments.get(0))
        {
          case "COMMENT": //Add comments in code
            break;
          case "CREATE": //Create functions
            if ((arguments.get(1)).equals("FILE")) //Create file function       	
            {
              currentFile = new File((arguments.get(2)) + ".csv");
              currentFile.createNewFile();
              currentFile = null;
            }
            if ((arguments.get(1)).equals("COLUMNS")) //Create column function       	
            {
              out.print(",");
              for (int i = 2; i < arguments.size()-1; i++)
              {
                out.print((arguments.get(i)) + ",");
                columnCount++;
              }
              out.print((arguments.get(arguments.size()-1)));
              out.println();
            }
            if ((arguments.get(1)).equals("ROWS")) //Create row function       	
            {
              for (int i = 2; i < arguments.size(); i++)
              {
                out.print((arguments.get(i)));
                for (int k = 0; k <= columnCount; k++)
                {
                  out.print(",");
                }
                out.println();
                rowCount++;
              }
            }
            break;
          case "PULL": //Pull functions
            if ((arguments.get(1)).equals("FILE")) //Pull existing file function      	
            {
              currentFile = new File((arguments.get(2)) + ".csv");
              out = new PrintWriter(new FileWriter((arguments.get(2)) + ".csv"));
            }
            //Code for functions

  
            break;
          case "DROP": //Drop function
            currentFile = null;
            out.close();
            out = null;
            columnCount = 0;
            rowCount = 0;
            break;
          case "PRINT": //Print functions
            if ((arguments.get(1)).equals("ALL")) //Print all contents function    	
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
    in.close();
    if (out != null)
    {
      out.close();
    }
  }
}