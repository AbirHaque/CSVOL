import java.io.*;
import java.util.*;

public class Main
{
    public static String inString;
    public static BufferedReader in;
    public static PrintWriter out;
    public static File currentFile;
    public static int lineNumber;
    public static int mainLineNumber;
    public static int columnCount;
    public static int rowCount;
    public static int forMarker;
    public static int forMax;
    public static boolean isCommand;
    
  public static void main(String[] args) throws Exception
  {
    Terminal.start();

    inString = "main.csvol";
    in = new BufferedReader(new FileReader(inString));
    out = null;
    currentFile = null;
    lineNumber = 0;
    mainLineNumber = 0;
    columnCount = 0;
    rowCount = 0;
    forMarker = 0;
    forMax = 0;
    isCommand = false;

    while(in.ready()||isCommand==true)
    {
      if (isCommand == false)
      {
        lineNumber++;
        if (inString.equals("main.csvol"))
        {
          mainLineNumber++;
        }
      }
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
          case "IF":
            if ((arguments.get(1)).equals("FILE"))  
            {
              If.file(arguments);
            }
            break;
          case "FOR":
            if ((arguments.get(1)).equals("MAX"))  
            {
              For.max(arguments);
            }
          case "LOOP": //Prints function information
            Loop.fallBack();
            break;
          case "CREATE": //Create functions
            if ((arguments.get(1)).equals("FILE")) //Create file function       	
            {
              Create.file(arguments);
            }
            if ((arguments.get(1)).equals("COLUMNS")) //Create column function       	
            {
              Create.columns(arguments);
            }
            if ((arguments.get(1)).equals("ROWS")) //Create row function       	
            {
              Create.rows(arguments);
            }
            break;
          case "PULL": //Pull functions
            if ((arguments.get(1)).equals("FILE")) //Pull existing file function      	
            {
              Pull.file(arguments);
            }
            if ((arguments.get(1)).equals("REPL")) //Pull command function      	
            {
              Pull.repl();            
            }
            if ((arguments.get(1)).equals("OBJECT"))   	
            {
              Pull.object(arguments);            
            }
            if ((arguments.get(1)).equals("MAIN"))   	
            {
              Pull.main();
            }
            break;
          case "DROP": //Drop function
            if ((arguments.get(1)).equals("FILE")) //Drop current file function      	
            {
              Drop.file();
            }
            if ((arguments.get(1)).equals("REPL")) //Drop command function      	
            {
              Drop.repl();
            }
            break;
          case "PRINT": //Print functions
            if ((arguments.get(1)).equals("TEXT")) //Print text function    	
            {
              Print.text(arguments);
            }
            if ((arguments.get(1)).equals("FILE")) //Print all contents function.      	
            {
              Print.file(arguments);
            }  
            break;
          case "EDIT": 
            if ((arguments.get(1)).equals("FILE"))     	
              {
                Edit.file(arguments);
              }
              break;
          case "ADD": 
            Add.fallBack(arguments);
            break;
          case "DELETE": //Delete functions
            if ((arguments.get(1)).equals("FILE")) //Print all contents function.      	
            {
              Delete.file(arguments);
            }
            break;
          case "HELP": //Prints function information
            Help.fallBack();
            break;
          default:
            Terminal.error();
        }
      }
    }
    if (in != null)
    {
      in.close();
    }
    if (out != null)
    {
      out.close();
    }
  }
}