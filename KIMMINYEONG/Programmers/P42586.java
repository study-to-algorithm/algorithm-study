package Programmers;
import java.util.*;

public class P42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        // 문제 예시 return 값으로 나갈 리스트
        ArrayList<Integer> a = new ArrayList<>();
        // 남은 최소일수 집어넣을 리스트
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            // 남은 일수가 딱 떨어지는 경우
            if((100-progresses[i])%speeds[i] == 0){
                q.add((100-progresses[i])/speeds[i]);
            }
            // 남은 일수가 애매하게 떨어지는 경우
            else {
                q.add((100-progresses[i])/speeds[i] + 1);
            }
        } 
        
        int num = q.poll(); // 큐에서 위에 있는 값 꺼내기
        int count = 1; // 한개는 무조건 가지고 있음
            while(!q.isEmpty()){ // 큐가 비어질 때 까지
                // 위에서 큐에서 꺼낸 값이 큐의 맨 위에 있는 값보다 같거나 클 때
                if(num >= q.peek()){
                    count++;
                    q.poll();  
                } else {
                    a.add(count); // list에 count한 값 더하기
                    count = 1; // 다시 초기화
                    num = q.poll();
                }
            }
        a.add(count);
        int[] answer = new int[a.size()];
        for(int i=0;i<answer.length; i++){
            answer[i]=a.get(i);
        }
        return answer;
    }  
}