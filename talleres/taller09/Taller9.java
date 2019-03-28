/**
 * Clase en la cual se implementan los metodos del Taller 9
 *
 * @author Santiago Moreno, Valeria Suárez 
 */
public class Taller9 {

    /**
     * Metodo que pretende implementar el funcionamiento del algoritmo
     * levenshtein de dos cadenas a y b
     *
     * @param a cadena de caracteres
     * @param b cadena de caracteres para mas informacion ver
     * @see
     * <a href="https://people.cs.pitt.edu/~kirk/cs1501/Pruhs/Spring2006/assignments/editdistance/Levenshtein%20Distance.htm">
     *
     */
    public static int levenshtein(String a, String b) {
        int matriz[][] = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                matriz[i][j] = 0;
            }
        }

        for (int i = 0; i < a.length(); i++) {
            matriz[i][0] = i;
        }

        for (int j = 0; j < b.length(); j++) {
            matriz[0][j] = j;
        }

        for (int j = 0; j < a.length(); j++) {
            for (int i = 0; i < b.length(); i++) {
                if (a.charAt(i) == b.charAt(j)) {
                    matriz[i][j] = matriz[i - 1][j - 1];
                } else {
                    matriz[i][j] = Math.min(Math.min(matriz[i - 1][j] + 1, matriz[i][j - 1] + 1), matriz[i - 1][j - 1] + 1);
                }
            }
        }
        return matriz[a.length()][b.length()];
    }

}
