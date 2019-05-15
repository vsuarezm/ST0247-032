package carpooling;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Santiago Moreno Rave, Valeria Suárez Mejía
 */
public class Carpooling {

    public static ArrayList<Integer> nodosDirectos = new ArrayList<Integer>();
    public static int numeroTotalCarros;

    /**
     * Metodo para leer un archivo con los duenos de vehiculos y la empresa
     * Complejidad: Mejor y peor caso es O(n*n), donde n es son los duenos de
     * vehiculos y la empresa
     *
     * @param numeroDePuntos El numero de puntos es 1 de la empresa y n-1 de los
     * duenos de vehiculos
     * @return un grafo completo con la distancia mas corta entre todos los
     * vertices
     */
    public static DigraphAM leerArchivo(int numeroDePuntos, float p) {

        final String nombreDelArchivo = "D:\\DATA\\Desktop\\dataset-ejemplo-U=205-p=1.3.txt";
        DigraphAM grafo = new DigraphAM(numeroDePuntos);

        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            lineaActual = br.readLine();

            for (int i = 1; i <= 3; i++) // Descarta las primeras 3 lineas
            {
                lineaActual = br.readLine();
            }
            lineaActual = br.readLine();
            for (int i = 1; i <= numeroDePuntos; i++) { //Descarta los nombres y coordenadas de los vertices
                lineaActual = br.readLine();
            }
            for (int i = 1; i <= 3; i++) // Descarta las siguientes 3 lineas
            {
                lineaActual = br.readLine();
            }
            while (lineaActual != null) { // Mientras no llegue al fin del archivo. Lee la informacion de las aristas
                String[] cadenaParticionada = lineaActual.split(" ");
                grafo.addArc(Integer.parseInt(cadenaParticionada[0]) - 1, Integer.parseInt(cadenaParticionada[1]) - 1, Integer.parseInt(cadenaParticionada[2]));
                if (Integer.parseInt(cadenaParticionada[0]) == 1) {
                    nodosDirectos.add(Integer.parseInt(cadenaParticionada[1]));
                }
                lineaActual = br.readLine();

            }

        } catch (IOException ioe) {
            System.out.println("Error leyendo el archivo de entrada: " + ioe.getMessage());
        }
        return grafo;
    }

    public static ArrayList<Integer> Ordenar(DigraphAM grafo, ArrayList<Integer> nodosDirectos, int inicial) {
        ArrayList<Integer> copia = new ArrayList<>(nodosDirectos);

        for (int i = 0; i < copia.size() - 1; i++) {
            for (int j = i + 1; j < copia.size(); j++) {
                if (grafo.getWeight((inicial), copia.get(i) - 1) > grafo.getWeight((inicial), copia.get(j) - 1)) {
                    int aux = copia.get(i);
                    copia.set(i, copia.get(j));
                    copia.set(j, aux);
                }
            }
        }
        return copia;
    }

    public static ArrayList<ArrayList<Integer>> asignarVehiculos(DigraphAM grafo, float p) {
        ArrayList<ArrayList<Integer>> carros = new ArrayList<>();
        int duracion;
        while (nodosDirectos.size() != 0) {
            int conductor = nodosDirectos.get(nodosDirectos.size() - 1);
            ArrayList<Integer> carro = new ArrayList<>();
            duracion = (int) (p * grafo.getWeight(conductor - 1, 0));
            ArrayList<Integer> cercanos = Ordenar(grafo, nodosDirectos, conductor);
            for (Integer cercano : cercanos) {
                if (carro.size() >= 5) {
                    break;
                }
                if (validar(grafo, duracion, carro, cercano)) {
                    carro.add(cercano);
                    int indice = nodosDirectos.indexOf(cercano);
                    nodosDirectos.remove(indice);
                }

            }
            carros.add(carro);

        }
        numeroTotalCarros = carros.size();
        return carros;
    }

    public static boolean validar(DigraphAM grafo, int duracion, ArrayList<Integer> carro, int cercano) {
        if (carro.isEmpty()) {
            return true;
        }

        int peso = 0, ultimo = carro.get(0);
        for (Integer persona : carro) {
            peso += grafo.getWeight(ultimo - 1, persona - 1);
            ultimo = persona;
        }
        peso += grafo.getWeight(ultimo - 1, cercano - 1) + grafo.getWeight(cercano - 1, 0);
        return duracion >= peso;
    }

    /**
     * Metodo para escribir un archivo con la respuesta Complejidad: Mejor y
     * peor caso es O(n), donde n son los duenos de vehiculo y la empresa
     *
     * @param permutacionParaCadaSubconjunto es una lista de listas con la
     * permutacion para cada subconjunto de la particion de duenos de vehiculo
     */
    public static void guardarArchivo(ArrayList<ArrayList<Integer>> permutacionParaCadaSubconjunto, int numeroDePuntos, float p) {
        final String nombreDelArchivo = "respuesta-ejemplo-U=" + numeroDePuntos + "-p=" + p + ".txt";
        try {
            PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
            for (ArrayList<Integer> lista : permutacionParaCadaSubconjunto) {
                for (Integer duenoDeVehiculo : lista) {
                    escritor.print(duenoDeVehiculo + " ");
                }
                escritor.println();
            }
            escritor.print("Numero total de carros: " + numeroTotalCarros);
            escritor.close();
        } catch (IOException ioe) {
            System.out.println("Error escribiendo el archivo de salida " + ioe.getMessage());
        }
    }

    public static void main(String[] args) {
        //Recibir el numero de duenos de vehiculo y la empresa, y el valor de p por el main
        final int numeroDePuntos = args.length == 0 ? 205 : Integer.parseInt(args[0]);
        final float p = args.length < 2 ? 1.3f : Float.parseFloat(args[1]);
        // Leer el archivo con las distancias entre los duenos de los vehiculos y la empresa
        DigraphAM grafo = leerArchivo(numeroDePuntos, p);

        Carpooling.nodosDirectos = Ordenar(grafo, nodosDirectos, 0);
        // Asignar los vehiculos compartidos
        long startTime = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> permutacionParaCadaSubconjunto = asignarVehiculos(grafo, p);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("El algoritmo tomo un tiempo de: " + estimatedTime + " ms");
        // Guardar en un archivo las abejas con riesgo de colision            
        guardarArchivo(permutacionParaCadaSubconjunto, numeroDePuntos, p);

    }
}
