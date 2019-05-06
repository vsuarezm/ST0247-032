/**
 * Exercise 1.1
 * 
 * @author Santiago Moreno Rave, Valeria Suárez Mejía
 */
 
 public class Exercise11{
 
  public static int heldKarp(Digraph graf) {
        int n = grafo.size();
        int np = (int) Math.pow(2, n);
        int cost [][] = new int[n][np];
        int p [][] = new int[n][np];
        int result;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < np; j++) {
                p[i][j] = -1;
                if (j == 0) {
                  cost[i][0] = graf.getWeight(i,0);
                }else {
                  cost[i][j] = -1;
                }
            }
            result = cost[p][n];
        }
        return result;
    }
