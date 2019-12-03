import java.io.*;
import java.util.*;
public class one {


  public static void main(String[] args) {
    try {
      // (x2 - x1) + (y2 - y1) = len
      ArrayList<Point> pointList1 = new ArrayList<>();
      ArrayList<Point> pointList2 = new ArrayList<>();
      File f = new File("input1.txt");
      BufferedReader reader = new BufferedReader(new FileReader(f));
      String s;
      StringBuilder sb = new StringBuilder();
      int count = 0;
      String l1 = "";
      String l2 = "";
    
      while((s = reader.readLine()) != null) {
        if(count == 0) {
          l1 = s;
        } else {
          l2 = s;
        }
        count ++;
      }
      
      reader.close();
      String[] line1 = l1.split(",");
      String[] line2 = l2.split(",");
      for(int i = 0; i < line1.length; i ++ ) {
        pointList1.add(new Point(line1[i]));
      }
 
      for(int i = 0; i < line2.length; i ++ ) {
        pointList2.add(new Point(line2[i]));
      }
 
      log("Size of p1: " + pointList1.size() + ", size of p2: " + pointList2.size());
      Matrix matrix = new Matrix();

      matrix.moveInMatrix(pointList1, 1);
      
      log("Next line...");
      matrix.moveInMatrix(pointList2, 2);

      matrix.checkForCrosses();

    } catch(Exception ex) {
      ex.printStackTrace();
    }  
  }

  

  static void print(String s) {
    System.out.println(s);
  }
  static class Matrix {
    public Matrix() {}
    static final int SIZE = 34000;
    static final int BEGIN_GRAPH = 17000;

    int[][] matrix = new int[SIZE][SIZE];

    ArrayList<Integer> resultList = new ArrayList<>();
    void moveInMatrix(ArrayList<Point> pointList, int add) {
      
      int x = BEGIN_GRAPH;
      int y = BEGIN_GRAPH;
      for (Point p : pointList) {
        switch(p.direction) {
          case DIRECTION.UP:
            log("Goin UP in graph, from y" + + y + " to y" + (p.to + y));
            for(int i = 0; i < p.to; i ++) {
              matrix[x][y + i] += add;
              // log("Adding " + add + " to matrix[" + x + "][" + (y + i) + "]");
            }
            y = y + p.to;
            break;
          case DIRECTION.DOWN:
            log("Goin DOWN in graph, from y"  + y + " to y" + (y - p.to));
            for(int i = 0; i < p.to; i ++) {
              matrix[x][y - i] += add;
              // log("Adding " + add + " to matrix[" + x + "][" + (y - i) + "]");
            }
            y = y - p.to;
            break;
          case DIRECTION.RIGHT:
            log("Goin RIGHT in graph, from x" + + x + " to x" + (p.to + x));
            for(int i = 0; i < p.to; i ++) {
              matrix[x + i][y] += add;
              // log("i debug: " + i);
              // log("Adding " + add + " to matrix[" + (x + i)  + "][" + y + "]");
            }
            x = x + p.to;
            break;
          case DIRECTION.LEFT: 
            log("Goin LEFT in graph, from x" + + x + " to x" + (x - p.to));
            for(int i = 0; i < p.to ; i ++) {
              matrix[x - i][y] += add;
              // log("Adding " + add + " to matrix[" + (x + i) + "][" + y + "]");
            }
            x = x - p.to;
            break;
        }
      }
    }
    void checkForCrosses() {
      for(int i = 0; i < SIZE; i ++) {
        for(int j = 0; j < SIZE; j ++) {
          if(matrix[i][j] == 3) {
            log("Found 3 at matrix[" + i + "][" + j +"]");
            int dist = (i - 500) + (j - 500);
            resultList.add(dist);
            log("Distance: " + dist);
          }
        }
      }
      Collections.sort(resultList);
      log("Answer: " + resultList.get(1));
    }
  }

  static class DIRECTION {
    static final String UP = "U";
    static final String DOWN = "D";
    static final String RIGHT = "R";
    static final String LEFT = "L";

  }
  static class Point {

  
    String direction;
    int to;

    public Point(String point) {
      parsePoint(point);
    }


    void parsePoint(String point) {
      String[] split = point.split("");
      this.direction = split[0];
      StringBuilder sb = new StringBuilder();
      for(int i = 1; i < split.length; i ++) {
        sb.append(split[i]);
      }
      this.to = Integer.parseInt(sb.toString());
      log("Direction: " + direction + ", To: " + to);
    } 
  }

  static void log(String s) {
    System.out.println(s);
  }
}