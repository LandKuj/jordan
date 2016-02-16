import java.util.*;
import java.io.*; 

public class Statistics { 
  DataFrame frame; 
  
  Statistics(String path) throws FileNotFoundException { 
    this.frame = new DataFrame(path); 
  }
  
  public double mean(int col) {
    return Statistics.mean(frame.get(col)); 
  }
  
  public static double mean(ArrayList<String> data) { 
    int n = data.size(); 
    double sum = 0; 
    for(String s : data) { 
      sum += Double.parseDouble(s); 
    }
    return sum / n; 
  }

  public double std(int col) { 
    return std(frame.get(col)); 
  }
  
  public double std(ArrayList<String> data) { 
    double mean = Statistics.mean(data); 
    int n = data.size();
    double sum = 0; 
    for(String cell : data) { 
      sum += Math.pow(Double.parseDouble(cell) - mean, 2); 
    }
    return Math.sqrt(sum / n); 
  }
  
  public static void main(String[] args) throws FileNotFoundException { 
    Statistics data = new Statistics("/Users/jordanlandgrebe/Desktop/sample.csv");
    System.out.println(data.mean(4));
    System.out.println(data.std(4)); 
  }
  
  
  
}
  