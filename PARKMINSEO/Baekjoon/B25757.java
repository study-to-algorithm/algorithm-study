import java.io.*;
import java.util.*;

/**
 * 실버 5 구현
 */

public class B25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> hash = new HashSet<>();

        int n = Integer.parseInt(st.nextToken()); // 총 사람 수
        String game = st.nextToken(); // 게임 종류
        int gn; // 게임 참가 인원

        if(game.equals("Y")) gn = 2; // 윷놓이
        else if(game.equals("F")) gn = 3; // 같은 그림 찾기
        else gn = 4; // 원카드

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            hash.add(st.nextToken()); // 중복없이
        }

        int size = hash.size(); // 게임에 참여할 수 있는 총 사람 수

        System.out.println(size / (gn - 1));
    }
}