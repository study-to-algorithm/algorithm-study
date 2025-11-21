import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //Integer[] pt = new Integer[n]; // 런타임 에러
        long[] pt = new long[n];

        for(int i = 0; i < n; i++) {
            pt[i] = sc.nextLong();
        }

        Arrays.sort(pt);

        // int max = 0;
        long max = 0;
        //int num = (n%2 == 0) ? n : n-1;

        if(n == 1) {
            System.out.println(pt[0]);
            return;
        }

        if(n%2 != 0) {
            max = pt[n-1];
            n--;
        }

        for(int i = 0; i < n/ 2; i++) {
            long m = pt[i] + pt[n - i - 1];
            if(m > max) max = m;
        }

        System.out.println(max);


    }

}
