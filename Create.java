import java.io.*;
import java.util.*;

public class Create
{
  public static void file(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    Main.currentFile = new File((arguments.get(2)) + ".csv");
    (Main.currentFile).createNewFile();
    Main.currentFile = null;
  }
  public static void columns(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    for (int i = 2; i < arguments.size()-1; i++)
    {
      (Main.out).print((arguments.get(i)) + ",");
      Main.columnCount++;
    }
    (Main.out).print((arguments.get(arguments.size()-1)));
    (Main.out).println();
  }
  public static void rows(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    for (int i = 0; i < Integer.parseInt(arguments.get(2)); i++)
    {
      for (int k = 0; k < Main.columnCount; k++)
      {
        (Main.out).print("0,");
      }
      (Main.out).print("0");
      (Main.out).println();
      Main.rowCount++;
    }
    (Main.out).close();
  }
}