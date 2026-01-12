package Programmers;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length]; 
        // answer[i] : i번째 가격이 떨어지지 않은 기간

        Stack<Integer> stack = new Stack<>();
        // 가격이 떨어지지 않은 시점의 인덱스를 저장하는 스택

        for (int i = 0; i < prices.length; i++) {
            // 현재 가격이 이전 가격보다 낮아지는 순간
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {

                int idx = stack.peek(); // 가격이 떨어진 시점
                answer[idx] = i - idx; // 유지된 기간 계산
                stack.pop(); // 처리 완료 → 스택에서 제거
            }

            // 아직 가격이 떨어지지 않은 시점 저장
            stack.push(i);
        }

        // 끝까지 가격이 떨어지지 않은 경우 처리
        while (!stack.isEmpty()) {
            int idx = stack.peek();
            answer[idx] = prices.length - idx - 1;  // 끝까지 유지된 기간
            stack.pop();
        }

        return answer;
    }
}
