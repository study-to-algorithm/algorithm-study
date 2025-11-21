import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();

        int b = 0;
        int r = 0;
        char color = 'B';
        char c = str.charAt(0);
        if (color == c) b++;
        else r++;

        for(int i = 0; i < n; i++) {
            c = str.charAt(i);
            if(c != color) {
                if(c == 'R') r++;
                else b++;
                color = c;

            }
            else r++;
        }

        System.out.println(Math.min(r, b) + 1);

    }

}
