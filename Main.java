/*
  CSVOL Interpreter
*/

import java.io.*;
import java.util.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main
{
  public static void main(String[] args) throws Exception
  {
    System.out.println("CSVOL 1.0.0");
    System.out.println("Created by the Wichita Computer Programmers' Union");
    System.out.println();
    System.out.println("\tType \"PULL COMMAND\" in the main.csvol file to instruct through the command-line.");
    System.out.println("\tAlternatively, you may write instructions in the main.csvol file.");
    System.out.println();

    BufferedReader in = new BufferedReader(new FileReader("main.csvol"));
    PrintWriter out = null;
    File currentFile = null;
    int lineNumber = 0;
    int columnCount = 0;
    int rowCount = 0;
    boolean isCommand = false;

    while(in.ready()||isCommand==true)
    {
      if (isCommand == false)
      {
        lineNumber++;
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
          case "CREATE": //Create functions
            if ((arguments.get(1)).equals("FILE")) //Create file function       	
            {
              currentFile = new File((arguments.get(2)) + ".csv");
              currentFile.createNewFile();
              currentFile = null;
            }
            if ((arguments.get(1)).equals("COLUMNS")) //Create column function       	
            {
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
              for (int i = 0; i < Integer.parseInt(arguments.get(2)); i++)
              {
                for (int k = 0; k < columnCount; k++)
                {
                  out.print("0,");
                }
                out.print("0");
                out.println();
                rowCount++;
              }
            }
            break;
          case "PULL": //Pull functions
            if ((arguments.get(1)).equals("FILE")) //Pull existing file function      	
            {
              currentFile = new File((arguments.get(2)) + ".csv");
              String fileContents = Files.readString(Paths.get(currentFile.getName()));
              out = new PrintWriter(new FileWriter((arguments.get(2)) + ".csv"));
              if (isCommand == true)
              {
                out.print(fileContents);
              }
              columnCount = 0;
              rowCount = 0;
            }
            if ((arguments.get(1)).equals("COMMAND")) //Pull command function      	
            {
              System.out.println("\tType \"HELP\" for a list of commands and their usage.");
              System.out.println();
              in = new BufferedReader(new InputStreamReader(System.in)); 
              isCommand = true;     
              columnCount = 0;
              rowCount = 0;              
            }
            //Code for functions


            break;
          case "DROP": //Drop function
            if ((arguments.get(1)).equals("FILE")) //Drop current file function      	
            {
              currentFile = null;
              out.close();
              out = null;
              columnCount = 0;
              rowCount = 0;
            }
            if ((arguments.get(1)).equals("COMMAND")) //Drop command function      	
            {
              isCommand = false;
              in = new BufferedReader(new FileReader("main.csvol"));           
              for (int i = 0; i < lineNumber; i++) 
              {
                in.readLine();
              }
              columnCount = 0;
              rowCount = 0;
            }
            break;
          case "PRINT": //Print functions
            if ((arguments.get(1)).equals("TEXT")) //Print text function    	
            {
              for (int i = 2; i < arguments.size(); i++)
              {
                System.out.print((arguments.get(i)) + " ");
                columnCount++;
              }
              System.out.println();
            }
            if ((arguments.get(1)).equals("FILE")) //Print all contents function.      	
            {
              currentFile = new File((arguments.get(2)) + ".csv");
              String fileContents = Files.readString(Paths.get(currentFile.getName()));
              System.out.print(fileContents);
              System.out.println();
              currentFile = null;
            }
            //Code for functions

  
            break;
          case "EDIT": 
            if ((arguments.get(1)).equals("FILE"))     	
              {
                currentFile = new File((arguments.get(2)) + ".csv");
                BufferedReader inEdit = new BufferedReader(new FileReader(currentFile.getName())); 
                int columnPointer = Integer.parseInt(arguments.get(3));
                int rowPointer = Integer.parseInt(arguments.get(4));

                ArrayList<String> fileLines = new ArrayList<String>();
                for (int i = 0; i <= rowPointer; i++)
                {
                  fileLines.add(inEdit.readLine());
                }
                StringTokenizer tokenizerEdit = new StringTokenizer(fileLines.get(rowPointer), ",");
                ArrayList<String> rowElements = new ArrayList<String>();
                while(tokenizerEdit.hasMoreTokens())
                {
                  rowElements.add(tokenizerEdit.nextToken());
                }
                String cellItem = "";
                for (int i = 5; i < arguments.size()-1; i++)
                {
                  cellItem += (arguments.get(i)).replace(',',' ') + " ";
                }
                cellItem += (arguments.get(arguments.size()-1)).replace(',',' ');
                rowElements.set(columnPointer, cellItem);
                String editedLine = "";
                for (int i = 0; i < rowElements.size()-1; i++)
                {
                  editedLine += rowElements.get(i) + ",";
                }
                editedLine += rowElements.get(rowElements.size()-1);
                fileLines.set(rowPointer,editedLine);
                while(inEdit.ready())
                {
                  fileLines.add(inEdit.readLine());
                }
                PrintWriter outEdit = new PrintWriter(new FileWriter(currentFile.getName()));
                for (int i = 0; i < fileLines.size(); i++)
                {
                  outEdit.println(fileLines.get(i));
                }
                outEdit.close();
              }
              break;
          case "ADD": 
            out.flush();
            BufferedReader inEdit = new BufferedReader(new FileReader(currentFile.getName())); 
            int columnPointer = Integer.parseInt(arguments.get(1));
            int rowPointer = Integer.parseInt(arguments.get(2));
            ArrayList<String> fileLines = new ArrayList<String>();
            for (int i = 0; i <= rowPointer; i++)
            {
              fileLines.add(inEdit.readLine());
            }
            StringTokenizer tokenizerEdit = new StringTokenizer(fileLines.get(rowPointer), ",");
            ArrayList<String> rowElements = new ArrayList<String>();
            while(tokenizerEdit.hasMoreTokens())
            {
              rowElements.add(tokenizerEdit.nextToken());
            }
            String cellItem = "";
            for (int i = 3; i < arguments.size()-1; i++)
            {
              cellItem += (arguments.get(i)).replace(',',' ') + " ";
            }
            cellItem += (arguments.get(arguments.size()-1)).replace(',',' ');
            rowElements.set(columnPointer, cellItem);
            String editedLine = "";
            for (int i = 0; i < rowElements.size()-1; i++)
            {
              editedLine += rowElements.get(i) + ",";
            }
            editedLine += rowElements.get(rowElements.size()-1);
            fileLines.set(rowPointer,editedLine);
            while(inEdit.ready())
            {
              fileLines.add(inEdit.readLine());
            }
            PrintWriter outEdit = new PrintWriter(new FileWriter(currentFile.getName()));
            for (int i = 0; i < fileLines.size(); i++)
            {
              outEdit.println(fileLines.get(i));
            }
            outEdit.close();
            break;
          case "DELETE": //Delete functions
            if ((arguments.get(1)).equals("FILE")) //Print all contents function.      	
            {
              currentFile = new File((arguments.get(2)) + ".csv");
              currentFile.delete();
              currentFile = null;
            }
            //Code for functions


            break;
          case "HELP": //Prints function information
            System.out.println();
            System.out.println("CREATE [options] [args...] ---- Creates item dependent on option and args.");
            System.out.println("Where options include:");
            System.out.println("\tFILE [filename] ---- Creates empty file.");
            System.out.println("\tCOLUMNS [column1 column2 ... columni] ---- Creates column names.");
            System.out.println("\tROWS [number} ---- Creates rows. must create columns before rows.");
            System.out.println();
            System.out.println("PULL [options] [args...] ---- Sets current method of input/output.");
            System.out.println("Where options include:");
            System.out.println("\tFILE [filename] ---- Set dictated file to manipulate.");
            System.out.println("\tCOMMAND ---- Set command-line as method of command input.");
            System.out.println();
            System.out.println("DROP [options] ---- Nulls current method of input/output.");
            System.out.println("Where options include:");
            System.out.println("\tFILE ---- Nulls dictated file to manipulate.");
            System.out.println("\tCOMMAND ---- Ends command-line input.");
            System.out.println();
            System.out.println("PRINT [option] [arg] ---- Outputs item in command-line dependent on option and arg.");
            System.out.println("Where options include:");
            System.out.println("\tFILE [filename] ---- Outputs contents of file.");
            System.out.println("\tTEXT [text] ---- Outputs text.");
            System.out.println();
            System.out.println("COMMENT [text] ---- Creates comment on single line.");
            System.out.println();
       
            //Code for functions

  
            break;
          default:
            System.out.println("Error on line " + lineNumber);
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