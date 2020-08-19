public class Terminal
{
  public static void start()
  {
    System.out.println("CSVOL 1.0.0");
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
    System.out.println("Error on line " + Main.lineNumber);
  }
}