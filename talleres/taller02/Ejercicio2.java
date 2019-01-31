package taller2;

import java.util.ArrayList;

/**
 *
 * @author Santiago Moreno y Valeria Suárez
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        permutaciones("ABC");

    }

    public static void permutaciones(String cadena) {
        ArrayList<String> permutaciones = new ArrayList<String>();

        permutacionesAux("", cadena, permutaciones);

    }

    private static ArrayList<String> permutacionesAux(String pre, String post, ArrayList<String> permutaciones) {
        int longitud = post.length();
        // caso base
        if (post.length() == 0) {
            permutaciones.add(pre);
            System.out.println(pre);

        } // caso o casos recursivos
        else {
            for (int i = 0; i < longitud; i++) {
                permutacionesAux(pre + post.charAt(i), post.substring(0, i) + post.substring(i + 1), permutaciones);
            }

        }

        return permutaciones;
    }

}
