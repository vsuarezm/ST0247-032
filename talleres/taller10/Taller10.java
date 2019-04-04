/**
 * Clase en la cual se implementan los metodos del Taller 10
 *
 * @author Santiago Moreno, Valeria Suárez
 */
public class Taller10 {

    /**
     * Metodo que calcula la longitud de la subsecuencia mas larga en comun
     * entre dos cadenas
     *
     * @param x cadena de caracteres
     * @param y cadena de caracteres algunas opciones
     * @see
     * <a href="https://es.wikipedia.org/wiki/Algoritmo_Knuth-Morris-Pratt">KMP</a>
     * @see
     * <a href="https://es.wikipedia.org/wiki/Algoritmo_de_b%C3%BAsqueda_de_cadenas_Boyer-Moore">Boyer
     * Moore y sus variantes</a>
     *
     */
    public static int lcs(String x, String y) {
        int[][] laTabla = new int[x.length() + 1][y.length() + 1];
        for (int i = 0; i <= x.length(); i++) {
            laTabla[i][0] = 0;
        }
        for (int j = 0; j <= y.length(); j++) {
            laTabla[0][j] = 0;
        }

        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    laTabla[i][j] = laTabla[i - 1][j - 1] + 1;
                } else {
                    laTabla[i][j] = Math.max(laTabla[i][j - 1], laTabla[i - 1][j]);
                }
            }
        }
        return laTabla[x.length()][y.length()];
    }
}
