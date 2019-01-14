import java.util.*;
import java.io.*;

public class CMD {
  ArrayList <Member> Database = new ArrayList<Member>();
  HashIndex d = new HashIndex();
  String ID, Name, cmd;
  Scanner s;
  Member m;
  IO output = new IO("output.txt");
  IO log = new IO("log.txt");
  int index = 0;
  static final String PARAS_STRING = "{}";
  BufferedReader br;

  public void openTextFile(){
    try{
      s = new Scanner(new File("input.txt"));
    }
    catch(Exception e){
      System.out.println("File could not be found");
    }
  }
  
  public void readFile(String fileName){
    if (fileName.endsWith("txt")){
      openTextFile();
      while(s.hasNext()){
        cmd = s.next();
        ID = s.next();
        Name = s.next() + " " + s.next();
        m = new Member(ID, Name);
        if (cmd.equalsIgnoreCase("add")){
          if (d.isValid(d,ID)){
          Database.add(m);
          d.put(ID, index);
          index++;
          log.writeLine("Added new member " + ID + " " + Name);
          }
          else{
            log.writeLine("Failed to add member " + ID + " " + Name +". Member Already exists.");
          }
        }
        else if (cmd.equalsIgnoreCase("del")){
          Database.remove(Database.indexOf(ID));
          d.remove(ID, d.findHashIndex(d,ID));
          log.writeLine("Deleted member " + ID + " " + Name);
        }
        else if (cmd.equalsIgnoreCase("mod")){
          Database.set(Database.indexOf(ID), m);
          log.writeLine("Changed name of member with ID of " + ID + " to " + Name);
        }
      }
      Database.printAll();
      log.close();
      closeTextFile();
    }
    else if(fileName.endsWith("json")){
      openJSON();
      readJSON();
    }
  }

  public void closeTextFile(){
    s.close();
  }

  public void openJSON(){
    try{
    br = new BufferedReader(new FileReader("input.json"));
    } catch (IOException e) {
      System.out.println("Error Opening File");
    }
    try {
      char head = (char) br.read(); //reads the first char
      if (head != '{') {
        System.out.println("Unexpected Start of JSON");
      }
    } catch (IOException e) {
      System.out.println("Error Reading File");
    }     
  }

  public void readJSON(){
      List <String> text = new ArrayList<String>();
      int i = 0;
      while (true) {
         String nextCMD = getNextCommand();      
         if (nextCMD != null) {
         text.add(nextCMD.replaceAll("\"","")); ;
         i++;
        } 
        else {
          break;
        }
      }
  
    for (int j = 0; j < text.size(); j++){
        String [] result = text.get(j).split("\\,");
        String cmd = result[0].substring(5);
        String ID = result[1].substring(3);
        String Name = result[2].substring(5);
        m = new Member(ID,Name);
        if (cmd.equalsIgnoreCase("add")){
         if (d.isValid(d,ID)){
           Database.add(m);
           d.put(ID, index);
           index++;
           log.writeLine("Added new member " + ID + " " + Name);
        }
        else{
          log.writeLine("Failed to add member " + ID + " " + Name +". Member Already exists.");
        }
      }
        else if (cmd.equalsIgnoreCase("del")){
          Database.remove(Database.indexOf(ID));
          d.remove(ID, d.findHashIndex(d,ID));
          log.writeLine("Deleted member " + ID + " " + Name);
        }
        else if (cmd.equalsIgnoreCase("mod")){
          Database.set(Database.indexOf(ID), m);
          log.writeLine("Changed name of member with ID of " + ID + " to " + Name);
        }
      }
      Database.printAll();
      log.close();
  }

  public String getNextCommand() {
    try {
      String current = "";
      boolean open = false;
      char c = (char) br.read();
      while (c > 0) {
        if (c == '{') {
          current = "";
          open = true;
        } else if (c == '}') {
          if (open) return current;
          else return null;
        } else {
          current += c;
        }
        c = (char) br.read();
      }
    } catch (IOException e) {
      System.out.println("Error Reading File");
    }
    return null;
  }
}