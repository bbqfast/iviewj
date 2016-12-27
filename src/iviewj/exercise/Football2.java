package iviewj.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Football2 {
  HashMap<Integer, String> scoreMap;

  public Football2() {
    scoreMap = new HashMap<Integer, String>();
    scoreMap.put(2, "Safety");
    scoreMap.put(3, "Field Goal");
    scoreMap.put(6, "Touchdown");
    scoreMap.put(7, "Touchdown, 1 Extra Point");
    scoreMap.put(8, "Touchdown, Two-Point Conversion");
  }  
  
  public ArrayList<String> possibleScore(int s)
  {
    ArrayList<String> ways = new ArrayList<String>();
    HashMap<Integer, Boolean> pathHash = new HashMap<Integer, Boolean>();
    
    if (s == 0)
      return ways; 
    
    for (int v : scoreMap.keySet())
    {
      ArrayList<Integer> path = new ArrayList<Integer>();
      path.add(v);
      ArrayList<Integer> pathFound = possibleScoreIntenal( s - v, path);
      if (pathFound != null)
      {
        Collections.sort(pathFound);
        int hash = GetPathHash(pathFound);
        if (!pathHash.containsKey(hash))
        {
          pathHash.put(hash, true);
          ways.add(PathToString(pathFound));
        }
      }
    }
    
    return ways;
  }    
  
  public String PathToString(ArrayList<Integer> path)
  {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    StringBuffer sb = new StringBuffer();
    
    for( Integer p : path)
    {
      if (map.containsKey(p))
        map.put(p, map.get(p)+ 1);
      else
        map.put(p, 1);
    }
    
    for ( Integer k : map.keySet())
      sb = sb.append(map.get(k) + " " + scoreMap.get(k) + ",");
    
    return sb.toString();
  }  
  
  public int GetPathHash(ArrayList<Integer> path)
  {
    int v=7;
    for ( Integer p : path)
      v = (v * 37) + p;
    
    return v;
  }
  
  public ArrayList<Integer> possibleScoreIntenal(int s, ArrayList<Integer> path)
  {
    if (s == 0)
      return path;
    
    if (s < 0)
      return null;
    
    for (int v : scoreMap.keySet())
    {
      ArrayList<Integer> pathCopy = new ArrayList<Integer>(path);
      pathCopy.add(v);
      ArrayList<Integer> score = possibleScoreIntenal( s - v, pathCopy);
      if (score != null)
        return score;
    }
    return null;
  }  
}
