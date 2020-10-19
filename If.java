import java.io.*;
import java.util.*;

public class If
{
  public static BufferedReader inEdit;
  public static StringTokenizer tokenizerEdit;
  public static ArrayList<String> cellStrings;
  public static int columnPointer;
  public static int rowPointer;
  public static String comparison1;
  public static String comparison2;
  public static void file(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    inEdit = new BufferedReader(new FileReader((arguments.get(2))+".csv")); 

    comparison1 = "";
    comparison2 = "";
    String context = "";

    if ((arguments.get(3)).equalsIgnoreCase("CELL"))  
    {
      columnPointer = 0;
      rowPointer = 0;
      try
      {
        columnPointer = Integer.parseInt(arguments.get(4));
      }
      catch(Exception e)
      {
        StringTokenizer tokenizerFind = new StringTokenizer(arguments.get(4), "#");
        ArrayList<String> subArguments = new ArrayList<String>();
        while(tokenizerFind.hasMoreTokens())
        {
          subArguments.add(tokenizerFind.nextToken());
        }
        if ((subArguments.get(0)).equalsIgnoreCase("FILE"))  
        {
          BufferedReader inFind = new BufferedReader(new FileReader((subArguments.get(1))+".csv"));
          if ((subArguments.get(2)).equalsIgnoreCase("CELL"))  
          {
            int columnPointerFind = Integer.parseInt(subArguments.get(3));
            int rowPointerFind = Integer.parseInt(subArguments.get(4));
            for (int i = 0; i < rowPointerFind; i++)
            {
              inFind.readLine();
            }
            tokenizerFind = new StringTokenizer(inFind.readLine(), Main.delimeter);
            ArrayList<String> cellStrings = new ArrayList<String>();
            while(tokenizerFind.hasMoreTokens())
            {
              cellStrings.add(tokenizerFind.nextToken());
            }
            columnPointer = Integer.parseInt(cellStrings.get(columnPointerFind));
          }
        }
      }
      try
      {
        rowPointer = Integer.parseInt(arguments.get(5));
      }
      catch(Exception e)
      {
        StringTokenizer tokenizerFind = new StringTokenizer(arguments.get(5), "#");
        ArrayList<String> subArguments = new ArrayList<String>();
        while(tokenizerFind.hasMoreTokens())
        {
          subArguments.add(tokenizerFind.nextToken());
        }
        if ((subArguments.get(0)).equalsIgnoreCase("FILE"))  
        {
          BufferedReader inFind = new BufferedReader(new FileReader((subArguments.get(1))+".csv"));
          if ((subArguments.get(2)).equalsIgnoreCase("CELL"))  
          {
            int columnPointerFind = Integer.parseInt(subArguments.get(3));
            int rowPointerFind = Integer.parseInt(subArguments.get(4));
            for (int i = 0; i < rowPointerFind; i++)
            {
              inFind.readLine();
            }
            tokenizerFind = new StringTokenizer(inFind.readLine(), Main.delimeter);
            ArrayList<String> cellStrings = new ArrayList<String>();
            while(tokenizerFind.hasMoreTokens())
            {
              cellStrings.add(tokenizerFind.nextToken());
            }
            rowPointer = Integer.parseInt(cellStrings.get(columnPointerFind));
          }
        }
      }
      for (int i = 0; i < rowPointer; i++)
      {
        inEdit.readLine();
      }
      tokenizerEdit = new StringTokenizer(inEdit.readLine(), Main.delimeter);
      cellStrings = new ArrayList<String>();
      while(tokenizerEdit.hasMoreTokens())
      {
        cellStrings.add(tokenizerEdit.nextToken());
      }
      comparison1 = cellStrings.get(columnPointer);
      switch (arguments.get(6))  
      {
        case "=":
          context = "=";
          getValues(arguments);
          break;
        case "!=":
          context = "!=";
          getValues(arguments);
          break;
        case ">":
          context = ">";
          getValues(arguments);
          break;
        case "<":
          context = "<";
          getValues(arguments);
          break;
        case ">=":
          context = ">=";
          getValues(arguments);
          break;
        case "<=":
          context = "<=";
          getValues(arguments);
          break;
        default:
          Terminal.error();
      }
    }
    switch (context)  
    {
      case "=":
        if (comparison1.equals(comparison2))
        {
          Main.validation = "true";
        }
        else
        {
          Main.validation = "false";
        }
        break;
      case "!=":
        if (comparison1.equals(comparison2) == false)
        {
          Main.validation = "true";
        }
        else
        {
          Main.validation = "false";
        }
        break;
      case ">":
        if (Integer.parseInt(comparison1) > Integer.parseInt(comparison2))
        {
          Main.validation = "true";
        }
        else
        {
          Main.validation = "false";
        }
        break;
      case "<":
        if (Integer.parseInt(comparison1) < Integer.parseInt(comparison2))
        {
          Main.validation = "true";
        }
        else
        {
          Main.validation = "false";
        }
        break;
      case ">=":
        if (Integer.parseInt(comparison1) >= Integer.parseInt(comparison2))
        {
          Main.validation = "true";
        }
        else
        {
          Main.validation = "false";
        }
        break;
      case "<=":
        if (Integer.parseInt(comparison1) <= Integer.parseInt(comparison2))
        {
          Main.validation = "true";
        }
        else
        {
          Main.validation = "false";
        }
        break;
      default:
        Terminal.error();
    }
    if ((Main.validation).equals("false"))
    {
      //Skip to CONDITIONAL
      boolean loop = true;
      while (loop == true)
      {
        String line = (Main.in).readLine();
        Main.lineNumber++;
        if(line.equalsIgnoreCase("CONDITIONAL"))
        {
          loop = false;
          Main.validation = "Not in conditional statement.";
        }
      }
    }
  }
  public static void getValues(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    if ((arguments.get(7)).equalsIgnoreCase("FILE"))  
    {
      inEdit = new BufferedReader(new FileReader((arguments.get(8))+".csv"));
      if ((arguments.get(9)).equalsIgnoreCase("CELL"))  
      {
        columnPointer = 0;
        rowPointer = 0;
        try
        {
          columnPointer = Integer.parseInt(arguments.get(10));
        }
        catch(Exception e)
        {
          StringTokenizer tokenizerFind = new StringTokenizer(arguments.get(10), "#");
          ArrayList<String> subArguments = new ArrayList<String>();
          while(tokenizerFind.hasMoreTokens())
          {
            subArguments.add(tokenizerFind.nextToken());
          }
          if ((subArguments.get(0)).equalsIgnoreCase("FILE"))  
          {
            BufferedReader inFind = new BufferedReader(new FileReader((subArguments.get(1))+".csv"));
            if ((subArguments.get(2)).equalsIgnoreCase("CELL"))  
            {
              int columnPointerFind = Integer.parseInt(subArguments.get(3));
              int rowPointerFind = Integer.parseInt(subArguments.get(4));
              for (int i = 0; i < rowPointerFind; i++)
              {
                inFind.readLine();
              }
              tokenizerFind = new StringTokenizer(inFind.readLine(), Main.delimeter);
              ArrayList<String> cellStrings = new ArrayList<String>();
              while(tokenizerFind.hasMoreTokens())
              {
                cellStrings.add(tokenizerFind.nextToken());
              }
              columnPointer = Integer.parseInt(cellStrings.get(columnPointerFind));
            }
          }
        }
        try
        {
          rowPointer = Integer.parseInt(arguments.get(11));
        }
        catch(Exception e)
        {
          StringTokenizer tokenizerFind = new StringTokenizer(arguments.get(11), "#");
          ArrayList<String> subArguments = new ArrayList<String>();
          while(tokenizerFind.hasMoreTokens())
          {
            subArguments.add(tokenizerFind.nextToken());
          }
          if ((subArguments.get(0)).equalsIgnoreCase("FILE"))  
          {
            BufferedReader inFind = new BufferedReader(new FileReader((subArguments.get(1))+".csv"));
            if ((subArguments.get(2)).equalsIgnoreCase("CELL"))  
            {
              int columnPointerFind = Integer.parseInt(subArguments.get(3));
              int rowPointerFind = Integer.parseInt(subArguments.get(4));
              for (int i = 0; i < rowPointerFind; i++)
              {
                inFind.readLine();
              }
              tokenizerFind = new StringTokenizer(inFind.readLine(), Main.delimeter);
              ArrayList<String> cellStrings = new ArrayList<String>();
              while(tokenizerFind.hasMoreTokens())
              {
                cellStrings.add(tokenizerFind.nextToken());
              }
              rowPointer = Integer.parseInt(cellStrings.get(columnPointerFind));
            }
          }
        }
        for (int i = 0; i < rowPointer; i++)
        {
          inEdit.readLine();
        }
        tokenizerEdit = new StringTokenizer(inEdit.readLine(), Main.delimeter);
        cellStrings = new ArrayList<String>();
        while(tokenizerEdit.hasMoreTokens())
        {
          cellStrings.add(tokenizerEdit.nextToken());
        }
        comparison2 = cellStrings.get(columnPointer);
      }
    }
    if ((arguments.get(7)).equalsIgnoreCase("TEXT"))  
    {
      for (int i = 8; i < arguments.size()-1; i++)
      {
        comparison2+= arguments.get(i) + " ";
      }
      comparison2+= arguments.get(arguments.size()-1);
    }
  }
}