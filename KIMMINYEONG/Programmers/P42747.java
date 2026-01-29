package Programmers;
import java.util.*;

public class P42747 {
   public int solution(int[] citations) {
        // 인용된 횟수 오름차순 정렬
        Arrays.sort(citations);
        int answer = 0;
        
        // 논문 순회
        for (int i = 0; i < citations.length; i++) {
            // 남은 논문의 개수
            int h = citations.length - i;
            
            // 현재 비교 논문의 인용된 횟수가 남은 논문의 개수보다 크거나 같으면
            if (citations[i] >= h) {
                // h 인덱스
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}
