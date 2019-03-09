package taller7;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Santiago Moreno, Valeria Suárez
 */
public class Taller7 {

    private int[] llenarUnArrregloConInfinitos(int n) {
        int[] a = new int[n];
        Arrays.fill(a, Integer.MAX_VALUE);
        return a;
    }

    private int elMasPequenoNoVisitado(Digraph g, boolean[] visitados, int[] tabla) {
        int aux = Integer.MAX_VALUE;
        for (int i = 0; i < tabla.length; i++) {
            if (visitados[i] == false) {
                if (aux > tabla[i]) {
                    aux = tabla[i];
                }
            }
        }
        return aux;
    }

    public void actualizarLosPesosDeLaTablaConElValorActual(Digraph g, int actual, int[] tabla) {

        int aux = Integer.MAX_VALUE;
        if (tabla[actual] != Integer.MAX_VALUE) {
            ArrayList<Integer> sucesores = g.getSuccessors(actual);
            for (int i = 0; i < sucesores.size(); i++) {
                if (i != actual && g.getWeight(actual, i) != Integer.MAX_VALUE && g.getWeight(actual, i) + tabla[actual] < tabla[i]) {
                    tabla[i] = tabla[actual] + g.getWeight(actual, i);
                }

            }

        }
    }

    public int[] dijkstra(Digraph g, int v) {
        int[] tabla = llenarUnArrregloConInfinitos(g.size());
        int actual = v;
        boolean[] visitados = new boolean[g.size()];
        for (int i = 0; i < g.size(); i++) {
            actual = elMasPequenoNoVisitado(g, visitados, tabla);
            visitados[actual] = true;
            actualizarLosPesosDeLaTablaConElValorActual(g, actual, tabla);
        }
        return tabla;
    }

    public static int[] prim(Digraph g, int v, boolean[] visitados, int[] tabla, int cont) {
        if (cont == g.size() - 1) {
            return tabla;
        }

        int menorAux = Integer.MAX_VALUE;
        visitados[v] = true;
        int vertice = -1;
        int inicio = -1;
        for (int i = 0; i < g.size(); i++) {
            if (visitados[i]) {
                for (int j : g.getSuccessors(i)) {
                    int menor = g.getWeight(i, j);
                    if (menor < menorAux) {
                        menorAux = menor;
                        vertice = j;
                        inicio = i;
                    }
                }
            }
        }
        if (tabla[vertice] == Integer.MAX_VALUE) {
            tabla[vertice] = g.getWeight(inicio, vertice);
        } else {
            tabla[vertice] += g.getWeight(inicio, vertice);
        }
        return prim(g, vertice, visitados, tabla, cont + 1);
    }

    private static void aux(Digraph g) {
        boolean[] visitados = new boolean[g.size()];
        int[] respuesta = llenarInfinitos(g.size());
        prim(g, 0, visitados, respuesta, 0);
    }

}
