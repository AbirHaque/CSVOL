import java.io.*;
import java.util.*;

public class If
{
  public static void file(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    BufferedReader inEdit = new BufferedReader(new FileReader((arguments.get(2))+".csv")); 

    String comparison1 = "";
    String comparison2 = "";
    boolean context = false;

    if ((arguments.get(3)).equals("CELL"))  
    {
      int columnPointer = Integer.parseInt(arguments.get(4));
      int rowPointer = Integer.parseInt(arguments.get(5));
      for (int i = 0; i < rowPointer; i++)
      {
        inEdit.readLine();
      }
      StringTokenizer tokenizerEdit = new StringTokenizer(inEdit.readLine(), ",");
      ArrayList<String> cellStrings = new ArrayList<String>();
      while(tokenizerEdit.hasMoreTokens())
      {
        cellStrings.add(tokenizerEdit.nextToken());
      }
      comparison1 = cellStrings.get(columnPointer);
      if ((arguments.get(6)).equals("="))  
      {
        context = true;
        if ((arguments.get(7)).equals("FILE"))  
        {
          inEdit = new BufferedReader(new FileReader((arguments.get(8))+".csv"));
          if ((arguments.get(9)).equals("CELL"))  
          {
            columnPointer = Integer.parseInt(arguments.get(10));
            rowPointer = Integer.parseInt(arguments.get(11));
            for (int i = 0; i < rowPointer; i++)
            {
              inEdit.readLine();
            }
            tokenizerEdit = new StringTokenizer(inEdit.readLine(), ",");
            cellStrings = new ArrayList<String>();
            while(tokenizerEdit.hasMoreTokens())
            {
              cellStrings.add(tokenizerEdit.nextToken());
            }
            comparison2 = cellStrings.get(columnPointer);
          }
        }
        if ((arguments.get(7)).equals("TEXT"))  
        {
          for (int i = 8; i < arguments.size()-1; i++)
          {
            comparison2+= arguments.get(i) + " ";
          }
          comparison2+= arguments.get(arguments.size()-1);
        }
      }
      if ((arguments.get(6)).equals("!="))  
      {
        context = false;
        if ((arguments.get(7)).equals("FILE"))  
        {
          inEdit = new BufferedReader(new FileReader((arguments.get(8))+".csv"));
          if ((arguments.get(9)).equals("CELL"))  
          {
            columnPointer = Integer.parseInt(arguments.get(10));
            rowPointer = Integer.parseInt(arguments.get(11));
            for (int i = 0; i < rowPointer; i++)
            {
              inEdit.readLine();
            }
            tokenizerEdit = new StringTokenizer(inEdit.readLine(), ",");
            cellStrings = new ArrayList<String>();
            while(tokenizerEdit.hasMoreTokens())
            {
              cellStrings.add(tokenizerEdit.nextToken());
            }
            comparison2 = cellStrings.get(columnPointer);
          }
        }
        if ((arguments.get(7)).equals("TEXT"))  
        {
          for (int i = 8; i < arguments.size()-1; i++)
          {
            comparison2+= arguments.get(i) + " ";
          }
          comparison2+= arguments.get(arguments.size()-1);
        }
      }
    }
    if (context == true)
    {
      if (comparison1.equals(comparison2))
      {
        System.out.println("TRUE");
      }
      else
      {
        System.out.println("FALSE");
      }
    }
    if (context == false)
    {
      if (comparison1.equals(comparison2) == false)
      {
        System.out.println("TRUE");
      }
      else
      {
        System.out.println("FALSE");
      }
    }
  }
}