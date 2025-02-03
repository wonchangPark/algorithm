package lv2.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 아름다운수열2 {
    static int N, M;
    static int[] arrA, arrB;
    static int cnt;

    public static void main(String[] args) throws IOException {
        readArr();

        // 아름다운 수열이라는 것은 결국 arrB 에 있는 원소의 빈도 개수로 판별하면 된다.
        Map<Integer, Integer> need = new HashMap<>();
        for(int num : arrB) {
            need.put(num, need.getOrDefault(num, 0) + 1);
        }


        Map<Integer, Integer> diff = new HashMap<>();
        int needKeySize = need.keySet().size();

        for(int i=0; i<N-M+1; i++) {
            diff.clear();
            int diffCount = 0;
            int[] arr = Arrays.copyOfRange(arrA, i, i + M);
            for(int num : arr) {
                diff.put(num, diff.getOrDefault(num, 0) + 1);
            }
            for(int num : diff.keySet()) {
                if(Objects.equals(diff.get(num), need.get(num))){
                    diffCount++;
                }
            }
            if(diffCount == needKeySize) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }




    private static void readArr() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrA = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        arrB = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
    }
}
