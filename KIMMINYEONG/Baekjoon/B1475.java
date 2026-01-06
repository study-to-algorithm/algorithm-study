import java.io.*;
import java.util.*;

public class B1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 방 번호 문자열로 받기
        String s = br.readLine();
        // 각 숫자(0~9)가 몇 번 등장하는지 카운트할 배열
        int[] arr = new int[10];

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            // 각 숫자(0~9)가 몇 번 등장하는지 카운트
            // 숫자 6과 9는 서로 뒤집어 사용할 수 있으므로
            // 동일한 숫자로 취급하여 함께 계산
            if (num == 9) num = 6; // 9 → 6
            arr[num]++;
        }
		
        // 6과 9는 서로 뒤집어 사용할 수 있으므로
        // 두 숫자의 개수를 합산한 후 2로 나누어 올림
        arr[6] = arr[6]/2 + arr[6]%2;
		
        Arrays.sort(arr);
        System.out.println(arr[9]);
    }
}
