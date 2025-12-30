import java.util.*;
 
public class B2751 {	
	public static void main(String[] args) {
    
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		
		// list 계열 중 하나를 쓰면 된다.
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(sc.nextInt()); // 숫자 입력해서 list에 추가
		}
		
		Collections.sort(list); // 리스트 정렬
		
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append('\n'); // 정렬된 값 출력
		}

		System.out.println(sb);
	}
}