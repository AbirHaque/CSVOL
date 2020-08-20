import java.io.*;
import java.util.*;

public class Drop
{
  public static void file() throws Exception
  {
    Main.currentFile = null;
    (Main.out).close();
    Main.out = null;
    Main.columnCount = 0;
    Main.rowCount = 0;
  }
  public static void repl() throws Exception
  {
    Main.isCommand = false;
    Main.in = new BufferedReader(new FileReader(Main.inString));           
    for (int i = 0; i < Main.lineNumber; i++) 
    {
      (Main.in).readLine();
    }
    Main.columnCount = 0;
    Main.rowCount = 0;
  }
}