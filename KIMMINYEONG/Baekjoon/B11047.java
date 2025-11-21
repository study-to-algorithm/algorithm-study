import java.util.*;

public class B11047{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 동전 종류 수
        int k = sc.nextInt(); // 만들어야 하는 금액

        int[] arr = new int[n]; // 동전 종류 배열

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int count = 0; // 동전 개수

        for(int i=n-1; i>=0; i--){ // 가장 큰 단위의 동전부터 확인
            if(arr[i] <= k){ // 동전 단위가 남은 금액보다 작거나 같으면
                count += k / arr[i]; // 해당 동전으로 만들 수 있는 개수 더하기
                k = k % arr[i]; // 남은 금액 갱신
            }
        }

        System.out.println(count); // 동전 개수 출력

    }

}