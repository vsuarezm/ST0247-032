import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller 5
 *
 * @author Santiago Moreno, Valeria Suárez
 */
public class Taller5 {

    /**
     * Metodo que dado un grafo y un numero m, se asigna un color a cada nodo,
     * de manera que dos nodos adyacentes no poseean el mismo color
     *
     * @param g grafo dado
     * @param m numero de colores
     * @return true si es posible, false de lo contrario
     */
    public static boolean mColoring(Digraph g, int m) {
        int[] colors={1,2,3};
        mColoring(g, 3, colors,m);
        return false;
    }

    /**
     * Metodo que dado un grafo y un vertice v, intenta asignar un color al
     * nodo, de manera que dos nodos adyacentes no poseean el mismo color
     *
     * @param g grafo dado
     * @param m numero de colores
     * @param v vertice
     * @param colors conjunto de colores
     * @return true si es posible, false de lo contrario
     */
    private static boolean mColoring(Digraph g, int v, int[] colors, int m) {

        if (g.size == v) {
            return true;
        } else {
            for (int i = 0; i < colors.length; i++) {
                colors[v] = i;
                if (isSafe(g, v, colors, m)) {
                    mColoring(g, v + 1, colors, m);
                }
            }return false;
        }
        
    }

    /**
     * Metodo que dado un grafo y un vertice v, intenta asignar un color colors
     * en la posicion c al nodo v, de manera que dos nodos adyacentes no poseean
     * el mismo color
     *
     * @param g grafo dado
     * @param c indice de colores
     * @param v vertice
     * @param colors conjunto de colores
     * @return true si es posible, false de lo contrario
     */
    private static boolean isSafe(Digraph g, int v, int[] colors, int c) { //si los colores están bien pintados verdadero
        ArrayList<Integer> sucesoresDev = g.getSuccessors(v);
        for (Integer sucesor : sucesoresDev) {
            int queColorTieneElSucesor = colors[sucesor];
            if (queColorTieneElSucesor == c) {
                return false;
            }
        }
        return true;
    }

}
