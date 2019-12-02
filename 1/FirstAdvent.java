import java.io.*;

public class FirstAdvent {
  public static void main(String[] args){
    System.out.println("This is my first program in java");
    File f = new File("input.txt");

    try {
      BufferedReader reader = new BufferedReader(new FileReader(f));

      String s;
      int total = 0;
      while((s = reader.readLine()) != null){
        int number = Integer.parseInt(s);

        number = (number / 3);
        number = number - 2;
        total += number;
      }
      System.out.println("Total fuel needed: " + total);
    } catch(Exception e) {
      System.out.println("Error: " + e.toString());
      return;
    }



  }
}