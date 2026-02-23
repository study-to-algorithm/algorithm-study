package KIMSEONGEUN.Baekjoon.dataStructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

// 문제: 생태학 (실버 2)
public class B4358 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // TreeMap은 객체를 저장하면 자동으로 키 오름차순 정렬
        Map<String, Integer> treeMap = new TreeMap<>();

        StringBuilder sb = new StringBuilder();

        String name;
        int total = 0;

        while ((name = br.readLine()) != null) {
            total++;
            // 만약에 해당 name으로 된 종이 없으면 put, 있으면 get해서 value + 1;
            treeMap.put(name, treeMap.getOrDefault(name, 0) + 1);
        }

        for (String s : treeMap.keySet()) {
            double per = ((double) treeMap.get(s) * 100) / total;
            sb.append(s).append(" ").append(String.format("%.4f", per)).append('\n');
        }

        System.out.println(sb);
    }
}
