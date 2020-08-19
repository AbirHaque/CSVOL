import java.io.*;
import java.util.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Print
{
  public static void text(ArrayList<String> args)
  {
    ArrayList<String> arguments = args;
    for (int i = 2; i < arguments.size(); i++)
    {
      System.out.print((arguments.get(i)) + " ");
    }
    System.out.println();
  }
  public static void file(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    Main.currentFile = new File((arguments.get(2)) + ".csv");
    String fileContents = Files.readString(Paths.get((Main.currentFile).getName()));
    System.out.print(fileContents);
    System.out.println();
    Main.currentFile = null;
  }
}