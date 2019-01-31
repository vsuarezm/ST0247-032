package taller2;

/**
 *
 * @author Santiago Moreno y Valeria Suárez
 */
public class Ejercicio1 {

    public static void conjuntoPotencia(String cadena) {
        conjuntoPotenciaAux("", cadena);
    }

    private static void conjuntoPotenciaAux(String loquellevo, String loquemefalta) {
        if (loquemefalta.length() == 0) {

            System.out.println(loquellevo);
        } else {
            conjuntoPotenciaAux(loquellevo, loquemefalta.substring(1));
            conjuntoPotenciaAux(loquellevo + loquemefalta.charAt(0), loquemefalta.substring(1));
        }
    }

}
