package lv2.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * n개의 숫자가 주어지고,
 * 그 중 정확히 서로 다른 3개의 숫자를 골랐을 때 carry 가 전혀 발생하지 않으면서 나올 수 있는 숫자 합의 최댓값을 계산하는 프로그램을 작성해보세요.
 *
 * 여기서 carry란, 수와 수를 더했을 때, 10의 자리를 넘기는 것을 말합니다.
 * 예를 들어 3과 6을 더하면 9가 되고 자리수가 넘어가지않아 carry가 발생하지 않지만, 5와 7은 더하면 12가 되므로 carry가 발생합니다.
 * 또, 81과 72를 더하면 일의 자리를 더할때는 carry가 발생하지 않더라도 십의 자리를 더할 때는 carry가 발생하게 되므로 불가능한 조합입니다.
 * 즉, 각 자리수를 모두 각각 더해봤을 때 10 이상이 되는 경우가 전혀 없어야 한다는 뜻입니다.
 *
 * 입력 형식
 * 첫 번째 줄에는 n이 주어집니다.
 * 두 번째 줄부터는 n개의 줄에 걸쳐 숫자가 주어집니다. 입력으로 주어지는 숫자는 모두 다름을 가정해도 좋습니다.
 * 3 ≤ n ≤ 20
 * 1 ≤ 숫자의 범위 ≤ 10,000
 *
 * 출력 형식
 * carry가 발생하지 않으면서 3개의 숫자의 최대 합을 출력합니다. 모든 숫자쌍에서 carry가 발생할 경우, -1을 출력합니다.
 */
public class Carry피하기2 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 주어지는 수 받기
        List<Integer> numbers = new ArrayList<>();
        for(int i=0; i<N; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }

        int ans = -1;
        // 숫자들 중에서 3개를 고르기
        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                for(int k=j+1; k<N; k++) {
                    if(checkCarry(numbers.get(i), numbers.get(j), numbers.get(k))){
                        continue;
                    }
                    int total = numbers.get(i) + numbers.get(j) + numbers.get(k);
                    ans = Math.max(ans, total);
                }
            }
        }

        System.out.println(ans);
    }

    private static boolean checkCarry(Integer n1, Integer n2, Integer n3) {
        // 주어진 3개의 수로 carry 체크
        int digitValue = 10;
        while (true) {
            if(n1 == 0 && n2 == 0 && n3 == 0) {
                return false;
            }
            // 각 숫자들의 자릿수의 값 가져와서 더하기
            int digitN1 = n1 % digitValue;
            int digitN2 = n2 % digitValue;
            int digitN3 = n3 % digitValue;

            int total = digitN1 + digitN2 + digitN3;
            if(total >= 10) {
                return true;
            }

            n1 /= digitValue;
            n2 /= digitValue;
            n3 /= digitValue;
        }
    }
}
