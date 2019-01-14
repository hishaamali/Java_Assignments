
/**

Project Description Link = https://docs.google.com/document/d/1rW8ipNNEQ7mglGzWcQ8AdL6qvNjBP51uFDXvGwUFldU

 */

class Main {
  //The main routine here. Add other classes as needed
  public static void main(String[] args) {
    String[] plainFiles = {"input1.txt", "input2.txt"};
    String[] compressedFiles = {"output1.txt", "output2.txt"};
    Coding project2 = new Coding();

   for (int i = 0; i < plainFiles.length; i++) {
     project2.readFile(plainFiles[i]);
     project2.countFreq(plainFiles[i]);
     project2.encodeHuffman(project2.freqMap, plainFiles[i], compressedFiles[i]);
    }

   for(int i = 0; i < compressedFiles.length; i++){
     project2.readFile(compressedFiles[i]);
     project2.Decode64();
     project2.readFile(plainFiles[i]);
     project2.countFreq(plainFiles[i]);
     project2.decodeHuffman(project2.freqMap, plainFiles[i]);
     project2.decodeToPlain(project2.huffTree);
    }
  }
}