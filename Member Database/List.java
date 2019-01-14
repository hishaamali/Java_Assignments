public interface List<Member> {
    int size();
    boolean isEmpty();	
    void add(Member e);
    void set(int i, Member e);
    Member get(int i);
    void remove (int index);
}