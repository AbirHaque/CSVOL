import java.util.*;
import java.lang.reflect.*;

public class Library{
  public static void fallBack(ArrayList<String> args, ArrayList<String> originalArgs) throws Exception
  {
    ArrayList<String> arguments = args;
    ArrayList<String> originalArguments = originalArgs;
    Runtime.getRuntime().exec("javac " + arguments.get(1) + ".java");
    Class command = Class.forName(arguments.get(1)); 
    Method mainMethod = command.getMethod("main", ArrayList.class, ArrayList.class);
    Object commandInstance = command.newInstance();
    mainMethod.invoke(commandInstance,arguments,originalArguments);
  }
}