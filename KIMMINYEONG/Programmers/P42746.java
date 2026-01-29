package Programmers;
import java.util.Arrays;

public class P42746 {
    public String solution(int[] numbers) {
        // 정수 배열을 문자열 배열로 변환하기 위한 배열 생성
        String[] arr = new String[numbers.length];

        // int 배열 → String 배열로 변환
        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 문자열 정렬
        // o1, o2를 이어붙였을 때 더 큰 조합이 앞에 오도록 정렬
        // 예: "3"과 "30" 비교 시 "330" vs "303" → "330"이 크므로 "3"이 앞
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 가장 큰 값이 "0"이면, 모든 값이 0이라는 뜻이므로 "0" 반환
        // (예: [0,0,0] → "000" 방지)
        if (arr[0].equals("0")) {
            return "0";
        }

        // 정렬된 문자열들을 하나로 이어 붙이기 위한 StringBuilder
        StringBuilder answer = new StringBuilder();

        // 정렬된 배열의 모든 문자열을 차례대로 이어 붙임
        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }

        // 최종 결과 문자열 반환
        return answer.toString();
    }
}
