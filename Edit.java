import java.io.*;
import java.util.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Edit
{
  public static BufferedReader inEdit;
  
  public static void file(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    Main.currentFile = new File((arguments.get(2)) + ".csv");
    inEdit = new BufferedReader(new FileReader((Main.currentFile).getName())); 
    if ((arguments.get(3)).equals("COLUMNS"))
    {
      columns(arguments);
    }
    if ((arguments.get(3)).equals("ROWS"))
    {
      rows(arguments);
    }
    if ((arguments.get(3)).equals("ROWS") == false && (arguments.get(3)).equals("COLUMNS") == false)
    {
      fallBack(arguments);
    }
  }
  public static void columns(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    if ((arguments.get(4)).equals("ADD"))
    {
      int columnsToAdd = 0;
      String columnsString = inEdit.readLine();
      PrintWriter outEdit = new PrintWriter(new FileWriter((Main.currentFile).getName()));
      for (int i = 5; i < arguments.size(); i++)
      {
        columnsString += ("," + (arguments.get(i)));
        columnsToAdd++;
      }
      ArrayList<String> fileLines = new ArrayList<String>();
      fileLines.add(columnsString);
      String emptyCells = "";
      for (int i = 0; i < columnsToAdd; i++)
      {
        emptyCells+=",0";
      }
      while(inEdit.ready())
      {
        fileLines.add(inEdit.readLine()+emptyCells);
      }
      for (int i = 0; i < fileLines.size(); i++)
      {
        outEdit.println(fileLines.get(i));
      }
      inEdit.close();
      outEdit.close();
    }
    if ((arguments.get(4)).equals("DELETE"))
    {
      
    }
  }
  public static void rows(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    if ((arguments.get(4)).equals("ADD"))
    {
      ArrayList<String> fileLines = new ArrayList<String>();
      fileLines.add(inEdit.readLine());
      StringTokenizer tokenizerEdit = new StringTokenizer(fileLines.get(0), ",");
      String emptyRow = "";
      while(tokenizerEdit.hasMoreTokens())
      {
        tokenizerEdit.nextToken();
        emptyRow+="0,";
      }
      emptyRow = emptyRow.substring(0,emptyRow.length()-1);
      while(inEdit.ready())
      {
        fileLines.add(inEdit.readLine());
      }
      int rowsToAdd = Integer.parseInt(arguments.get(5));
      PrintWriter outEdit = new PrintWriter(new FileWriter((Main.currentFile).getName()));
      for (int i = 0; i < fileLines.size(); i++)
      {
        outEdit.println(fileLines.get(i));
      }
      for (int i = 0; i < rowsToAdd; i++)
      {
        outEdit.println(emptyRow);
      }
      inEdit.close();
      outEdit.close();
    }
    if ((arguments.get(4)).equals("DELETE"))
    {

    }
  }
  public static void fallBack(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
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
    PrintWriter outEdit = new PrintWriter(new FileWriter((Main.currentFile).getName()));
    for (int i = 0; i < fileLines.size(); i++)
    {
      outEdit.println(fileLines.get(i));
    }
    inEdit.close();
    outEdit.close();
  }
}