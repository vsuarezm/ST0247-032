import java.util.Stack;

/**
 *
 * @author Santiago Moreno, Valeria Suárez
 */

public class Lab4 {

    public static void tsp(Digraph g, int o) {

        int nodes = g.size();
        boolean[] visited = new boolean[nodes];
        Stack<Integer> stack = new Stack<>();
        visited[o] = true;
        stack.push(o);
        int element = 0;
        int dst = 0;
        boolean min = false;
        int MIN = Integer.MAX_VALUE;
        System.out.println(o);

        while (!stack.isEmpty()) {
            element = stack.peek();
            for (int i = 0; i < nodes; i++) {
                int weight = g.getWeight(element, i);
                if (weight > 0 && !visited[i]) {
                    if (MIN > weight) {
                        MIN = weight;
                        dst = i;
                    }
                    min = true;
                }
            }
            if (min) {
                visited[dst] = true;
                stack.push(dst);
                System.out.println(dst);
                min = false;
            }
            stack.pop();
        }
    }
}
