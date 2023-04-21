import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q5_Longest_Palindromic_Substring {
    public static void main(String[] args) {

        String s = "babad";
        Set<String> set = new HashSet<>();
        String ans = s.substring(0, 1);

        // string s의 처음부터 끝까지 가면서 그 점을 중심으로 잡고 양쪽으로 퍼져나가는 생각
        if (s == null || s.length() < 1) {
            System.out.println("");
        };
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandPalindrome(s, i, i);
            int len2 = expandPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        System.out.println(s.substring(start, end + 1));

    }

    private static int expandPalindrome(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
