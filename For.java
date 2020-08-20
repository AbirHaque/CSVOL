import java.io.*;
import java.util.*;

public class For
{
  public static void max(ArrayList<String> args) throws Exception
  {
    if (Main.isCommand == true)
    {
      Terminal.forLater();
    }
    else
    {
      ArrayList<String> arguments = args;
      int max = Integer.parseInt(arguments.get(2));
      Main.forMarker = Main.lineNumber;
      Main.forMax = max+1;
    }
  }
}