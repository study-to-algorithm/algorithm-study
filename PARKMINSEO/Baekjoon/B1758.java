import java.util.*;
import java.io.*;
/**
 * 실버 4 그리디
 * 팁을 제일 많이 주겠다고 생각한 사람을 우선순위로 두면 최대값을 구할 수 있음
 */

public class B1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 사람의 수
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            int tip = Integer.parseInt(br.readLine()); // 각 사람들이 생각한 팁 액수
            arr[i] = tip;
        }
        Arrays.sort(arr); // 오름차순대로 정렬

        long sum = 0; // 팁 최댓값
        for(int i = 0; i < n; i++){
            int tip = arr[n - i - 1] - i; // 오름차순 정렬이기 때문에 끝에 있는게 제일 큰 수
            if(tip > 0) // 팁이 0보다 클 경우에만 합
                sum += tip;
        }
        System.out.println(sum);
    }
}