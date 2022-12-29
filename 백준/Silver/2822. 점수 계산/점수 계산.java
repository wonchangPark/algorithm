import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] list = new int[8];
        int[] sortList = new int[8];
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0; i<8; i++){
            int num = Integer.parseInt(br.readLine());
            list[i] = num;
            sortList[i] = num;
        }

        int[] ans = new int[5];
        int cnt = 0;
        int sum = 0;
        Arrays.sort(sortList);
        for(int i=3; i<8; i++){
            for(int j=0; j<8; j++){
                if(sortList[i] == list[j]){
                    sum += list[j];
                    ans[cnt++] = j;
                }
            }
        }

        Arrays.sort(ans);
        sb.append(sum).append("\n");
        for(int i=0; i<ans.length; i++){
            sb.append(ans[i]+1).append(" ");
        }

        System.out.println(sb);


    }
}
