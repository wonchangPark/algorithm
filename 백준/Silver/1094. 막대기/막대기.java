import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int stickNum = 1; // 막대의 개수
        int totalLen = 64; // 막대들의 길이를 모두 더한 총 길이
        int minLen = 64; // 막대 중 가장 짧은 막대의 길이

        while(true){
            if(totalLen > X){
                minLen /= 2;
                stickNum++;
                if(totalLen-minLen >= X){
                    stickNum--;
                    totalLen -= minLen;
                }
            }
            if(totalLen == X) break;
        }

        System.out.println(stickNum);
    }
}
