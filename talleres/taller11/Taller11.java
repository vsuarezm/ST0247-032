/**
 * Clase en la cual se implementan los metodos del Taller 11
 * 
 * @author Santiago Moreno, Valeria Suárez
 */
public class Taller11 {

	/**
	* Dado un grafo completo, hallen el costo mínimo del recorrido que pasa por
	* todos los vértices exactamente una vez y vuelve al nodo inicial utilizando
	* programación dinámica
	* @param g grafo dado
	* @param y cadena de caracteres
	* para mas informacion
	* @see <a href="https://en.wikipedia.org/wiki/Held%E2%80%93Karp_algorithm">KMP</a>
	*
	*/
	public static int heldKarp(Digraph g) {
    int n = g.size();
    int npa = (int) Math.pow(2, n);
    int costos [][] = new int[n][np];
    int padres [][] = new int[n][np];
    
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= npa; j++) {
        padres[i][j] = 0;
        if (j ==0){
          costos[i][0] = g.getWeight(i,0);
         }else{
          costos[i][j] = 0;
         }
       }
     }
     return costos;
	}
}
