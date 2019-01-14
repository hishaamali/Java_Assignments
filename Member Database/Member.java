public class Member {
  // Member object
   String ID;
   String Name;

  public Member(String id, String name){
    if (id.length() != 8) throw new IllegalArgumentException("ID must be 8 digits.");
    ID = id; 
    Name = name;
  }

  public String getID(){
    return ID;
  }

  public String getName(){
    return Name;
  }

  public void setID(String id){
     if (id.length() != 8) throw new IllegalArgumentException("ID must be 8 digits.");
     id = ID;
  }

  public void setName(String name){
    name = Name;
  }

  public String toString(){
    return ("ID: " + ID + " Name: " + Name);
  }

  public boolean equals(Member other){
    if (ID.equals(other.ID)) return true;
    return false;
  }

}