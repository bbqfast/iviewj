package iviewj.exercise;

import java.util.ArrayList;
import java.util.HashMap;

public class Football {
  HashMap<Integer, String> map;

  public Football() {
    map = new HashMap<Integer, String>();
    map.put(2, "Safety");
    map.put(3, "Field Goal");
    map.put(6, "Touchdown");
    map.put(7, "Touchdown, 1 Extra Point");
    map.put(8, "Touchdown, Two-Point Conversion");
  }

  public ArrayList<String> fsia(int s, String way)
  {
    ArrayList<String> ways = new ArrayList<String>();
    
    if (s == 0)
      return ways; 
    
    for (int v : map.keySet())
    {
      String score = fsi( s - v, map.get(v) + ", " + way);
      if (score != null)
        ways.add(score);
    }
    
    return ways;
  }  
  
  public String fsi(int s, String way)
  {
    if (s == 0)
      return way;
    
    if (s < 0)
      return null;
    
    for (int v : map.keySet())
    {
      String score = fsi( s - v, map.get(v) + ", " + way);
      if (score != null)
        return score;
    }
    return null;
  }
}
