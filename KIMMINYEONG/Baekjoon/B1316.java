import java.util.Scanner;

public class B1316 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            boolean[] check = new boolean[26]; // 알파벳 등장 여부
            boolean isGroup = true;
            int prev = 0;
            String str = sc.next();

            for (int j = 0; j < str.length(); j++) {
                int now = str.charAt(j);

                // 이전 문자와 다를 경우
                if (prev != now) {

                    // 처음 나온 문자면 체크
                    if (!check[now - 'a']) {
                        check[now - 'a'] = true;
                        prev = now;
                    }
                    // 이미 나온 문자면 그룹 단어 아님
                    else {
                        isGroup = false;
                        break;
                    }
                }
            }

            if (isGroup) cnt++;
        }

        System.out.println(cnt);
    }
}
