
import java.util.Scanner;

/**
 * Exercise 2.1
 *
 * @author Santiago Moreno Rave, Valeria Suárez Mejía
 */
 
public class Exercise21 {

    public static void path (Digraph graf) {
        Scanner sc = new Scanner(System.in);
        Pair<Integer, Integer>[] co;

        int x = sc.nextInt();
        int y = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            Pair<Integer, Integer> position = new Pair<>(num1,num2);
            int n = sc.nextInt();
            co = new Pair[n + 1];
            co[0] = position;

            for (int j = 1; j <= n; j++) {
                int numa = sc.nextInt();
                int numb = sc.nextInt();
                co[j] = new Pair(numa,numb);
            }

            for (int k = 0; k <= n; k++) {
                for (int j = 0; j <= n; j++) {
                    if (k == j) {
                        continue;
                    }
                    graf.addArc(k, j,Math.abs(co[k].first-co[j].first)+Math.abs(co[k].second-co[j].second));
                }
            }
            System.out.println(graf);
        }

    }
}
