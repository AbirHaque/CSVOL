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
  public static void module(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    Main.currentFile = new File((arguments.get(2)) + ".csvol");
    Main.currentFile.delete();
    Main.currentFile = null;
  }
  public static void command(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    File commandToDelete = new File(args.get(2)+ ".java");
    File commandClassToDelete = new File(args.get(2) + ".class");
    File commandGUIClassToDelete = new File(args.get(2) + "$1.class");
    commandToDelete.delete();
    commandClassToDelete.delete();
    commandGUIClassToDelete.delete();
  }
}