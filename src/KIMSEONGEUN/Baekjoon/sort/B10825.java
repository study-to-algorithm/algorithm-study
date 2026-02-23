package KIMSEONGEUN.Baekjoon.sort;

import java.util.*;
import java.io.*;

// 문제: 국영수 (실버 4)
public class B10825 {

    // 학생 객체
    static class Student {
        String name;
        int kor, eng, math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            Student[] arr = new Student[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int kor = Integer.parseInt(st.nextToken());
                int eng = Integer.parseInt(st.nextToken());
                int math = Integer.parseInt(st.nextToken());
                arr[i] = new Student(name, kor, eng, math);
            }

            Arrays.sort(arr, (a, b) -> {
                // 1. 국어 점수가 감소하는 순서로
                if (a.kor != b.kor) return Integer.compare(b.kor, a.kor);
                // 2. 국어 점수가 같으면 영어 점수가 증가하는 순서로
                if (a.eng != b.eng) return Integer.compare(a.eng, b.eng);
                // 3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
                if (a.math != b.math) return Integer.compare(b.math, a.math);
                // 4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
                return a.name.compareTo(b.name);
            });

            StringBuilder sb = new StringBuilder();

            for (Student student : arr) {
                sb.append(student.name).append("\n");
            }

            System.out.println(sb);
    }
}

