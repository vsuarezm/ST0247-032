/**
 * Exercise 1.3
 * 
 * @author Santiago Moreno Rave, Valeria Suárez Mejía
 */

public class Exercise13 {

  public int sequence (int i, int j, String a, Strings b) {
    if (i==0 || j==0) {
    return 0;
    }
    boolean prev = i < a.length() && j < b.length();
    if (prev && a.charAt(i) == b.charAt(j)) {
      return 1 + sequence (i-1, j-1, a, b);
    }
    
  int ni = sequence(i−1, j, a, b);
  int nj = sequence(i, j−1, a, b);
  return Math.max(ni, nj);
  }
  
 public int sequence(String a, Strings b) {
    return sequence(a.length(), b.length(), a, b);
 }
}
