import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static class Position{
        int wordIndex;
        int index;

        public Position(int wordIndex, int index) {
            this.wordIndex = wordIndex;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for(int i=0; i<N; i++){
            words[i] = br.readLine();
        }

        Integer[] hotKeys = new Integer[N]; // 몇 번째 String에 어떤 단축키가 사용되었는지
        Map<Integer, Position> map = new HashMap<>();

        for(int i=0; i<N; i++){
            String word = words[i];
            String[] temp = word.split(" ");
            if(checkFirstStep(temp, map, hotKeys, i)){
                continue;
            }

            if(checkSecondStep(temp, map, hotKeys, i)){
                continue;
            }

            // 어떠한 것도 단축키로 지정할 수 없으므로 그냥 놔둔다.
            hotKeys[i] = null;

        }

        // 출력하는 단계
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            Integer chIndex = hotKeys[i];
            if(chIndex == null){
                sb.append(words[i]).append("\n");
                continue;
            }

            String[] word = words[i].split(" ");
            Position position = map.get(chIndex);
            for(int j=0; j<word.length; j++){
                for(int k=0; k<word[j].length(); k++){
                    char ch = word[j].charAt(k);
                    if(position.wordIndex == j && position.index == k){
                        sb.append("[").append(ch).append("]");
                    } else {
                        sb.append(ch);
                    }
                }
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean checkFirstStep(String[] word, Map<Integer, Position> map, Integer[] hotKeys, int index) {
        for(int i=0; i<word.length; i++){
            char ch = word[i].charAt(0);
            int chIndex = 0;
            if(Character.isUpperCase(ch)){
                chIndex = ch - 'A';
            } else {
                chIndex = ch - 'a';
            }
            if(map.containsKey(chIndex)){
                continue;
            }

            map.put(chIndex, new Position(i, 0));
            hotKeys[index] = chIndex;
            return true;
        }
        return false;
    }
    private static boolean checkSecondStep(String[] word, Map<Integer, Position> map, Integer[] hotKeys, int index) {
        for(int i=0; i<word.length; i++){
            for(int j=1; j<word[i].length(); j++){
                char ch = word[i].charAt(j);
                int chIndex = 0;
                if(Character.isUpperCase(ch)){
                    chIndex = ch - 'A';
                } else {
                    chIndex = ch - 'a';
                }

                if(map.containsKey(chIndex)){
                    continue;
                }

                map.put(chIndex, new Position(i, j));
                hotKeys[index] = chIndex;
                return true;
            }
        }
        return false;
    }

}
