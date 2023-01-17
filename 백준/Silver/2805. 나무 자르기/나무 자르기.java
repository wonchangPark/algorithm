import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int[] trees = new int[N];
        int highest = 0;
        String[] temp2 = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(temp2[i]);
            if(highest < trees[i]) highest = trees[i];
        }

        // binary search
        // 나무중 제일 높은 높이를 end로 해서 이분탐색을 할 수 있다.
        // log2(1,000,000,000) = 29.xxx 이다. 따라서 로그가 붙으면 얼마 걸리지 않는다.
        // 그리고 이 개수를 N개의 나무를 자른 길이를 따져봤자 30,000,000 으로 1억이 안되므로 1초 안에 해결이 가능하다.
        // 이 밑에는 다시 풀어야 할듯
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = highest;
        while(start<=end){
            int mid = (start+end)/2;

            long totalLength = 0;
            for(int i=0; i<N; i++){
                if(mid < trees[i]){
                    totalLength += (trees[i] - mid);
                }
            }

            if(totalLength < M){ // 자른 전체 길이가 M보다 적은 경우
                end = mid - 1;
            } else if(totalLength == M){
                ans = mid;
                break;
            } else{
                // 자른 전체 길이가 M보다 많은 경우
                ans = mid;
                start = mid + 1;
            }
        }

        System.out.println(ans);

    }
}
