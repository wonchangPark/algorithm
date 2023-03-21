import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        
        int cnt1 = 0; // card1의 몇번째인지
        int cnt2 = 0;
        
        for(String word : goal){
            if(cnt1 < cards1.length && word.equals(cards1[cnt1])){
                cnt1++;
                continue;
            } else if(cnt2 < cards2.length && word.equals(cards2[cnt2])){
                cnt2++;
                continue;
            }
            break;
        }
        
        if(cnt1 + cnt2 == goal.length){
            answer = "Yes";
        }
          
        
        return answer;
    }
}