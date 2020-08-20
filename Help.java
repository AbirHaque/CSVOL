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
    System.out.println("DELETE [options] [args...] ---- Deletes item dependent on option and args.");
    System.out.println("Where options include:");
    System.out.println("\tFILE [filename] ---- Deletes file.");
    System.out.println();
    System.out.println("ADD [column index] [row index] [args...] ---- Populates cell given coordinates and arguments.");
    System.out.println();
    System.out.println("EDIT [options] [args...] ---- Edits item dependent on options and args.");
    System.out.println("Where options include:");
    System.out.println("\tFILE [filename] [option1] [option2] [args...] ---- Edits file dependent on options and args.");
    System.out.println("\tWhere option1 includes:");
    System.out.println("\t\tCOLUMNS");
    System.out.println("\t\tROWS");
    System.out.println("\t\t[row index]");
    System.out.println("\tWhere option2 includes:");
    System.out.println("\t\tADD");
    System.out.println("\t\tDELETE");
    System.out.println("\t\t[column index]");
    System.out.println();
  }
}