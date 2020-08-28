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
  public static String validation;
  public static String delimeter;
  public static ArrayList<String> importedCommands;

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
    validation = "Not in conditional statement.";
    delimeter = ",";
    importedCommands = new ArrayList<String>();

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
            case "COMMENT": //Add comments in code
              break;
            case "~":
              break;
            case "ENSURE":
              Ensure.fallBack(arguments);
              break;
            case "IMPORT":
              if ((arguments.get(1)).equals("COMMAND"))  
              {
                Import.command(arguments);
              }
              if ((arguments.get(1)).equals("MODULE"))  
              {
                Import.module(arguments);
              }
              if ((arguments.get(1)).equals("FILE"))  
              {
                Import.file(arguments);
              }
              break;
            case "IMPORTED":
              Imported.fallBack(arguments, originalArguments);
              break;
            case "IF":
              if (isCommand == true)
              {
                Terminal.disabled();
              }
              else
              {
                if ((arguments.get(1)).equals("FILE"))  
                {
                  If.file(arguments);
                }
              }
              break;
            case "CONDITIONAL":
              if (isCommand == true)
              {
                Terminal.disabled();
              }
              else
              {
                Conditional.fallBack();
              }
              break;
            case "FOR":
              if (isCommand == true)
              {
                Terminal.disabled();
              }
              else
              {
                if ((arguments.get(1)).equals("MAX"))  
                {
                  For.max(arguments);
                }
              }
            case "LOOP":
              if (isCommand == true)
              {
                Terminal.disabled();
              }
              else
              {
                Loop.fallBack();
              }
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
                if (isCommand == true)
                {
                  Terminal.disabled();
                }
                else
                {
                  Pull.repl();
                }           
              }
              if ((arguments.get(1)).equals("MODULE"))   	
              {
                Pull.module(arguments);            
              }
              if ((arguments.get(1)).equals("MAIN"))   	
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
    for (int i = importedCommands.size()-1; i >= 0; i--)
    {
      File commandToDelete = new File(importedCommands.get(i)+ ".java");
      File commandClassToDelete = new File(importedCommands.get(i) + ".class");
      File commandGUIClassToDelete = new File(importedCommands.get(i) + "$1.class");
      commandToDelete.delete();
      commandClassToDelete.delete();
      commandGUIClassToDelete.delete();
    }
  }
}