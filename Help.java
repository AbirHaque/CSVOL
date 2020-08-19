public class Help
{
  public static void fallBack()
  {
    System.out.println();
    System.out.println("CREATE [options] [args...] ---- Creates item dependent on option and args.");
    System.out.println("Where options include:");
    System.out.println("\tFILE [filename] ---- Creates empty file.");
    System.out.println("\tCOLUMNS [column1 column2 ... columni] ---- Creates column names.");
    System.out.println("\tROWS [number} ---- Creates rows. must create columns before rows.");
    System.out.println();
    System.out.println("PULL [options] [args...] ---- Sets current method of input/output.");
    System.out.println("Where options include:");
    System.out.println("\tFILE [filename] ---- Set dictated file to manipulate.");
    System.out.println("\tREPL ---- Set command-line as method of command input.");
    System.out.println();
    System.out.println("DROP [options] ---- Nulls current method of input/output.");
    System.out.println("Where options include:");
    System.out.println("\tFILE ---- Nulls dictated file to manipulate.");
    System.out.println("\tREPL ---- Ends command-line input.");
    System.out.println();
    System.out.println("PRINT [option] [arg] ---- Outputs item in command-line dependent on option and arg.");
    System.out.println("Where options include:");
    System.out.println("\tFILE [filename] ---- Outputs contents of file.");
    System.out.println("\tTEXT [text] ---- Outputs text.");
    System.out.println();
    System.out.println("COMMENT [text] ---- Creates comment on single line.");
    System.out.println();
  }
}