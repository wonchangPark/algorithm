package lv2.brute_force_search;

import java.io.*;
import java.util.*;

public class 아름다운수열2_최적화{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 수열 B의 빈도표 생성
        Map<Integer, Integer> need = new HashMap<>();
        for (int num : B) {
            need.put(num, need.getOrDefault(num, 0) + 1);
        }

        // 2. 슬라이딩 윈도우 준비: diff map과 diffCount 관리
        Map<Integer, Integer> diff = new HashMap<>();
        int diffCount = 0;

        // 초기 윈도우: A[0] ~ A[M-1]
        for (int i = 0; i < M; i++) {
            int x = A[i];
            int oldVal = diff.getOrDefault(x, 0);
            int newVal = oldVal + 1;
            diff.put(x, newVal);

            int req = need.getOrDefault(x, 0);
            int oldDiff = oldVal - req;
            int newDiff = newVal - req;

            // diff가 0에서 벗어나면 증가, 반대면 감소
            if (oldDiff == 0 && newDiff != 0) {
                diffCount++;
            } else if (oldDiff != 0 && newDiff == 0) {
                diffCount--;
            }
        }

        int answer = 0;
        if (diffCount == 0) {
            answer++;
        }

        // 3. 슬라이딩 윈도우 이동
        for (int i = M; i < N; i++) {
            // 윈도우에서 빠지는 원소 처리 (A[i - M])
            int out = A[i - M];
            int oldVal = diff.getOrDefault(out, 0);
            int newVal = oldVal - 1;
            diff.put(out, newVal);

            int req = need.getOrDefault(out, 0);
            int oldDiff = oldVal - req;
            int newDiff = newVal - req;

            if (oldDiff == 0 && newDiff != 0) {
                diffCount++;
            } else if (oldDiff != 0 && newDiff == 0) {
                diffCount--;
            }

            // 윈도우에 새로 들어오는 원소 처리 (A[i])
            int in = A[i];
            oldVal = diff.getOrDefault(in, 0);
            newVal = oldVal + 1;
            diff.put(in, newVal);

            req = need.getOrDefault(in, 0);
            oldDiff = oldVal - req;
            newDiff = newVal - req;

            if (oldDiff == 0 && newDiff != 0) {
                diffCount++;
            } else if (oldDiff != 0 && newDiff == 0) {
                diffCount--;
            }

            // 모든 diff가 0이면 diffCount == 0
            if (diffCount == 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}

