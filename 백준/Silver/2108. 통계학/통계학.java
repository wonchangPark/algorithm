import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[8001]; // -4000 ~ 4000
        double average = 0; // 산술평균
        int max = Integer.MIN_VALUE; // 최댓값
        int min = Integer.MAX_VALUE; // 최솟값

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            average += n;
            arr[i] = n;
            count[n+4000]++;
            if(max < n) max = n;
            if(min > n) min = n;

        }

        long ansAverage = Math.round(average/N);

//        if(average%N!=0 && average/N<0) {
//            average/=N;
//            average--;
//        } else{
//            average/=N;
//        }
        Arrays.sort(arr);
        int centerNum = arr[N/2];

        int countMax = 0;
        int countNum = 0;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i=0; i<count.length; i++){
            if(count[i]>countMax){
                countMax = count[i];
                countNum = i-4000;
                first = countNum;
                second = Integer.MAX_VALUE;
            } else if(count[i]==countMax){
                if(i-4000<first){
                    second = first;
                    first = i-4000;
                } else if(i-4000<second){
                    second = i-4000;
                }
            }
        }
        if(second == Integer.MAX_VALUE){
            second = first;
        }

        int range = max - min;

        StringBuilder sb = new StringBuilder();
        sb.append(ansAverage).append("\n").append(centerNum).append("\n").append(second).append("\n").append(range);
        System.out.println(sb);

    }
}
