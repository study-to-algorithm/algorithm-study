public class B4673 {

	public static void main(String[] args) {

		boolean[] c = new boolean[10001]; // 1부터 10000까지 

		for (int i = 1; i < 10001; i++) {

			int s = i;      // 생성자 계산용
			int n = i;   // 자리수 계산용 변수

			while (n != 0) {
				s += n % 10; // 각 자리수 더하기
				n /= 10;
			}

			if (s < 10001) { // 범위 안이면 체크
				c[s] = true;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 10001; i++) {
			if (!c[i]) { // 셀프 넘버만 출력
				sb.append(i).append('\n');
			}
		}

		System.out.println(sb);
	}
}
