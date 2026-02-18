package KIMSEONGEUN.Baekjoon.dataStructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 문제: 나는야 포켓몬 마스터 이다솜 (실버 4)
public class B1620 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 포켓몬 개수
        int m = Integer.parseInt(st.nextToken()); // 문제 개수

        // 포켓몬 번호 -> 포켓몬 이름 Map
        Map<Integer, String> numMap = new HashMap<>();

        // 포켓몬 이름 -> 포켓몬 번호 Map
        Map<String, Integer> nameMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            numMap.put(i, name);
            nameMap.put(name, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String q = br.readLine();

            char c = q.charAt(0);
            // 첫 글자가 숫자면 번호 map 사용
            if (c >= '0' && c <= '9') {
                int index = Integer.parseInt(q);
                String findName = numMap.get(index);
                sb.append(findName).append('\n');
            } else {
                Integer index = nameMap.get(q);
                sb.append(index).append('\n');
            }
        }

        System.out.println(sb);
    }
}
