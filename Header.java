public class Header { 
  String name; 
  String type; 
  
  
  Header(String name, String type) { 
    this.name = name; 
    this.type = type; 
  }
  
  public String toString() { 
    return this.name;
  }
  
}