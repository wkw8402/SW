import java.util.Scanner;
import java.util.HashSet;

public class Board_2819 {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            HashSet<String> combinations = new HashSet<>();
            String[][] board = new String[4][4];
            for (int d = 0; d < 4; d++) {
                for (int h = 0; h < 4; h++) {
                    board[d][h] = sc.next();
                }
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(board, i, j, 1, board[i][j], combinations);
                }
            }
            System.out.println("#" + test_case + " " + combinations.size());

        }
    }

    public static void dfs(String[][] b, int i, int j, int depth, String r, HashSet<String> combinations) {
        if (depth == 7) {
            combinations.add(r);
            return;
        }
        //left up right down
        int[] x = {-1, 1, 0, 0};
        int[] y = {0, 0, -1, 1};

        for (int dir = 0; dir < 4; dir++) {
            int newI = y[dir] + i;
            int newJ = x[dir] + j;
            if (newI >= 0 && newI < 4 && newJ >= 0 && newJ < 4) {
                String newSum = r + b[newI][newJ];
                dfs(b, newI, newJ, depth + 1, newSum, combinations);
            }
        }
    }
}
