import java.io.*;
import java.util.*;

/**
 * 실버 5 수학
 * 돌을 1 또는 3개씩 가져갈 수 있음 -> 돌을 가져갈 때마다 돌의 홀짝이 바뀜
 * 돌의 개수가 홀수이면 상근이 차례에 무조건 홀수가 됨
 * ex. 5 : 1->3->1 or 3->1->1 or 1->1->1->1->1
 */

public class B9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        System.out.println(a % 2 == 0 ? "CY" : "SK");
    }
}