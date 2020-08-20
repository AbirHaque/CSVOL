import java.io.*;
import java.util.*;

public class Loop
{
  public static void fallBack() throws Exception
  {
    Main.forMax--;
    if (Main.forMax == 0)
    {
      Main.in = new BufferedReader(new FileReader(Main.inString));
      for (int i = 0; i <= Main.lineNumber; i++) 
      {
        (Main.in).readLine();
      }
    }
    else
    {
      Main.in = new BufferedReader(new FileReader(Main.inString)); 
      for (int i = 0; i < Main.forMarker; i++) 
      {
        (Main.in).readLine();
      }  
      Main.columnCount = 0;
      Main.rowCount = 0;
      Main.lineNumber = 0;
    }
  }
}