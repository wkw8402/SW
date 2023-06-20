import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;


class Solution
{
    public static void main(String args[]) throws Exception
    {
//        System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] td = new int[N][2];

            for (int i = 0; i < N; i++) {
                td[i][0] = sc.nextInt();
                td[i][1] = sc.nextInt();
            }

            Arrays.sort(td, (a, b) -> b[1] - a[1]);

            int start = td[0][1] - td[0][0];
            for (int i = 1; i < N; i++) {
                if (start < td[i][1]) {
                    start -= td[i][0]; //
                } else {
                    start = td[i][1] - td[i][0];
                }
            }
            System.out.println("#" + test_case + " " + start);
        }
    }
}