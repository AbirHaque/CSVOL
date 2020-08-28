public class Terminal
{
  public static void start()
  {
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("CSVOL 0.9.4.");
    System.out.println("CSVOL Copyright (C) 2020 Abir Haque.");
    System.out.println("Developed by the Wichita Computer Programmers' Union.");
    System.out.println();
  }
  public static void repl()
  {
    System.out.println("REPL enabled.");
    System.out.println("Type \"HELP\" for a list of commands and their usage.");
    System.out.println();
  }
  public static void error()
  {
    int errorLine = Main.lineNumber;
    System.out.println("CSVOL error ~> File " + Main.inString + " ~> Line " + errorLine+ ".");
    System.exit(0);
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
    System.out.println("Failed to retrieve library.");
  }
  public static void libraryEnsure()
  {
    System.out.println("You have ensured the existence of the library.");
    System.out.println("Re-run the program to proceed.");
    System.exit(0);
  }
  public static void done()
  {
    System.out.println("Done!");
  }
}