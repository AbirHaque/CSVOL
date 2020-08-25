public class Terminal
{
  public static void start()
  {
    System.out.println("CSVOL Copyright (C) 2020 Abir Haque.");
    System.out.println();
    System.out.println("CSVOL 0.8.1.");
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
    System.out.println("Invalid terminal input.");
  }
  public static void disabled()
  {
    System.out.println("The CSVOL REPL environment is still under development, so this command is disabled. You can still use this command in a CSVOL file.");
  }
  public static void solLoading()
  {
    System.out.println("Please wait. Accessing CSVOL's Standard Online Library . . . ");
  }
  public static void directoryLoading()
  {
    System.out.println("Please wait. Accessing directory . . . ");
  }
  public static void libraryLoading()
  {
    System.out.println("Please wait. Importing library . . . ");
  }
  public static void libraryError()
  {
    System.out.println("Failed to retrieve library");
  }
  public static void done()
  {
    System.out.println("Done!");
  }
}