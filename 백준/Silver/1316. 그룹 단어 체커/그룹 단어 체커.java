import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            char[] word = br.readLine().toCharArray();
            boolean[] checkAlphabet = new boolean[26]; // a~z 까지 체크하는 리스트
            boolean flag = true;
            for(int j=0; j<word.length; j++){
                int alphabet = word[j] - 'a';
                if(!checkAlphabet[alphabet]){
                    // 만약 알파벳 자리가 false라면
                    checkAlphabet[alphabet] = true;
                } else {
                    if(word[j-1] != word[j]) {
                        flag = false;
                    }
                }
            }
            if(flag) ans++;
        }
        System.out.println(ans);

    }
}
