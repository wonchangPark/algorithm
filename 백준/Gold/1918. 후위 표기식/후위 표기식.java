import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<chars.length; i++){
            switch (chars[i]){
                case '+':
                case '-':
                    if(stack.isEmpty()){
                        stack.push(chars[i]);
                    }
                    else{
                        if(stack.peek() == '(' ){
                            stack.push(chars[i]);
                        }
                        else{
                            while(stack.peek() != '('){
                                sb.append(stack.pop());
                                if(stack.isEmpty()) break;
                            }
                            stack.push(chars[i]);
                        }

                    }
                    break;
                case '*':
                case '/':
                    if(stack.isEmpty()){
                        stack.push(chars[i]);
                    }
                    else{
                        if(stack.peek() == '('){
                            stack.push(chars[i]);
                        }
                        else{
                            while(stack.peek() == '*' || stack.peek() == '/'){
                                sb.append(stack.pop());
                                if(stack.isEmpty()) break;
                            }
                            stack.push(chars[i]);
                        }
                    }
                    break;
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    while(stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default: sb.append(chars[i]);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}