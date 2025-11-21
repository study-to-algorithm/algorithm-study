import java.util.*;
// 그리디

public class B14916 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); // 저장

        int n = sc.nextInt();
        int count = 0;

        while(true){ // 무한루프
            if(n%5==0){ // 5로 나누어 떨어지면
                count += n/5; // 5로 나눈 몫을 count에 더함
                System.out.println(count);
                break;
            } else{
                n -= 2; // 5로 나누어 떨어지지 않으면 2를 빼줌
                count++; // 2를 뺀 횟수를 count에 더함
                // 이러면 5로 나누어 떨어질 때까지 2를 빼는 과정이 반복됨
                // 무한 루프에 빠짐
            } if(n<0){ // n이 음수가 되면
                System.out.println(-1); // -1 출력
                break; // 종료
        }

    }
}
}