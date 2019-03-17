

/**
 *
 * @author Santiago Moreno y Valeria Suárez
 */

public class Exercise12 {
    
    public static void point2(int n) {
        point2(n, new int[n], 0);
    }

    public static boolean point2(int n, int[] board, int col) {

        if (col == n) {
            printBoard(board);
            return true;
        } else {
            for (int i = 0; i < n; i++) {
                board[col] = i;
                if (notAttack(board, col)) {
                    if (point2(n, board, col + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }

    public static void printBoard(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j) {
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean notAttack(int[] tablero, int elI) {
        for (int i = 0; i < elI - 1; i++) {
            for (int j = i + 1; j < elI; j++) {
                if (Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j) || tablero[i] == tablero[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
