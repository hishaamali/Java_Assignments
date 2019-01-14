class Main {
  public static void main(String[] args){
    CMD cmd = new CMD(); 
    cmd.readFile("input.json");
    cmd.Database.printOutput();
    
  }
}