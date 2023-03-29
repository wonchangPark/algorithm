class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        // A-Z 까지의 cnt를 저장한 배열을 만든다. 그러고 그것으로 카운트하면 된다.
        int[] alphabetCnt = new int['z'-'a'+1];
        int len = keymap.length;
        for(int i=0; i<len; i++){
            String temp = keymap[i];
            for(int j=0; j<temp.length(); j++){
                char ch = temp.charAt(j);
                if(alphabetCnt[ch-'A'] == 0){
                    alphabetCnt[ch-'A'] = j+1;
                } else if(alphabetCnt[ch-'A'] > j+1){
                    alphabetCnt[ch-'A'] = j+1;
                }
                
            }
        }
        
        int[] answer = new int[targets.length];
        for(int i=0; i<targets.length; i++){
            int cnt = 0;
            char[] arr = targets[i].toCharArray();
            boolean flag = false;
            for(char c : arr){
                if(alphabetCnt[c-'A'] == 0) {
                    flag = true;
                    break;
                }
                cnt += alphabetCnt[c-'A'];
            }
            if(flag){
                answer[i] = -1;
            } else {
                answer[i] = cnt;
            }
        }
        
        return answer;
    }
}