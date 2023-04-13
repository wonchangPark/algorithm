import java.util.HashSet;
import java.util.Set;

public class Q3_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        String s = "abcabcbb";

        int ans = 0;
        System.out.println(s.length());
        for(int i=0; i<s.length(); i++){
            // boolean[] check = new boolean['z'-'a'+1];
            Set<Character> check = new HashSet<>();
            int cnt = 0;
            boolean flag = false;
            for(int j=i; j<s.length(); j++){
                char c = s.charAt(j);
                if(check.contains(c)){
                    if(ans < cnt){
                        ans = cnt;
                    }
                    flag = false;
                    break;
                } else {
                    check.add(c);
                    cnt++;
                    flag = true;
                }
            }

            if(flag){
                if(ans < cnt){
                    ans = cnt;
                }
            }



        }
        System.out.println(ans);
    }
}
