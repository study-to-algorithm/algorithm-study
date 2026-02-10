package Programmers;

public class P42839 {
 public int solution(int n) {
        int answer = 0;
        
        // 1. 에라토스테네스의 체로 거르기 위한 1차원 배열.
        boolean check[] = new boolean[n+1];
        
        // 2. 2부터 n까지의 수들 중
        for(int i =2;i<=n;i++){
            // 2-1. 소수의 배수로써 걸러진 수들은 넘어가고, (4,6,8,9..... 등)
            if(check[i] == true) continue;
            // 2-2. 자신을 제외한 배수를 고려하기 위해 i+i; j<=n;j=j+i 조건으로 걸러준다.
            for(int j=i + i;j<=n;j+=i){
                check[j] = true;
            }
        }
        
        // 3. 걸러지지 않은 수 들의 개수를 카운팅.
        for(int i=2;i<=n;i++){
            if(!check[i]) {
                answer++;
            }
        }

        return answer;
    }
}