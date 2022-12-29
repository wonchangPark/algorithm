import java.util.Scanner;

public class Main
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        if(A >= 10 || A <0 || B >=10 || B < 0){
            System.out.println("error");
        }
        System.out.println(A+B);
    }
}