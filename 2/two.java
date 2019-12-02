import java.io.*;
import java.util.Arrays;

public class two {
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
      int[] input = new int[arr.length];

      for(int i = 0; i < arr.length; i ++) {
        input[i] = Integer.parseInt(arr[i]); 
      }
     
      for(int verb = 0; verb < 99; verb ++) {
        for(int noun = 2; noun < 99; noun ++) {
          int[] cp = Arrays.copyOf(input, input.length);
          cp[1] = verb;
          cp[2] = noun;

          int iPointer = 0;
        
          outerLoop:
          while(true) {
            int opCode = cp[iPointer];
            int p1 = cp[iPointer + 1];    
            int p2 = cp[iPointer + 2];    
            int out = cp[iPointer + 3];

            switch(opCode) {
              case 1: cp[out] = cp[p1] + cp[p2]; break;  
              case 2: cp[out] = cp[p1] * cp[p2]; break;
              case 99: break outerLoop;
            }   
            iPointer += 4; 
          }
          if(cp[0] == 19690720) {
            Log.d("" + (100 * verb + noun));
          } 
        }
      }
    } catch(Exception ex) {
      Log.d("Error: " + ex.toString());
    }  
  }

  static void printArr(int[] arr, int[] cp) {
    int index = 0;
    for (int item : arr) {
      Log.d(item + " - " + cp[index]);
      index ++;
    }
  }
}
class Log {
  public static void d(String s) {
    System.out.println(s);
  }
}