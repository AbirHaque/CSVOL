import java.io.*;
import java.util.*;

public class Delete
{
  public static void file(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    Main.currentFile = new File((arguments.get(2)) + ".csv");
    Main.currentFile.delete();
    Main.currentFile = null;
  }
}