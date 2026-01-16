import java.io.*;
import java.util.*;

/**
 * 실버 3 그리디
 * 제일 용량이 큰 에너지 드링크에 나머지를 절반씩 다 부으면 그게 최대 용량의 에너지 드링크
 */

public class B9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 에너지 드링크의 수
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        double sum = arr[n - 1];
        for(int i = 0; i < n - 1; i++){
            sum += arr[i] / 2.0;
        }

        System.out.println(sum);
    }
}