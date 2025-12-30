import java.util.*;

public class B1932 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int [n][n];
        int[][] d = new int[n][n];

        // 1. 입력 받기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

        // 2. 맨 아래 행 초기화
		for (int i = 0; i < n; i++) {
			d[n - 1][i] = arr[n - 1][i];
		}

		// 3. 아래에서 위로 최대 합 계산
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				d[i][j] = Math.max(d[i + 1][j], d[i + 1][j + 1]) + arr[i][j];
			}
		}

		// 4. 꼭대기 값이 정답
		System.out.println(d[0][0]);

    }
}
