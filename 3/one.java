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
 
    } catch(Exception ex) {
      print("Error: " + ex.toString());
    }  
  }

  static void print(String s) {
    System.out.println(s);
  }
}