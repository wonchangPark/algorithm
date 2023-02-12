import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] queue = new int[10001];
    static int front = 1;
    static int back = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] command = br.readLine().split(" ");
            switch(command[0]){
                case "push":
                    queue[back++] = Integer.parseInt(command[1]);
                    break;
                case "pop":
                    if(back==front) System.out.println(-1);
                    else System.out.println(queue[front++]);
                    break;
                case "size":
                    System.out.println(back-front);
                    break;
                case "empty":
                    if(back==front ) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front":
                    if(back==front) System.out.println(-1);
                    else System.out.println(queue[front]);
                    break;
                case "back":
                    if(back==front) System.out.println(-1);
                    else System.out.println(queue[back-1]);
                    break;
            }
        }
    }
}
