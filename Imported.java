import java.util.*;
import java.lang.reflect.*;

public class Imported
{
  public static void fallBack(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    Runtime.getRuntime().exec("javac " + arguments.get(1)+".java");
    Class command = Class.forName(arguments.get(1)); 
    Method mainMethod = command.getMethod("main", ArrayList.class);
    Object commandInstance = command.newInstance();
    mainMethod.invoke(commandInstance,arguments);
  }
}