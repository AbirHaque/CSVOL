public class Terminal
{
  public static void start()
  {
    System.out.println("");
    System.out.println("CSVOL 21_0.1.0.");
    System.out.println("Copyright (C) 2020 Abir Haque.");
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
  public static void libraryEnsured()
  {
    System.out.println("Library exists."); }
 public static void libraryNotEnsured(){System.out.println("Library does not exist or has not been imported.");} public static void done()
  {
    System.out.println("Done!");
  }
}