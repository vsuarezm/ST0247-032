import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import javafx.util.Pair;
import java.util.ArrayDeque;

/**
 *
 * @author Santiago Moreno y Valeria Suárez
 */
public class Exercise11 {
    
    static ArrayDeque<Pair<Integer,Double>> queue = new ArrayDeque();

    private static double[] fill(int tam) {
        double[] a = new double[tam];
        Arrays.fill(a, Integer.MAX_VALUE);
        a[0] = 0;
        return a;
    }

    public static boolean point1Aux(HashMap<Integer, Pair<Vertex, LinkedList<Edge>>> g, int originID, int destinyID) {

        boolean[] visited = new boolean[g.size()];
        return point1(g, originID, destinyID, visited);
        

    }

    public static boolean point1(HashMap<Integer, Pair<Vertex, LinkedList<Edge>>> g, int originID, int destinyID, boolean[] visited) {
        
        Digraph info = new Digraph();
        visited[originID] = true;
         ArrayDeque<Pair<Integer,Double>> queueAux = new ArrayDeque();
        if (originID == destinyID) {
            return true;
        } else {
            ArrayList<Integer> successors = info.getSuccessors(g, originID);
            for (int i = 0; i < successors.size(); i++) {
                if (!visited[i]) {
                    visited[i]=true;
                    Pair pair= new Pair(successors.get(i),info.getWeight(g,originID,successors.get(i)));
                    queue.add(pair);
                    if (point1(g, successors.get(i),destinyID,visited)) {
                        if(replaceQueue(queueAux)){
                            return true;
                        }else{
                            queueAux.clear();
                        }
                    }
                }
            }

        }
        return false;
    }
    
    public static boolean replaceQueue( ArrayDeque<Pair<Integer,Double>> queueAux ){
        if(queue.isEmpty()&& !queueAux.isEmpty()){
            queue=queueAux;
        }else {
            double distance=0.0;
            double distanceAux=0.0;
           
            while(!queue.isEmpty()){
                distance+=queue.poll().getValue();
            }
            while(!queueAux.isEmpty()){
                distanceAux+=queueAux.poll().getValue();
            }
            if(distanceAux<distance){
                queue=queueAux;
                return true;
            }else{
                queueAux.clear();
            }
        }
        
        return false;
    
    }
}
