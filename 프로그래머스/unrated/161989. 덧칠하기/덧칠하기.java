import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
    	int cnt = 0; // 롤러로 페인트칠해야 하는 최소 횟수
        int now = 0; // 지금 페인트가 있는 곳
    	for(int num : section){
        	if(now < num){
            	now = num + m - 1; // section에서의 수는 안칠해진 벽이므로 칠해야한다. 따라서 페인트를 하고 나면 그 범위만큼 나머지 벽들도 칠해진다.
                cnt++;
            }
        
        }
        int answer = cnt;
        return answer;
    }
}