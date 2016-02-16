import java.util.*; 

public class HeaderList extends ArrayList<Header> { 
  
  
  HeaderList(String raw) { 
    this.breakDown(raw); 
  }
  
  public void breakDown(String raw) { 
    if(raw.contains(",")) { 
      String head = raw.substring(0, raw.indexOf(",")); 
      String type = "s"; 
      //String type = head.getType(); 
      String newRaw = raw.substring(raw.indexOf(",") + 1);
      Header newHead = new Header(head, type); 
      this.add(newHead); 
      this.breakDown(newRaw); 
    } else { 
      String head = raw; 
      String type = "s"; 
      //String type = head.getType(); 
      Header newHead = new Header(head, type); 
      this.add(newHead); 
    }
  }
  
  
  
  
  
  
  
  
}