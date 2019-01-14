import java.util.HashMap;

public class HashIndex extends HashMap {
  // Index storage using hashing with chaining
  public HashIndex(){
    super();
  }
  
  public boolean isValid(HashIndex d,String ID){
    if (d.keySet().contains(ID)) return false;
    else return true;
  }

 public int findHashIndex(HashIndex d,String ID){
   return Integer.parseInt(d.get(ID).toString());
  }

 }
