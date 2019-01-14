public class ArrayList<Member> implements List<Member> {
    static final int defaultCapacity = 10;
    int capacity;     //max number of elements this can hold
    int currentSize;  //number of elements this is currently holding
    Member[] array;
    IO output = new IO("output.txt");
    
    public ArrayList() {
        capacity = defaultCapacity;
        array = (Member[]) new Object[capacity];
    }

    public ArrayList(int specifiedCapacity) {
        capacity = specifiedCapacity;
        array = (Member[]) new Object[capacity];
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    public void set(int i, Member e) {
        array[i] = e;
    }

    public Member get(int i) {
        if (i < currentSize) {
            return (Member) array[i];
        } else {
            return null;
        }
    }
    
    public void add(Member e) {
        if (currentSize < capacity) { //still got space
            array[currentSize++] = e;
        } else {
            capacity += defaultCapacity;
            Member[] newArray = (Member[]) new Object[capacity];
            for (int i = 0; i < currentSize; i++) {
                newArray[i] = array[i];
            }
            newArray[currentSize++] = e;
            array = newArray;
        }
    }
    
    public void remove (int index) {
        for (int i = index; i < currentSize; i++) {
            array[i] = array[i+1];
        }
        currentSize--;
    }
    
    public void printAll() {
        System.out.println("Current size = " + currentSize + "/" + capacity);
        for (int i = 0; i < currentSize; i++) {
            System.out.println(i + "\t" + array[i].toString());
        }
    }

    
    public int indexOf(String ID){
        for (int i = 0; i < currentSize; i++){
           if (array[i].toString().contains(ID)) return i;
        }
        return -1;
    }


    public void printOutput(){
      for (int i = 0; i < currentSize; i++){
        output.writeLine(array[i].toString());
      }
    output.close();
    }
  }
