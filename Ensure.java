import java.io.*;
import java.util.*;

public class Ensure
{
  public static void fallBack(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    File file = new File(arguments.get(1)+".class");
    if (file.exists())
    {
           Terminal.libraryEnsured();
    }
else{Terminal.libraryNotEnsured();}  }
}