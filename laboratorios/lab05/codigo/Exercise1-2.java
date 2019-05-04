 /**
 * Exercise 1.2
 * 
 * @author Santiago Moreno Rave, Valeria Suárez Mejía
 */

public class Exercise12{

  public static int levenshtein(String a, String b) {
        int m[][] = new int[a.length()+1][b.length()+1];
        
        for (int i = 0; i <= a.length(); i++) {
            for (int j = 0; j <= b.length(); j++) {
                m[i][j] = 0;
            }
        }

        for (int i = 0; i <= a.length(); i++) {
            m[i][0] = i;
        }

        for (int j = 0; j <= b.length(); j++) {
            m[0][j] = j;
        }

        for (int j = 0; j <= a.length(); j++) {
            for (int i = 0; i <= b.length(); i++) {
                if (a.charAt(i) == b.charAt(j)) {
                    m[i][j] = m[i - 1][j - 1];
                } else {
                    m[i][j] = Math.min(Math.min(m[i - 1][j] + 1, m[i][j - 1] + 1), m[i - 1][j - 1] + 1);
                }
            }
        }
        return matriz[a.length()][b.length()];
    }
}
