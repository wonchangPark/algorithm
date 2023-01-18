
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준
// 1로 만들기
// 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지이다.
// 1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
// 2. X가 2로 나누어 떨어지면, 2로 나눈다.
// 3. 1을 뺀다.
// 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만드려고 한다. 연산을 사용하는 횟수의 최솟값을 구해라.
public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(dp(n));
		

	}
	
	public static int dp(int n) {
		int[] memo = new int[1000001];
		memo[1] = 0;
		memo[2] = 1;
		memo[3] = 1;
		for(int i=4; i<=n; i++) {
			int temp = memo[i-1] + 1;
			if(i%3==0) { 
				temp = temp>memo[i/3]+1 ? memo[i/3]+1 : temp;
			} 
			if(i%2==0) {
				temp = temp>memo[i/2]+1 ? memo[i/2]+1 : temp;
			}
			memo[i] = temp;
		}
		return memo[n];
	}

}
