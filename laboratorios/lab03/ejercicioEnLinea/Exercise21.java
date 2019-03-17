import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 *
 * @author Santiago Moreno y Valeria Suárez
 */
public class Exercise21 {

    public static int point21(Digraph g, int o) {
        boolean[] visit = new boolean[g.size()];
        int vertices = 0;
        int[] cost = new int[1];
        cost[0] = Integer.MAX_VALUE;
        int size = 0;
        point21Aux(g, o, o, visit, cost, size, vertices);
        return cost[0] == Integer.MAX_VALUE ? 0 : cost[o];
    }

    public static boolean point21Aux(Digraph g, int o, int d, boolean[] visit, int[] cost, int size, int vertices) {

        System.out.println("tamaño: " + size);
        System.out.println("cost: " + cost[0]);
        System.out.println("vertices: " + vertices);
        System.out.println("g: " + g.size());

        if (o == d && g.size() == vertices) {
            if (size < cost[0]) {
                cost[0] = size;
            }
            visit[o] = false;
            return true;
        }

        visit[o] = true;
        vertices++;
        return false;
    }

    private static int minimunCost(Digraph g, int o, int d, boolean[] visited) {
        visited[o] = true;
        int minimunCost = Integer.MAX_VALUE;
        int roadCost = 0;
        if (o == d) {
            return minimunCost;
        } else {
            ArrayList<Integer> branches = g.getSuccessors(o);
            for (Integer brach : branches) {
                if (!visited[brach]) {
                    visited[brach] = true;
                    int re = minimunCost(g, brach, d, visited);
                    if (re == Integer.MAX_VALUE) {
                        roadCost = re;
                    } else {
                        roadCost = g.getWeight(o, d) + re;
                    }
                    if (roadCost < minimunCost) {
                        minimunCost = roadCost;
                    }
                }
            }
            return minimunCost;
        }
    }
}
