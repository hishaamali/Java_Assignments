import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;

public class Coding{
  PriorityQueue q = new PriorityQueue();
  HuffmanNode singleNode;
  HuffmanNode huffTree;
  public TreeMap<Character, Integer> freqMap = new TreeMap<Character, Integer>();
  String s;
  String decodedString;

  public void readFile(String fileName){
    try{
    for(String line : Files.readAllLines(Paths.get(fileName))){
        s = line;
      }
    }
       catch (IOException ex){
       ex.printStackTrace();
    }
  }
  public void countFreq(String fileName){
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      Integer v = freqMap.get(c);
      if (v != null) {
         freqMap.put(c, new Integer(v + 1));
        }
    else {
       freqMap.put(c, 1);
      }
    }
  }

  public void Decode64(){
    Decoder dc = Base64.getDecoder();
    byte[] byteArray = dc.decode(s.getBytes());
    decodedString = new String(byteArray);
    System.out.println("Base 64 decoded string: " + decodedString);
  }

  public void decodeToPlain(HuffmanNode huffTree) {
     if (huffTree == null) System.out.println("");
     String decoding = "";
     HuffmanNode node = huffTree;
     for (Character c : decodedString.toCharArray()) {
      if (c.equals('0')) node = node.huffLeft;
      else node = node.huffRight;
      if (node.huffLeft == null) {
        decoding += node.text;
        node = huffTree;
      }
    }
    System.out.println("Converted to plain text: " + decoding);
    System.out.println();
  }

  public void encodeHuffman(TreeMap mp, String fileName, String output) {
    IO out = new IO(output);
    Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      singleNode = new HuffmanNode(pair.getKey().toString(),Integer.parseInt(pair.getValue().toString()));
      q.insert(singleNode);
      it.remove(); 
    }
    System.out.println();
    q.printHeap();
    while (q.size > 1) {
      HuffmanNode left = q.removeMin();
      HuffmanNode right = q.removeMin();
      // the other constructor takes care of the combinaLeafElement
      HuffmanNode combinedNode = new HuffmanNode(left, right);
      q.insert(combinedNode);
    }
    huffTree = q.removeMin();
    huffTree.print();
    System.out.println();
    System.out.print("Bitstring is ");
    ArrayList <String> bitstring = new ArrayList();
    for (int i = 0; i < s.length(); i++) {
      Iterator o = huffTree.bitMap.entrySet().iterator();
      while (o.hasNext()){
         Map.Entry pair = (Map.Entry)o.next();
         if (Character.toString(s.charAt(i)).equals(pair.getKey().toString())){
            bitstring.add(pair.getValue().toString());
            System.out.print(pair.getValue().toString());
          }
         if (o.hasNext() == false) break;
        }
      }
      System.out.println();
      String str = String.join("", bitstring);
      Encoder ec = Base64.getEncoder();
      byte[] rawBytes = str.getBytes();
      String b64String = ec.encodeToString(rawBytes);
      System.out.println();
      out.writeLine(b64String);
      out.close();
 }

 public void decodeHuffman(TreeMap mp, String fileName) {
    Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      singleNode = new HuffmanNode(pair.getKey().toString(),Integer.parseInt(pair.getValue().toString()));
      q.insert(singleNode);
      it.remove(); 
    }
    while (q.size > 1) {
      HuffmanNode left = q.removeMin();
      HuffmanNode right = q.removeMin();
      // the other constructor takes care of the combinaLeafElement
      HuffmanNode combinedNode = new HuffmanNode(left, right);
      q.insert(combinedNode);
    }
    huffTree = q.removeMin();
    ArrayList <String> bitstring = new ArrayList();
    for (int i = 0; i < s.length(); i++) {
      Iterator o = huffTree.bitMap.entrySet().iterator();
      while (o.hasNext()){
         Map.Entry pair = (Map.Entry)o.next();
         if (Character.toString(s.charAt(i)).equals(pair.getKey().toString())){
            bitstring.add(pair.getValue().toString());
          }
         if (o.hasNext() == false) break;
        }
      }
    }  
}