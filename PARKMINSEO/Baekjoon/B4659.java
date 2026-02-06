import java.util.*;
import java.io.*;

/** 실버 5 문자열
 */


public class B4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] vo = { 'a', 'e', 'i', 'o', 'u'};

        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;

            boolean isTrue = false; // 모음이 있는지, 연속된 문자가 오는지 확인
            for(int i = 0; i < 5; i++){
                if(str.contains(String.valueOf(vo[i]))){
                    isTrue = true;
                    break;
                }
            }

            String result = "<" + str + "> is ";
            if(!isTrue){
                System.out.println(result + "not acceptable.");
                continue;
            }

            int coC = 0; // 자음 count
            int voC = 0; // 모음 count
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(isVowel(c)){ // 모음이라면
                    voC++;
                    coC = 0;
                }else{ // 자음이라면
                    coC++;
                    voC = 0;
                }

                if(voC >= 3 || coC >= 3){ // 3개 이상 연속될 경우
                    isTrue = false;
                    break;
                }

                if(i > 0){
                    char cp = str.charAt(i - 1);
                    if(c == cp && c != 'o' && c != 'e'){ // 연속된 문자가 오지만 그게 o나 e가 아닐 경우
                        isTrue = false;
                        break;
                    }
                }

            }

            if(isTrue) System.out.println(result + "acceptable.");
            else System.out.println(result + "not acceptable.");
        }
    }
    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}