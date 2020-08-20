public class Terminal
{
  public static void start()
  {
    System.out.println("CSVOL 0.3.1");
    System.out.println("Created by the Wichita Computer Programmers' Union");
    System.out.println();
    System.out.println("\tType \"PULL REPL\" in the main.csvol file to instruct through the command-line.");
    System.out.println("\tAlternatively, you may write instructions in the main.csvol file.");
    System.out.println();
  }
  public static void repl()
  {
    System.out.println("\tType \"HELP\" for a list of commands and their usage.");
    System.out.println();
  }
  public static void error()
  {
    int errorLine = Main.lineNumber+1;
    System.out.println("Error on line " + errorLine + " in " + Main.inString);
  }
  public static void forLater()
  {
    System.out.println("For loops currently not functional in REPL environment.");
  }
}