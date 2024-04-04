import java.util.Scanner;
import java.util.Stack;

public class BOJ1918 {
    public static int priority(char c){
        if(c == '+' || c =='-'){
            return 1;
        }
        else if(c == '/' || c =='*')
        {
            return 2;
        }
        else{
            return -1;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //중위 표기 식
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            //피연산자 인 경우
            if(Character.isLetter(c)){
                //바로 후위 표시
                sb.append(c);
            }
            else if(c == '('){
                stack.push(c);
            }
            else if(c==')')
            {
                while(!stack.isEmpty() && stack.peek() != '(')
                {
                    sb.append(stack.pop());
                }
                stack.pop();
            }
            else{
                //연산자 일때
                while(!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        // 스택에 남은 연산자 모두 pop
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
