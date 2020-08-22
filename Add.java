import java.io.*;
import java.util.*;

public class Add
{
  public static void fallBack(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    BufferedReader inEdit = new BufferedReader(new FileReader((Main.currentFile).getName())); 
    int columnPointer = Integer.parseInt(arguments.get(1));
    int rowPointer = Integer.parseInt(arguments.get(2));
    ArrayList<String> fileLines = new ArrayList<String>();
    for (int i = 0; i <= rowPointer; i++)
    {
      fileLines.add(inEdit.readLine());
    }
    StringTokenizer tokenizerEdit = new StringTokenizer(fileLines.get(rowPointer), Main.delimeter);
    ArrayList<String> rowElements = new ArrayList<String>();
    while(tokenizerEdit.hasMoreTokens())
    {
      rowElements.add(tokenizerEdit.nextToken());
    }
    String cellItem = "";
    for (int i = 3; i < arguments.size()-1; i++)
    {
      cellItem += (arguments.get(i)).replace(Main.delimeter," ") + " ";
    }
    cellItem += (arguments.get(arguments.size()-1)).replace(Main.delimeter," ");
    rowElements.set(columnPointer, cellItem);
    String editedLine = "";
    for (int i = 0; i < rowElements.size()-1; i++)
    {
      editedLine += rowElements.get(i) + Main.delimeter;
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