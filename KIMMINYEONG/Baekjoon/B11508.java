import java.util.*;
// 그리디
public class B11508 {
    public static void main(String[] args){
        //1. 입력된 정보 저장
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;

        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        //2. 내림차순 정렬
        //3개 중 가장 싼 물건을 빼야 하므로
        Arrays.sort(arr, Collections.reverseOrder());

        //3. 3개 중 2개만 더하기
        for(int i=0; i<n; i++){
            if((i+1)%3==0){ // 3번째 물건은 빼기
                continue;
            }
            sum += arr[i];
        }

        System.out.println(sum);

    }
    
}
