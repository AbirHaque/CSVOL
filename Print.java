import java.io.*;
import java.util.*;

public class Print
{
  public static void text(ArrayList<String> args)
  {
    ArrayList<String> arguments = args;
    for (int i = 2; i < arguments.size(); i++)
    {
      System.out.print((arguments.get(i)) + " ");
    }
    System.out.println();
  }
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
    for (int i = 0; i < fileLines.size(); i++)
    {
      System.out.println(fileLines.get(i));
    }
    inEdit.close();    
    Main.currentFile = null;
  }
}