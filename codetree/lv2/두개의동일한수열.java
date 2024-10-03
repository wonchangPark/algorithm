package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 두개의동일한수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Set<Integer> set = new HashSet<>();
        for(int num : A) {
            set.add(num);
        }

        boolean flag = true;
        for(int num: B) {
            if(!set.contains(num)) {
                flag = false;
                break;
            }
        }


//        Arrays.sort(A);
//        Arrays.sort(B);
//        boolean flag = true;
//        for(int i=0; i<n; i++) {
//            if(A[i] != B[i]) {
//                flag = false;
//                break;
//            }
//        }
//
        System.out.println(flag ? "Yes" : "No");
    }
}
