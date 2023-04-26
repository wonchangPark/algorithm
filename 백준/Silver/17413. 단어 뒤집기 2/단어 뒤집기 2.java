import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		String line = br.readLine();
		
		boolean flag = false;
		for(int i=0; i<line.length(); i++) {
			char c = line.charAt(i);
			if(c=='<') {
				sb.append(temp.reverse());
				temp.setLength(0);
				temp.append(c);
				flag = true;
				
			} else if(c=='>') {
				sb.append(temp).append(c);
				temp.setLength(0);
				flag = false;
			} else if(c==' ' && !flag){
				sb.append(temp.reverse()).append(" ");
				temp.setLength(0);
			} else {
				temp.append(c);
			}
		}
		if(temp.length()!=0) {
			sb.append(temp.reverse());
		}
		System.out.println(sb);
	}
}
