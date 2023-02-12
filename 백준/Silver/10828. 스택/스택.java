import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    private static int size = 0;
    private static int[] stack = new int[10000];

    public static void push(int n){
        stack[size++] = n;
        return;
    }

    public static int pop(){
        if(size == 0){
            System.out.println(-1);
            return -1;
        }
        int n = stack[--size];
        System.out.println(n);
        return n;
    }

    public static void size(){
        System.out.println(size);
        return;
    }

    public static void top(){
        if(size == 0){
            System.out.println(-1);
        }
        else
        {
            System.out.println(stack[size - 1]);
        }
        return;
    }

    public static void empty(){
        if(size == 0){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }

    public static void main(String[] args) throws IOException
    {
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       int num = Integer.parseInt(bf.readLine());

       for(int i=0; i<num; i++){
           String line = bf.readLine();
           String[] values = line.split(" ");
           if(values.length == 2){
               push(Integer.parseInt(values[1]));
           }
           else{
               switch (values[0]){
                   case "top": top(); break;
                   case "empty": empty(); break;
                   case "pop": pop(); break;
                   case "size": size(); break;
               }
           }
       }
    }
}
