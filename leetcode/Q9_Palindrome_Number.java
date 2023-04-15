import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9_Palindrome_Number {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방법1. char배열로 만들어서 두 개의 포인터를 사용하여 탐색하기
//        char[] x = br.readLine().toCharArray();
//        int start = 0;
//        int end = x.length - 1;
//
//        boolean ans = true;
//        while(start < end){
//            if(x[start] == x[end]){
//                start++;
//                end--;
//            } else {
//                ans = false;
//                break;
//            }
//        }

        // 위의 방법도 괜찮긴 하지만 constant 영역에 굳이 소모할 필요없는 String 공간을 소모하게 된다.
        // 방법2. 수 자체를 거꾸로 돌려서 만든다음에 그 수를 원래 수랑 비교해본다.
        int x = 1234321;
        System.out.println(IsPalindrome(x));
    }

    public static boolean IsPalindrome(int x){

        if(x<0 || (x%10==0 && x!=0)){
            return false;
        }

        int revertNum = 0;
        while(x > revertNum){
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }

        return x == revertNum || x == revertNum/10;
    }
}
