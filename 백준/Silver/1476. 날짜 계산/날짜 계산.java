import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문제 1476. 날짜 계산
public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] words = line.split(" ");
        int a = 0;
        int b = 0;
        int c = 0;
        int count = 0;
        while(true){
            a = a % 15 + 1;
            b = b % 28 + 1;
            c = c % 19 + 1;
            count++;

            if(a == Integer.parseInt(words[0]) && b == Integer.parseInt(words[1]) && c == Integer.parseInt(words[2])){
                System.out.println(count);
                break;
            }
        }

    }
}