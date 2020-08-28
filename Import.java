import java.io.*;
import java.util.*;
import java.net.*;

public class Import
{
  public static void command(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    String directory = "";
    switch(arguments.get(2))
    {
      case "csvol-sol":
        directory = "https://csvol-docs.wichitacpu.repl.co/commands/";
        Terminal.solLoading();
        break;
      default:
        directory = arguments.get(2);
        Terminal.directoryLoading();
    }
    try (BufferedInputStream inFile = new BufferedInputStream(new URL(directory+arguments.get(3)+".java").openStream());FileOutputStream outFile = new FileOutputStream(arguments.get(3)+".java")) 
    {
        Terminal.libraryLoading();
        byte data[] = new byte[1024];
        int byteContent;
        while ((byteContent = inFile.read(data, 0, 1024)) != -1) 
        {
            outFile.write(data, 0, byteContent);
        }
        outFile.close();
        (Main.importedCommands).add(arguments.get(3));
        Runtime.getRuntime().exec("javac " + arguments.get(3)+".java");
        Terminal.done();
    }
    catch (Exception e) 
    {
      Terminal.libraryError();
    }
  }
  public static void module(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    String directory = "";
    switch(arguments.get(2))
    {
      case "csvol-sol":
        directory = "https://csvol-docs.wichitacpu.repl.co/modules/";
        break;
      default:
        directory = arguments.get(2);
    }
    try (BufferedInputStream inFile = new BufferedInputStream(new URL(directory+arguments.get(3)+".csvol").openStream());FileOutputStream outFile = new FileOutputStream(arguments.get(3)+".csvol")) 
    {
        byte data[] = new byte[1024];
        int byteContent;
        while ((byteContent = inFile.read(data, 0, 1024)) != -1) 
        {
            outFile.write(data, 0, byteContent);
        }
        outFile.close();
    }
    catch (Exception e) 
    {
      Terminal.libraryError();
    }
  }
  public static void file(ArrayList<String> args) throws Exception
  {
    ArrayList<String> arguments = args;
    String directory = "";
    switch(arguments.get(2))
    {
      case "csvol-sol":
        directory = "https://csvol-docs.wichitacpu.repl.co/files/";
        break;
      default:
        directory = arguments.get(2);
    }
    try (BufferedInputStream inFile = new BufferedInputStream(new URL(directory+arguments.get(3)+".csv").openStream());FileOutputStream outFile = new FileOutputStream(arguments.get(3)+".csv")) 
    {
        byte data[] = new byte[1024];
        int byteContent;
        while ((byteContent = inFile.read(data, 0, 1024)) != -1) 
        {
            outFile.write(data, 0, byteContent);
        }
        outFile.close();
    }
    catch (Exception e) 
    {
      Terminal.libraryError();
    }
  }
}