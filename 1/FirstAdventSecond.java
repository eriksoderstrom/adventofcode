import java.io.*;

public class FirstAdventSecond {
  public static void main(String[] args){
  
    File f = new File("input.txt");

    try {
      BufferedReader reader = new BufferedReader(new FileReader(f));

      String s;
      int total = 0;
      while((s = reader.readLine()) != null){
        int number = Integer.parseInt(s);

        number = (number / 3) -2; 
        total += number;

        int fuel = number;
        while((fuel = (fuel / 3) - 2) > 0) {
          System.out.print("Fuel: " + fuel + "\n");
          total += fuel;
        }  
        System.out.print("-------------------------\n");
      }
      reader.close();
      System.out.println("Total fuel needed: " + total);
    } catch(Exception e) {
      System.out.println("Error: " + e.toString());
      return;
    }



  }
}