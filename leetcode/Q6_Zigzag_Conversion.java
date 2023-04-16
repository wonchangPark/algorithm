import java.util.ArrayList;
import java.util.List;

public class Q6_Zigzag_Conversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;

        List<Character>[] conversion = new List[numRows];
        for(int i=0; i<numRows; i++){
            conversion[i] = new ArrayList<>();
        }

        int cnt = 0;
        boolean arrow = true;
        for(int i=0; i<s.length(); i++){
            if(cnt == numRows){
                cnt = numRows == 1 ? 0 : numRows - 2;
                arrow = !arrow;
            } else if(cnt == -1){
                cnt = numRows == 1 ? 0 : 1;
                arrow = !arrow;
            }
            char c = s.charAt(i);
            if(arrow){
                conversion[cnt++].add(c);
            } else {
                conversion[cnt--].add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(List<Character> list : conversion){
            for (Character character : list) {
                sb.append(character);
            }
        }

        System.out.println(sb);
    }
}
