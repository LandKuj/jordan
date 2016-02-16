import java.util.*; 
import java.io.*; 

public class DataFrame extends ArrayList<ArrayList<String>> { 
  int numColumn; 
  ArrayList<Header> heads = new ArrayList<Header>();
  
  DataFrame(String path) throws FileNotFoundException { 
    File file = new File(path); 
    Scanner in = new Scanner(file); 
    String headers = in.nextLine(); 
    this.heads = new HeaderList(headers);
    numColumn = this.heads.size(); 
    for(int i = 0; i < numColumn; i++) { 
      this.add(new ArrayList<String>()); 
    }
    while(in.hasNextLine()) { 
      String raw = in.nextLine(); 
      for(int i = 0; i < numColumn - 1; i++) { 
        String data = raw.substring(0, raw.indexOf(",")); 
        raw = raw.substring(raw.indexOf(",") + 1); 
        this.get(i).add(data); 
      }
    }

  }
  

  
  
  
}