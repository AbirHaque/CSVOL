import java.io.*;
import java.util.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Pull
{
  public static void file(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    Main.currentFile = new File((arguments.get(2)) + ".csv");
    String fileContents = Files.readString(Paths.get((Main.currentFile).getName()));
    Main.out = new PrintWriter(new FileWriter((arguments.get(2)) + ".csv"));
    if (Main.isCommand == true)
    {
      (Main.out).print(fileContents);
    }
    Main.columnCount = 0;
    Main.rowCount = 0;
  }
  public static void repl() throws Exception
  {
    Terminal.repl();
    Main.in = new BufferedReader(new InputStreamReader(System.in)); 
    Main.isCommand = true;     
    Main.columnCount = 0;
    Main.rowCount = 0; 
  }
}