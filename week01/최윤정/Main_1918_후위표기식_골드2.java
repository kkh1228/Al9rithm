package Today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1918_후위표기식_골드2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);
			
			switch (now) {
			
            case '+':
            case '-':
            case '*':
            case '/':
                while (!stack.isEmpty() && prior(stack.peek()) >= prior(now)) {
                    sb.append(stack.pop());
                }
                stack.add(now);
                break;
                
            case '(':
                stack.add(now);
                break;
                
            case ')':
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
                break;
                
            default:
                sb.append(now);
			}
		}
		
		while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());

	}
	
	public static int prior(char oper){
        if(oper =='(' || oper ==')'){
            return 0;
        } else if (oper == '+' || oper == '-') {
            return 1;
        } else if (oper == '*' || oper == '/') {
            return 2;
        }
        return -1;
    }

}
