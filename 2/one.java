import java.io.*;
import java.util.*;
public class one {
  public static void main(String[] args){
    try {
    
      File f = new File("input.txt");
      BufferedReader reader = new BufferedReader(new FileReader(f));
      String s;
      StringBuilder sb = new StringBuilder();
      while((s = reader.readLine()) != null) {
        sb.append(s);
      }
      reader.close();
      String[] arr = sb.toString().split(",");
      int[] intArr = new int[arr.length];
      int[] cp = new int[arr.length];
      for(int i = 0; i < arr.length; i ++) {
        intArr[i] = Integer.parseInt(arr[i]); 
        cp[i] = intArr[i];
      }
     
      int marker = intArr[0];
      int opcode = 0;
      while(marker != 99) {
        int p1 = intArr[opcode + 1];
        int p2 = intArr[opcode + 2];
        int p3 = intArr[opcode + 3];
        switch(marker) {
          case 1: intArr[p3] = intArr[p1] + intArr[p2]; break;  
          case 2: intArr[p3] = intArr[p1] * intArr[p2]; break;
        }
        opcode = opcode + 4;
        marker = intArr[opcode];
      }
      print("Address 0 = " + intArr[0]);
    } catch(Exception ex) {
      print("Error: " + ex.toString());
    }  
  }

  static void print(String s) {
    System.out.println(s);
  }
}