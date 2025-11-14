import java.util.*;
import java.io.*;
/*
그리디 알고리즘 : 현재 상태에서 최고의 수를 선택해서 해를 찾는 것
->큰 수를 기준으로 찾기
[문제 요약]
- 운동기구는 두 개씩 짝을 지어 사용함
- 짝지은 두 운동기구의 근손실 합 중 가장 큰 값을 최소로 해야 함
- 운동기구 개수가 홀수라면, 가장 큰 값을 가진 기구는 마지막에 혼자 사용함

[핵심 아이디어]
1. 근손실 값을 오름차순 정렬한다.
2. 짝수 개일 경우 → 가장 작은 값과 가장 큰 값을 짝지어 합을 계산한다.
3. 홀수 개일 경우 → 가장 큰 값을 제외하고 위 방식으로 짝을 짓고,
   남은 가장 큰 값과 비교해 최댓값을 구한다.
4. 근손실 값이 매우 크므로 int 대신 long 사용.
*/

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 운동기구 개수
        long [] m = Arrays.stream(br.readLine().split(" ")) // 근손실
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();
        long max = 0;
        if(n % 2 == 0){ // 만약 짝수이면
            for(int i = 0; i < n/2; i++){ // i번째와 n-i-1번째의 합중에서 제일큰값 찾기
                max = Math.max(max, m[i] + m[n - 1 - i]);
            }
        }else{ // 만약 홀수이면 가장 큰 값은 마지막 운동때 사용, 마지막 값만 제외하고 나머지는 홀수와 동일
            for(int i = 0; i < (n - 1)/2; i++){ // i번째와 n-i-2번째의 합중에서 제일큰값 찾기
                max = Math.max(max, m[i] + m[n - 2 - i]);
            }
            max = Math.max(max, m[n - 1]);
        }
        System.out.println(max);

    }
}