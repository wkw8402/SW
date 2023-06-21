import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class War_1249 {

    static int[][] field;
    static int[][] distance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {

            int size = sc.nextInt();
            sc.nextLine();

            field = new int[size][size];
            distance = new int[size][size];
            for (int i = 0; i < size; i++) {
                String s = sc.nextLine();

                for (int j = 0; j < size; j++) {
                    field[i][j] = s.charAt(j) - '0';
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }

            dijkstra();

            System.out.println("#" + test_case + " " + distance[size - 1][size - 1]);

        }
    }

    public static class Pair implements Comparable<Pair>{
        int v, h;
        public Pair(int v, int h) {
            this.v = v;
            this.h = h;
        }

        @Override
        public int compareTo(Pair o) {
            return distance[this.v][this.h] <= distance[o.v][o.h] ? -1 : 1;
        }
    }
    public static void dijkstra(){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        distance[0][0] = 0;
        int[] x = {0, 1, 0, -1};
        int[] y = {-1, 0, 1, 0};

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            for (int d = 0; d < 4; d++) {
                int nX = curr.h + x[d];
                int nY = curr.v + y[d];

                if (nX < 0 || nX >= distance.length || nY < 0 || nY >= distance.length) {
                    continue;
                }

                int temp = distance[curr.v][curr.h] + field[nY][nX];

                if (distance[nY][nX] > temp) {
                    distance[nY][nX] = temp;
                    pq.add(new Pair(nY, nX));
                }
            }
        }

    }
}