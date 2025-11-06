import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        int count = 1;

        while (b > a) {
            if (b % 2 == 0) b /= 2;
            else if (b % 10 == 1) b /= 10;
            else {
                count = -1;
                break;
            }
            count++;
        }

        if (b != a) count = -1;

        System.out.println(count);
    }
}
