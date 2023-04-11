import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1TwoSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int[] nums = new int[line.length];
        for(int i=0; i<line.length; i++){
            nums[i] = Integer.parseInt(line[i]);
        }

        String line2 = br.readLine();
        int target = Integer.parseInt(line2);

        int[] ans = new int[2];
        z: for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int num = nums[i] + nums[j];
                if(num == target){
                    ans[0] = i;
                    ans[1] = j;
                    break z;
                }
            }
        }

        System.out.println(ans[0] + " " + ans[1]);

    }
}
