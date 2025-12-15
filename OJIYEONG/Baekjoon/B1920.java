/*
[정렬 + 이진 탐색]
백준 1920번 수 찾기

처음 생각하고 풀었던 풀이
각각 배열 저장 -> 두번째 배열을 하나씩 탐색(for문)하면서 첫 번째 배열 contains인지 아닌지 확인
=> 시간 복잡도 초과

배열 정렬 + 이진 탐색으로 푸는게 시간 복잡도 측면에서 좋음

print도 stringbuilder로 하면 더 최적화 가능
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n]; // 첫 번째 배열

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a); // 정렬

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++){
            int num = Integer.parseInt(st.nextToken());
            BS(a, num);
        }
    }

    // 이진 탐색
    static void BS(int[] arr, int number) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) /2;

            if(arr[mid] == number) {
                System.out.println(1);
                return;
            } else if (arr[mid] < number) {
                left = mid + 1;
            } else right = mid - 1;
        }
        System.out.println(0);
    }
}