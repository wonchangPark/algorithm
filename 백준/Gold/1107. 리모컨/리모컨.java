import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] remoteCon = new boolean[10];

    public static int possible(int n){
        if(n==0){
            if(remoteCon[0]) return 0;
            else return 1;
        }
        int len = 0;
        while(n>0){
            if(remoteCon[n%10]){
                return 0;
            }
            len++;
            n/=10;
        }
        return len;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int brokenNum = Integer.parseInt(br.readLine());
        if(brokenNum != 0){
            String[] broke = br.readLine().split(" ");
            // 고장난 번호를 broken배열에 저장
            for (int i = 0; i < brokenNum; i++)
            {
                remoteCon[Integer.parseInt(broke[i])] = true;
            }
        }

        int ans = n - 100;
        if(ans < 0){
            ans = -ans;
        }

        for(int i=0; i<1000000; i++){
            int len = possible(i);
            if(len > 0){
                // 고장 안남
                int press = i - n; // +,- 누르는 횟수
                if(press < 0){
                    press = -press;
                }
                if(ans > len + press){
                    ans = len + press;
                }
            }
        }

        System.out.println(ans);

    }
}
