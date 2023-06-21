import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Possible_3752 {
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            HashSet<Integer> set = new HashSet<>();

            set.add(0); //for pure scores

            int first = sc.nextInt();
            set.add(first);

            for (int i = 1; i < N; i++) {
                int current = sc.nextInt();
                Iterator<Integer> saved = set.iterator();
                ArrayList<Integer> temp = new ArrayList<>();

                while (saved.hasNext()) {
                    temp.add(saved.next() + current);
                }

                set.addAll(temp);
            }
            System.out.println("#" + test_case + " " + set.size());
        }
    }
}
