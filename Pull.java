import java.io.*;
import java.util.*;

public class Pull
{
  public static void file(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    Main.currentFile = new File((arguments.get(2)) + ".csv");
    BufferedReader inEdit = new BufferedReader(new FileReader((Main.currentFile).getName())); 
    ArrayList<String> fileLines = new ArrayList<String>();
    while(inEdit.ready())
    {
      fileLines.add(inEdit.readLine());
    }
    inEdit.close(); 

    Main.out = new PrintWriter(new FileWriter((arguments.get(2)) + ".csv"));
    if (Main.isCommand == true)
    {
      for (int i = 0; i < fileLines.size(); i++)
      {
        (Main.out).println(fileLines.get(i));
      }
    }
    Main.columnCount = 0;
    Main.rowCount = 0;
  }
  public static void repl() throws Exception
  {
    Terminal.repl();
    Main.in = new BufferedReader(new InputStreamReader(System.in)); 
    Main.isCommand = true;     
    Main.columnCount = 0;
    Main.rowCount = 0; 
  }
  public static void module(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    Main.inString = arguments.get(2) + ".csvol";
    Main.in = new BufferedReader(new FileReader(Main.inString)); 
    Main.isCommand = false;     
    Main.columnCount = 0;
    Main.rowCount = 0; 
    Main.lineNumber = 0;
  }
  public static void main() throws Exception
  {
    Main.inString = "main.csvol";
    Main.in = new BufferedReader(new FileReader(Main.inString)); 
    for (int i = 0; i < Main.mainLineNumber; i++) 
    {
      (Main.in).readLine();
    }
    Main.isCommand = false;   
    Main.columnCount = 0;
    Main.rowCount = 0;
    Main.lineNumber = 0;
  }
}