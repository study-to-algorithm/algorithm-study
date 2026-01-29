package Programmers;
/* 해시 문제인데 두 배열을 정렬후 비교 */
import java.util.*;

public class P42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                return answer;
            }
        }
        
        answer = participant[participant.length - 1];
        return answer;
    }
}