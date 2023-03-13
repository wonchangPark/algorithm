import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int lr = Integer.MAX_VALUE;
        int lc = Integer.MAX_VALUE;
        int mr = Integer.MIN_VALUE;
        int mc = Integer.MIN_VALUE;
        for(int i=0; i<wallpaper.length; i++){
            char[] line = wallpaper[i].toCharArray();
            for(int j=0; j<line.length; j++){
                if(line[j] == '#'){
                    if(lr>i){ // lr은 row 중에서 가장 작은 값을 나타낸다.
                        lr = i;
                    } 
                    if(mr<i){ // mr은 row 중에서 가장 큰 값을 나타낸다.
                        mr = i;
                    }
                    if(lc>j){
                        lc = j;
                    }
                    if(mc<j){
                        mc = j;
                    }
                }
            }
        }
        int[] answer = {lr, lc, mr+1, mc+1};
        return answer;
    }
}