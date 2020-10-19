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
  public static boolean isCommand;
  public static String validation;
  public static String delimeter;

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
    

    isCommand = false;
    validation = "Not in conditional statement.";
    delimeter = ",";

    File mainFile = new File("main.csvol");
    if (mainFile.length() == 0)
    {
      PrintWriter outInitialize = new PrintWriter(mainFile.getName());
      outInitialize.println("PULL REPL");
      outInitialize.close();
    }

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
      String originalLine = line;
      if (line.equals("") == false)
      {
        line = (((((line).replace("{","")).replace("}","")).replace(",","")).replace("<~"," "));
        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        StringTokenizer originalTokenizer = new StringTokenizer(originalLine, " ");
        ArrayList<String> arguments = new ArrayList<String>();
        ArrayList<String> originalArguments = new ArrayList<String>();
        while(tokenizer.hasMoreTokens())
        {
          arguments.add(tokenizer.nextToken());
        }
        while(originalTokenizer.hasMoreTokens())
        {
          originalArguments.add(originalTokenizer.nextToken());
        }
        try
        {
          switch (arguments.get(0))
          {
            case "comment": case "COMMENT": //Add comments in code
              break;
            case "~":
              break;
            case "ensure": case "ENSURE":
              Ensure.fallBack(arguments);
              break;
            case "import": case "IMPORT":
              if ((arguments.get(1)).equalsIgnoreCase("LIBRARY"))  
              {
                Import.command(arguments);
              }
              if ((arguments.get(1)).equalsIgnoreCase("MODULE"))  
              {
                Import.module(arguments);
              }
              if ((arguments.get(1)).equalsIgnoreCase("FILE"))  
              {
                Import.file(arguments);
              }
              break;
           case "library": case "LIBRARY":
              Library.fallBack(arguments, originalArguments);
              break;
            case "if": case "IF":
              if (isCommand == true)
              {
                Terminal.disabled();
              }
              else
              {
                if ((arguments.get(1)).equalsIgnoreCase("FILE"))  
                {
                  If.file(arguments);
                }
              }
              break;
            case "conditional": case "CONDITIONAL":
              if (isCommand == true)
              {
                Terminal.disabled();
              }
              else
              {
                Conditional.fallBack();
              }
              break;
            case "create": case "CREATE": //Create functions
              if ((arguments.get(1)).equalsIgnoreCase("FILE")) //Create file function       	
              {
                Create.file(arguments);
              }
              if ((arguments.get(1)).equalsIgnoreCase("COLUMNS")) //Create column function       	
              {
                Create.columns(arguments);
              }
              if ((arguments.get(1)).equalsIgnoreCase("ROWS")) //Create row function       	
              {
                Create.rows(arguments);
              }
              break;
            case "pull": case "PULL": //Pull functions
              if ((arguments.get(1)).equalsIgnoreCase("FILE")) //Pull existing file function      	
              {
                Pull.file(arguments);
              }
              if ((arguments.get(1)).equalsIgnoreCase("REPL")) //Pull command function      	
              {
                if (isCommand == true)
                {
                  Terminal.disabled();
                }
                else
                {
                  Pull.repl();
                }           
              }
              if ((arguments.get(1)).equalsIgnoreCase("MODULE"))   	
              {
                Pull.module(arguments);            
              }
              if ((arguments.get(1)).equalsIgnoreCase("MAIN"))   	
              {
                if (isCommand == true)
                {
                  Terminal.disabled();
                }
                else
                {
                  Pull.main();
                }
              }
              break;
            case "drop": case "DROP": //Drop function
              if ((arguments.get(1)).equalsIgnoreCase("FILE")) //Drop current file function      	
              {
                Drop.file();
              }
              if ((arguments.get(1)).equalsIgnoreCase("REPL")) //Drop command function      	
              {
                Drop.repl();
              }
              break;
            case "print": case "PRINT": //Print functions
              if ((arguments.get(1)).equalsIgnoreCase("TEXT")) //Print text function    	
              {
                Print.text(arguments);
              }
              if ((arguments.get(1)).equalsIgnoreCase("FILE")) //Print all contents function.      	
              {
                Print.file(arguments);
              }  
              break;
            case "edit": case "EDIT": 
              if ((arguments.get(1)).equalsIgnoreCase("FILE"))     	
              {
                Edit.file(arguments);
              }
              break;
            case "add": case "ADD": 
              Add.fallBack(arguments);
              break;
            case "delete": case "DELETE": //Delete functions
              if ((arguments.get(1)).equalsIgnoreCase("FILE"))     	
              {
                Delete.file(arguments);
              }
              if ((arguments.get(1)).equalsIgnoreCase("LIBRARY"))  
              {
                Delete.command(arguments);
              }
              if ((arguments.get(1)).equalsIgnoreCase("MODULE"))  
              {
                Delete.module(arguments);
              }
              break;
            case "help": case "HELP": //Prints function information
              Help.fallBack();
              break;
            default:
              if (isCommand == true)
              {
                Terminal.terminalError();
              }
              else
              {
                Terminal.error();
              }
          }
        }
        catch(Exception e)
        {
          if (isCommand == true)
          {
            Terminal.terminalError();
          }
          else
          {
            Terminal.error();
          }
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