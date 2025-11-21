import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder answer = new StringBuilder();
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == 'X') {
                count++;
            } else if (c == '.') {
                if (count > 0) {
                    if (count % 2 != 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer.append("AAAA".repeat(count / 4));
                    answer.append("BB".repeat((count % 4) / 2));
                    count = 0;
                }
                answer.append('.');
            }
        }


        if (count > 0) {
            if (count % 2 != 0) {
                System.out.println(-1);
                return;
            }
            answer.append("AAAA".repeat(count / 4));
            answer.append("BB".repeat((count % 4) / 2));
        }

        System.out.println(answer.toString());
    }
}
