import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        // 첫번째 방법
//        z: for(int i=0; i<nums.length; i++){
//            for(int j=i+1; j<nums.length; j++){
//                int num = nums[i] + nums[j];
//                if(num == target){
//                    ans[0] = i;
//                    ans[1] = j;
//                    break z;
//                }
//            }
//        }
//
//        System.out.println(ans[0] + " " + ans[1]);

        // 두번째 방법: hash table을 사용한 방법
        // 더 나은 성능을 위해 hash table을 사용한다.
        // 배열의 수와 인덱스를 매핑하는 것이 더 좋은 방법이다.
        // 그러기 위해서 hash table을 사용한다.
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++){
            int num = target - nums[i];
            if(map.containsKey(num) && map.get(num) != i){
                ans[0] = i;
                ans[1] = map.get(num);
            }
        }

    }
}
