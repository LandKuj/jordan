import java.util.*; 

public class Lottery { 
  int[] pick = new int[6];
  int[] num = new int[6]; 
  double win = 0; 
  int plays = 0; 
  int spent = 0; 
  int jackpot = 0; 
  int all_no_pb = 0; 
  int four_and_pb = 0; 
  int four_no_pb = 0; 
  int three_and_pb = 0; 
  int three_no_pb = 0; 
  int two_and_pb = 0; 
  int one_and_pb = 0; 
  int pb = 0; 
  int[] jackpot_pick = new int[6]; 
  int[] jackpot_num = new int[6];
  
  Lottery() { 
    this.pick = Lottery.randNums(); 
    this.num = Lottery.randNums(); 
  }
  
  public static void main(String[] args) { 
    Lottery lotto = new Lottery(); 
    lotto.playN(Double.parseDouble(args[0])); 
    if(lotto.win >= lotto.spent) { 
      System.out.println("YOU'RE A WINNER!"); 
      System.out.println("You made: " + (lotto.win - lotto.spent)); 
    } else { 
      System.out.println("YOU'RE A LOSER!"); 
      System.out.println("You lost: " + (lotto.spent - lotto.win)); 
    }
    System.out.println("Your return is " + ((double)lotto.win / lotto.spent));
    System.out.println("You spent: " + lotto.spent + " To win: " + lotto.win); 
    System.out.println("You matched the PB: " + lotto.pb + " times"); 
    System.out.println("You matched the PB and one ball: " + lotto.one_and_pb + " times"); 
    System.out.println("You matched the PB and two balls: " + lotto.two_and_pb + " times"); 
    System.out.println("You matched three balls: " + lotto.three_no_pb + " times"); 
    System.out.println("You matched the PB and three balls: " + lotto.three_and_pb + " times");
    System.out.println("You matched four balls: " + lotto.four_no_pb + " times"); 
    System.out.println("You matched the PB and four balls: " + lotto.four_and_pb + " times"); 
    System.out.println("You matched five balls: " + lotto.all_no_pb + " times"); 
    System.out.println("You won the Jackpot " + lotto.jackpot + " times"); 
    //System.out.println(lotto.toJack_PickString()); 
    //System.out.println(lotto.toJack_NumString()); 
  
    /*
    System.out.println(lotto.toPickString());
    System.out.println(lotto.toNumString()); 
    System.out.println(lotto.numEqual()); 
    */
  }

  public void playN(double n) { 
    for(int i = 0; i < n; i++) { 
      this.spent += 2;
      this.plays++;
      this.pick = Lottery.randNums(); 
      this.num = Lottery.randNums(); 
      this.getWinnings(); 
    }
  }
  
  
  
  public void getWinnings() { 
    if(this.numEqual() == 5 && this.PBequal()) { 
      this.win += 1500000000; 
      this.jackpot++;
      jackpot_pick = this.pick; 
      jackpot_num = this.num; 
    } else if(this.numEqual() == 5) {
      this.win += 1000000; 
      this.all_no_pb++; 
    } else if(this.numEqual() == 4 && this.PBequal()) { 
      this.win += 50000; 
      this.four_and_pb++; 
    } else if(this.numEqual() == 4) { 
      this.win += 100; 
      this.four_no_pb++; 
    } else if(this.numEqual() == 3 && this.PBequal()) { 
      this.win += 100; 
      this.three_and_pb++; 
    } else if(this.numEqual() == 3) { 
      this.win += 7; 
      this.three_no_pb++; 
    } else if(this.numEqual() == 2 && this.PBequal()) {
      this.win += 7; 
      this.two_and_pb++; 
    } else if(this.numEqual() == 1 && this.PBequal()) { 
      this.win += 4; 
      this.one_and_pb++; 
    } else if(this.PBequal()) { 
      this.win += 4; 
      this.pb++; 
    }
    
  }
  
  public static int[] randNums() { 
    int[] n = new int[6]; 
    for(int i = 0; i < 5; i++) { 
      n[i] = Lottery.randBetween(-1, 69); 
    }
    n[5] = Lottery.randBetween(-1, 26); 
    return n; 
  }
 
  public String toPickString() { 
    String pick = "[" + this.pick[0] + ","; 
    for(int i = 1; i < 5; i++) { 
      pick = pick + " " + this.pick[i] + ","; 
    }
    pick = pick + " " + this.pick[5] + "]"; 
    return pick; 
  }
  
  public String toNumString() { 
    String num = "[" + this.num[0] + ",";
    for(int i = 1; i < 5; i++) { 
      num = num + " " + this.num[i] + ","; 
    }
    num = num + " " + this.num[5] + "]"; 
    return num; 
  }
  
   public String toJack_PickString() { 
    String num = "[" + this.jackpot_pick[0] + ",";
    for(int i = 1; i < 5; i++) { 
      num = num + " " + this.jackpot_pick[i] + ","; 
    }
    num = num + " " + this.jackpot_pick[5] + "]"; 
    return num; 
  }
   
   public String toJack_NumString() { 
    String num = "[" + this.jackpot_num[0] + ",";
    for(int i = 1; i < 5; i++) { 
      num = num + " " + this.jackpot_num[i] + ","; 
    }
    num = num + " " + this.jackpot_num[5] + "]"; 
    return num; 
  }
    
  public boolean PBequal() { 
    if(this.pick[5] == this.num[5]) { 
      return true; 
    } else { 
      return false; 
    }
  }
  
  public int numEqual() { 
    int counter = 0; 
    int count = 0; 
    int[] pick = Arrays.copyOfRange(this.pick, 0,5); 
    int[] num = Arrays.copyOfRange(this.num, 0,5); 
    int test_num = 0;
    
    for(int x = 0; x < 5; x++) { 
      test_num = pick[x];
      for(int i = 0; i < num.length; i++) { 
        if(test_num == num[i]) { 
          count++; 
          num = Lottery.remove(num, i); 
          break; 
        }
      }
    }
    return count;
  }
  
  public static int[] remove(int[] ray, int at) {
    int len = ray.length - 1; 
    int[] out_ray = new int[len]; 
    int counter = 0; 
    for(int i = 0; i < len + 1; i++) { 
      if(i != at) { 
        out_ray[counter] = ray[i];
        counter++; 
      }
    }
    return out_ray;
  }
  
  public static int randBetween(int max, int min) { 
    int n = (int)(Math.random() * (max - min) + 1) + min; 
    return n; 
  }

  
}
    
    