public class Help
{
  public static void fallBack()
  {
    System.out.println();
    System.out.println("ADD [column number] [row number] [args...] ---- Populates cell given coordinates and arguments.");
    System.out.println();
    System.out.println("COMMENT [text] ---- Creates comment on single line.");
    System.out.println();
    System.out.println("CREATE [options] [args...] ---- Creates item dependent on option and args.");
    System.out.println("Where options include:");
    System.out.println("\tFILE [filename] ---- Creates empty file.");
    System.out.println("\tCOLUMNS [column name 1] ... [column name i] ---- Creates column names.");
    System.out.println("\tROWS [number of rows] ---- Creates rows. must create columns before rows.");
    System.out.println();
    System.out.println("DELETE [options] [args...] ---- Deletes item dependent on option and args.");
    System.out.println("Where options include:");
    System.out.println("\tFILE [filename] ---- Deletes file.");
    System.out.println();
    System.out.println("DROP [options] ---- Nulls current method of input/output.");
    System.out.println("Where options include:");
    System.out.println("\tFILE ---- Ends file manipulation");
    System.out.println("\tREPL ---- Ends REPL input.");
    System.out.println();
    System.out.println("EDIT [options] [args...] ---- Edits item dependent on options and args.");
    System.out.println("Where options include:");
    System.out.println("\tFILE [filename] [option1] [option2] [args...] ---- Edits file dependent on options and args.");
    System.out.println("\tWhere option1 includes:");
    System.out.println("\t\tCOLUMNS [options2]");
    System.out.println("\t\tWhere option2 includes:");
    System.out.println("\t\t\tADD [column name 1] ... [column name i]");
    System.out.println("\t\t\tDELETE [column minimum index] [column maximum index]");
    System.out.println("\t\tROWS [options2]");
    System.out.println("\t\tWhere option2 includes:");
    System.out.println("\t\t\tADD [row number]");
    System.out.println("\t\t\tDELETE [row minimum index] [row maximum index]");
    System.out.println("\t\tCELL [options2]");
    System.out.println("\t\tWhere option2 includes:");
    System.out.println("\t\t\tMATH [value] [math operator] [value]");
    System.out.println("\t\t\t[cell value]");
    System.out.println();
    System.out.println("HELP ---- Prints out this page.");
    System.out.println();
    System.out.println("IMPORT [option] [source] [file] ---- Imports library.");
    System.out.println("Where options include:");
    System.out.println("\tCOMMAND ---- Imports command from source.");
    System.out.println("\tMODULE ---- Imports module from source.");
    System.out.println("\tFILE ---- Imports file from source");
    System.out.println();
    System.out.println("IMPORTED [command] [arg...] ---- Uses imported library.");
    System.out.println();
    System.out.println("PRINT [option] [arg] ---- Outputs item in command-line dependent on option and arg.");
    System.out.println("Where options include:");
    System.out.println("\tFILE [filename] ---- Outputs contents of file.");
    System.out.println("\tTEXT [text] ---- Outputs text.");
    System.out.println();
    System.out.println("PULL [options] [args...] ---- Sets current method of input/output.");
    System.out.println("Where options include:");
    System.out.println("\tFILE [filename] ---- Set dictated file to manipulate.");
    System.out.println("\tREPL ---- Set command-line as method of command input.");
    System.out.println("\tMODULE [module name] ---- Set stated module as method of command input.");
    System.out.println("\tMAIN ---- Set main.csvol as method of command input.");
    System.out.println();
    System.out.println("See https://csvol-docs.wichitacpu.repl.co/docs.html for more details.");
    System.out.println();
  }
}