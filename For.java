import java.io.*;
import java.util.*;

public class For
{
  public static void max(ArrayList<String> args) throws Exception
  {
    /*
      For loop does not work in the terminal as the interpreter will try to reference back to a file's line number.
      Will fix!
    */
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