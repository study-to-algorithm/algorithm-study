import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int answer = 0;

        Integer[] coin = new Integer[n];

        for(int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        for(int i = n-1; i >= 0; i--) {
            if(coin[i] <= k) {
                answer += k / coin[i];
                k %= coin[i];
            }
        }

        System.out.println(answer);

    }

}
