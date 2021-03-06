import java.io.*;
import java.util.*;
/*
  Need to organize this file.
*/
public class Edit
{
  public static BufferedReader inEdit;
  
  public static void file(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    Main.currentFile = new File((arguments.get(2)) + ".csv");
    inEdit = new BufferedReader(new FileReader((Main.currentFile).getName())); 
    if ((arguments.get(3)).equalsIgnoreCase("COLUMNS"))
    {
      columns(arguments);
    }
    if ((arguments.get(3)).equalsIgnoreCase("ROWS"))
    {
      rows(arguments);
    }
    if ((arguments.get(3)).equalsIgnoreCase("CELL"))
    {
      cell(arguments);
    }
  }
  public static void columns(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    if ((arguments.get(4)).equalsIgnoreCase("ADD"))
    {
      int columnsToAdd = 0;
      String columnsString = inEdit.readLine();
      PrintWriter outEdit = new PrintWriter(new FileWriter((Main.currentFile).getName()));
      for (int i = 5; i < arguments.size(); i++)
      {
        columnsString += (Main.delimeter + (arguments.get(i)));
        columnsToAdd++;
      }
      ArrayList<String> fileLines = new ArrayList<String>();
      fileLines.add(columnsString);
      String emptyCells = "";
      for (int i = 0; i < columnsToAdd; i++)
      {
        emptyCells+=Main.delimeter+"0";
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
    if ((arguments.get(4)).equalsIgnoreCase("DELETE"))
    {
      int minDomain = Integer.parseInt(arguments.get(5));
      int maxDomain = Integer.parseInt(arguments.get(6));
      String columnsString = inEdit.readLine();
      StringTokenizer tokenizerEdit = new StringTokenizer(columnsString, Main.delimeter);
      ArrayList<String> columnNames = new ArrayList<String>();
      while(tokenizerEdit.hasMoreTokens())
      {
        columnNames.add(tokenizerEdit.nextToken());
      }
      for (int i = maxDomain; i >= minDomain; i--)
      {
        columnNames.remove(i);
      }
      String newColumns = "";
      for (int i = 0; i < columnNames.size()-1; i++)
      {
        newColumns+=(columnNames.get(i)+Main.delimeter);
      }
      newColumns+=(columnNames.get(columnNames.size()-1));
      ArrayList<String> fileLines = new ArrayList<String>();
      fileLines.add(newColumns);
      while(inEdit.ready())
      {
        tokenizerEdit = new StringTokenizer(inEdit.readLine(), Main.delimeter);
        columnNames = new ArrayList<String>();
        while(tokenizerEdit.hasMoreTokens())
        {
          columnNames.add(tokenizerEdit.nextToken());
        }
        for (int i = maxDomain; i >= minDomain; i--)
        {
          columnNames.remove(i);
        }
        newColumns = "";
        for (int i = 0; i < columnNames.size()-1; i++)
        {
          newColumns+=(columnNames.get(i)+Main.delimeter);
        }
        newColumns+=(columnNames.get(columnNames.size()-1));
        fileLines.add(newColumns);
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
  public static void rows(ArrayList<String> args) throws Exception// 5:39pm 8/25
  {
    ArrayList<String> arguments = args;
    if ((arguments.get(4)).equalsIgnoreCase("ADD"))
    {
      ArrayList<String> fileLines = new ArrayList<String>();
      fileLines.add(inEdit.readLine());
      StringTokenizer tokenizerEdit = new StringTokenizer(fileLines.get(0), Main.delimeter);
      String emptyRow = "";
      while(tokenizerEdit.hasMoreTokens())
      {
        tokenizerEdit.nextToken();
        emptyRow+="0"+Main.delimeter;
      }
      emptyRow = emptyRow.substring(0,emptyRow.length()-1);
      while(inEdit.ready())
      {
        fileLines.add(inEdit.readLine());
      }
      int rowsToAdd = 0;
      if ((arguments.get(5)).equalsIgnoreCase("FILE"))
      {
        BufferedReader inFind = new BufferedReader(new FileReader((arguments.get(6))+".csv"));
        if ((arguments.get(7)).equalsIgnoreCase("CELL"))  
        {
          int columnPointer = Integer.parseInt(arguments.get(8));
          int rowPointer = Integer.parseInt(arguments.get(9));
          for (int i = 0; i < rowPointer; i++)
          {
            inFind.readLine();
          }
          StringTokenizer tokenizerFind = new StringTokenizer(inFind.readLine(), Main.delimeter);
          ArrayList<String> cellStrings = new ArrayList<String>();
          while(tokenizerFind.hasMoreTokens())
          {
            cellStrings.add(tokenizerFind.nextToken());
          }
          rowsToAdd = Integer.parseInt(cellStrings.get(columnPointer));
        }
      }
      else
      {
        rowsToAdd = Integer.parseInt(arguments.get(5));
      }
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
    if ((arguments.get(4)).equalsIgnoreCase("DELETE"))
    {
      int minRange = Integer.parseInt(arguments.get(5));
      int maxRange = Integer.parseInt(arguments.get(6));
      ArrayList<String> fileLines = new ArrayList<String>();
      for (int i = 0; i < minRange; i++)
      {
        fileLines.add(inEdit.readLine());
      }
      for (int i = minRange; i <= maxRange; i++)
      {
        inEdit.readLine();
      }
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
  public static void cell(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;

    int columnPointer = 0;
    int rowPointer = 0;
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
    switch(arguments.get(6))
    {
      case "FILE":
        BufferedReader inEdit = new BufferedReader(new FileReader((arguments.get(7))+".csv")); 
        if ((arguments.get(8)).equalsIgnoreCase("CELL"))  
        {
          int columnPointerFind = 0;
          int rowPointerFind = 0;
          try
          {
            columnPointerFind = Integer.parseInt(arguments.get(9));
          }
          catch(Exception e)
          {
            StringTokenizer tokenizerFind = new StringTokenizer(arguments.get(9), "#");
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
                int columnPointerFind2 = Integer.parseInt(subArguments.get(3));
                int rowPointerFind2 = Integer.parseInt(subArguments.get(4));
                for (int i = 0; i < rowPointerFind2; i++)
                {
                  inFind.readLine();
                }
                tokenizerFind = new StringTokenizer(inFind.readLine(), Main.delimeter);
                ArrayList<String> cellStrings = new ArrayList<String>();
                while(tokenizerFind.hasMoreTokens())
                {
                  cellStrings.add(tokenizerFind.nextToken());
                }
                columnPointerFind = Integer.parseInt(cellStrings.get(columnPointerFind2));
              }
            }
          }
          try
          {
            rowPointerFind = Integer.parseInt(arguments.get(10));
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
                int columnPointerFind2 = Integer.parseInt(subArguments.get(3));
                int rowPointerFind2 = Integer.parseInt(subArguments.get(4));
                for (int i = 0; i < rowPointerFind2; i++)
                {
                  inFind.readLine();
                }
                tokenizerFind = new StringTokenizer(inFind.readLine(), Main.delimeter);
                ArrayList<String> cellStrings = new ArrayList<String>();
                while(tokenizerFind.hasMoreTokens())
                {
                  cellStrings.add(tokenizerFind.nextToken());
                }
                rowPointerFind = Integer.parseInt(cellStrings.get(columnPointerFind2));
              }
            }
          }
          for (int i = 0; i < rowPointerFind; i++)
          {
            inEdit.readLine();
          }
          tokenizerEdit = new StringTokenizer(inEdit.readLine(), Main.delimeter);
          ArrayList<String> cellStrings = new ArrayList<String>();
          while(tokenizerEdit.hasMoreTokens())
          {
            cellStrings.add(tokenizerEdit.nextToken());
          }
          cellItem = cellStrings.get(columnPointerFind);
        }
        break;
      case "MATH":
        int number1 = 0;
        int number2 = 0;
        String operator = "";
        if ((arguments.get(7)).equalsIgnoreCase("FILE"))
        {
          inEdit = new BufferedReader(new FileReader((arguments.get(8))+".csv")); 
          if ((arguments.get(9)).equalsIgnoreCase("CELL"))  
          {
            int columnPointerFind = Integer.parseInt(arguments.get(10));
            int rowPointerFind = Integer.parseInt(arguments.get(11));
            for (int i = 0; i < rowPointerFind; i++)
            {
              inEdit.readLine();
            }
            tokenizerEdit = new StringTokenizer(inEdit.readLine(), Main.delimeter);
            ArrayList<String> cellStrings = new ArrayList<String>();
            while(tokenizerEdit.hasMoreTokens())
            {
              cellStrings.add(tokenizerEdit.nextToken());
            }
            number1 = Integer.parseInt(cellStrings.get(columnPointerFind));
            operator = arguments.get(12);
            if ((arguments.get(13)).equalsIgnoreCase("FILE"))
            {
              inEdit = new BufferedReader(new FileReader((arguments.get(14))+".csv")); 
              if ((arguments.get(15)).equalsIgnoreCase("CELL"))  
              {
                columnPointerFind = Integer.parseInt(arguments.get(16));
                rowPointerFind = Integer.parseInt(arguments.get(17));
                for (int i = 0; i < rowPointerFind; i++)
                {
                  inEdit.readLine();
                }
                tokenizerEdit = new StringTokenizer(inEdit.readLine(), Main.delimeter);
                cellStrings = new ArrayList<String>();
                while(tokenizerEdit.hasMoreTokens())
                {
                  cellStrings.add(tokenizerEdit.nextToken());
                }
                number2 = Integer.parseInt(cellStrings.get(columnPointerFind));
              }
            }
            else
            {
              number2 = Integer.parseInt(arguments.get(13));
            }
          }
        }
        else
        {
          number1 = Integer.parseInt(arguments.get(7));
          operator = arguments.get(8);
          if ((arguments.get(9)).equalsIgnoreCase("FILE"))
          {
            inEdit = new BufferedReader(new FileReader((arguments.get(10))+".csv")); 
            if ((arguments.get(11)).equalsIgnoreCase("CELL"))  
            {
              int columnPointerFind = Integer.parseInt(arguments.get(9));
              int rowPointerFind = Integer.parseInt(arguments.get(10));
              for (int i = 0; i < rowPointerFind; i++)
              {
                inEdit.readLine();
              }
              tokenizerEdit = new StringTokenizer(inEdit.readLine(), Main.delimeter);
              ArrayList<String> cellStrings = new ArrayList<String>();
              while(tokenizerEdit.hasMoreTokens())
              {
                cellStrings.add(tokenizerEdit.nextToken());
              }
              number2 = Integer.parseInt(cellStrings.get(columnPointerFind));
            }
          }
          else
          {
            number2 = Integer.parseInt(arguments.get(9));
          }
        }
        int answer = 0;
        switch(operator)
        {
          case "+":
            answer = number1 + number2;
            cellItem = Integer.toString(answer);
            break;
          case "-":
            answer = number1 - number2;
            cellItem = Integer.toString(answer);
            break;
          case "*":
            answer = number1 * number2;
            cellItem = Integer.toString(answer);
            break;
          case "/":
            answer = number1 / number2;
            cellItem = Integer.toString(answer);
            break;
          default:
            Terminal.error();
        }
        break;
      default:
        for (int i = 6; i < arguments.size()-1; i++)
        {
          cellItem += (arguments.get(i)).replace(Main.delimeter," ") + " ";
        }
        cellItem += (arguments.get(arguments.size()-1)).replace(Main.delimeter," ");
        break;
    }
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