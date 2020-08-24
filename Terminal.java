public class Terminal
{
  public static void start()
  {
    System.out.println("CSVOL Copyright (C) 2020 Abir Haque.");
    System.out.println();
    System.out.println("CSVOL Version 0.8.0.");
    System.out.println("Created by the Wichita Computer Programmers' Union.");
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
    System.out.println("Error on line " + errorLine + " in " + Main.inString + ".");
  }
  public static void terminalError()
  {
    System.out.println("Invalid syntax.");
  }
  public static void disabled()
  {
    System.out.println("The CSVOL REPL environment is still under development, so this command is disabled. You can still use this command in a CSVOL file.");
  }
  public static void libraryError()
  {
    System.out.println("Failed to retrieve library");
  }
}