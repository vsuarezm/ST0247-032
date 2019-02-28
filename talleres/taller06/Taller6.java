package taller6;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Santiago Moreno, Valeria Suárez
 */
public class Taller6 {

    /**
     * Metodo que dado un entero n y un conjunto de denominciones de dinero
     * busque la manera optima de dar el cambio
     *
     * @param n cantidad a devolver
     * @param denominaciones conjunto de denominaciones de dinero (monedas,
     * billetes)
     * @return un conjunto de unidades por denominacion
     */
    public static int[] cambioGreedy(int n, int[] denominaciones) {
        int[] respuesta = new int[denominaciones.length];
        Arrays.sort(denominaciones);
        for (int i = 0; i < denominaciones.length; i++) {
            int cantidad = n / denominaciones[i];
            respuesta[i] = cantidad;
            n %= denominaciones[i];
        }
        return respuesta;
    }

    /**
     * Metodo que recorre todo el grafo con la intencion de buscar un camino que
     * represente el menor costo pasando por todos los vertices exactamente una
     * vez y vuelva al nodo inicial
     *
     * @param g grafo dado
     * @return cual es el costo que tiene
     */
    public static int recorrido(Digraph g) {
        boolean[] visit = new boolean[g.size()];
        int vertAct = 0;
        int costos = Integer.MAX_VALUE;
        int tamaño = 0;

        while (vertAct != g.size) {
            visit[vertAct] = true;
            ArrayList<Integer> hijos = g.getSuccessors(vertAct);
            for (Integer hijo : hijos) {
                if ((!visit[hijo] && tamaño + g.getWeight(vertAct, hijo) < costos[0]) || (hijo == vertAct && vertAct == g.size())) {
                    tamaño += g.getWeight(vertAct, hijo);
                    if (tamaño < costos) {
                        costos = tamaño;
                    }
                }
            }
            vertAct++;
        }
        return costos;
    }

}
