import java.util.*;
 
public class B2941 {
	public static void main(String[] args) {
    
		Scanner sc = new Scanner(System.in);
        
		String str = sc.next(); // 입력 문자열
        
		int c = 0; // 크로아티아 알파벳 개수
 
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i); // 현재 문자
 
			if(ch == 'c') {			// 만약 ch 가 c 라면?
				if(i < str.length() - 1) { // 다음 문자 확인 가능할 때만
					if(str.charAt(i + 1) == '=') {		//만약 ch 다음 문자가 '=' 이라면?
						// c= 는 한 글자 취급이라 다음 문자 스킵
						i++;		
					}
					else if(str.charAt(i + 1) == '-') { // c- 도 한 글자
						i++;
					}
				}
			}
		    
			else if(ch == 'd') { // d로 시작하는 케이스
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == 'z') { // dz= 가능성
						if(i < str.length() - 2) { // i+2 접근 체크
							if(str.charAt(i + 2) == '=') {	// dz= 일 경우
								// dz= 는 3글자가 1글자라 2칸 더 스킵
								i += 2;
							}
						}
					}
		        
					else if(str.charAt(i + 1) == '-') {	// d- 일 경우
						i++; // 한 글자 처리
					}
				}
			}
		    
			else if(ch == 'l') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == 'j') {	// lj 일 경우
						i++; // lj 한 글자
					}
				}
			}
		    
			else if(ch == 'n') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == 'j') {	// nj 일 경우
						i++; // nj 한 글자
					}
				}
			}
 
			else if(ch == 's') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == '=') {	// s= 일 경우
						i++; // s= 한 글자
					}
				}
		    }
 
			else if(ch == 'z') {
				if(i < str.length() - 1) {
					if(str.charAt(i + 1) == '=') {	// z= 일 경우
						i++; // z= 한 글자
					}
				}
			}
		    
			// 여기까지 걸리면 결국 1글자 처리 완료
			c++;
		}

		System.out.println(c);
	}
}
