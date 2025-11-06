import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String[] ss = str.split("-");

        String[][] ssp = new String[ss.length][];

        for(int i = 0; i < ss.length; i++) {
            ssp[i] = ss[i].split("\\+");
        }

        int answer = 0;

        for(String s : ssp[0]) {
            answer += Integer.parseInt(s);
        }

        for(int i = 1; i < ssp.length; i++) {
            for(String s : ssp[i]) {
                answer -= Integer.parseInt(s);
            }
        }


        System.out.println(answer);
    }
}
