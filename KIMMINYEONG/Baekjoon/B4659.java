import java.util.*;
/*
문제 링크 : https://www.acmicpc.net/problem/4659
시간 : 172ms
메모리 : 17756KB
접근 방법: 문자열
*/
public class B4659{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            String str = sc.nextLine();
            if(str.equals("end")) break;

            boolean a = false; // 모음 포함 여부
            boolean b = false; // 연속된 3개의 모음 혹은 자음 여부
            boolean c = false; // 같은 글자가 연속으로 두번 오는지 여부

            int cnt1 = 0; // 연속된 모음 개수 세기
            int cnt2 = 0; // 연속된 자음 개수 세기

            for(int i=0; i<str.length(); i++){
                char s = str.charAt(i);

                if(s=='a' || s=='e' || s=='i' || s=='o' || s=='u'){
                    a = true; // 모음 포함
                    cnt1++;
                    cnt2 = 0;
                    if (cnt1>=3){
                        b=true;
                        break;
                    }
                } else{
                    cnt2++;
                    cnt1 = 0;
                    if (cnt2>=3){
                        b=true;
                        break;
                    }
                }

                if(i>=1){ // 첫번째 글자는 비교 불가하므로 두번째부터 이전 글자와 비교
                    if (str.charAt(i) == str.charAt(i - 1)
                            && str.charAt(i) != 'e' && str.charAt(i) != 'o') {
                        c = true;
                        break;
                    }
                }
            }

            if(!a || b || c){
                System.out.println("<" + str + "> is not acceptable.");
            } else{
                System.out.println("<" + str + "> is acceptable.");
            }
        }
    }
}