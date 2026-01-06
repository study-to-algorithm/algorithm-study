import java.util.*;
import java.io.*;
/*
 * 실버 2 스택
 */

public class B1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 수열을 이르는 1 ~ n까지의 정수
        Stack<Integer> stack = new Stack<>(); // 스택
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }

        int num = 1;
        int cnt = 0;
        while(cnt < n){
            if(!stack.isEmpty() && stack.peek() == arr[cnt]) { // 스택이 비어있지 않고 위에 있는 수가 수열 수와 동일할 경우
                sb.append("-\n");
                stack.pop();
                cnt++;
            }else if(num <= n){
                stack.push(num++);
                sb.append("+\n");
            }else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}