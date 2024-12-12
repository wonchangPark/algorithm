package lv2.brute_force_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 0 이상의 정수 N을 2진법으로 나타낸 뒤, 그 숫자들 중 정확히 한 숫자만을 바꾼 숫자 a가 주어졌을 때, 가능한 숫자 N 중 최댓값을 찾는 프로그램을 작성해보세요.
 *
 * 입력 형식:
 * 첫 번째 줄에 a가 주어집니다. a는 전부 숫자 0과 1로 이루어져 있으며, 맨 앞은 0이 아님을 가정해도 좋습니다.
 *
 * 1 ≤ a의 자릿 수 ≤ 10
 */
public class 이상한진수2{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] number = br.readLine().toCharArray();
        int N = Integer.MIN_VALUE;

        // 한자리씩 값을 바꿔가며 N 의 최댓값을 찾는다.
        // 0 만 주어지는 경우엔 하나를 1로 바꿔야 하기 때문에 전체 케이스를 구해야한다.
        for(int i=0; i<number.length; i++) {
            changeNum(number, i);
            // 이진수의 값을 실제값으로 바꾸기
            N = Math.max(N, getNumber(number));

            changeNum(number, i); // 원복
        }
        System.out.println(N);
    }

    public static int getNumber(char[] number) {
        int x = 1;
        int n = 0;
        for(int i=number.length-1; i>=0; i--) {
            n += (Character.getNumericValue(number[i]) * x);
            x *= 2;
        }
        return n;
    }

    public static void changeNum(char[] number, int place) {
        char n = number[place];
        if(n == '0') {
            number[place] = '1';
        } else {
            number[place] = '0';
        }
    }
}
