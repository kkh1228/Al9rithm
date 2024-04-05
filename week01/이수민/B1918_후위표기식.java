import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1918_후위표기식 {
    static class Operator {
        char value;
        int priority;

        public Operator(char value) {
            this.value = value;
            priority = setPriority(value);
        }

        // 해당 연산자의 우선순위 설정
        // 여는 괄호는 닫는 괄호가 나올 때까지 스택에서 뺴면 안 되기 때문에 우선순위를 제일 낮게 설정
        private int setPriority(char value) {
            if(value == '*' || value == '/') return 1;
            if(value == '+' || value == '-') return 0;
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 표기법에 따라 연산자의 위치만 바뀌므로 스택에는 연산자 정보만 저장
        Stack<Operator> stack = new Stack<>();
        String line = br.readLine();

        for(int i=0; i<line.length(); i++) {
            char temp = line.charAt(i);
            Operator operator;

            switch (temp) {
                // 사칙연산의 경우 스택의 최상단 값과 비교
                // 최상단 값이 현재 들어온 연산자보다 우선순위가 높거나 같은 경우 뺴서 저장
                // 위 작업을 수행 후 현재 들어온 연산자를 스택에 추가
                case '+':
                case '-':
                case '*':
                case '/':
                    operator = new Operator(temp);
                    while(!stack.isEmpty() && operator.priority <= stack.peek().priority) {
                        sb.append(stack.pop().value);
                    }
                    stack.add(operator);
                    break;
                // 여는 괄호가 들어온 경우 스택에 추가
                case '(':
                    operator = new Operator(temp);
                    stack.add(operator);
                    break;
                // 닫는 괄호가 들어온 경우 여는 괄호 전까지 스택에서 값을 빼서 저장
                // 스택에 여는 괄호가 남아있기 때문에 여는 괄호 제거
                case ')':
                    while(!stack.isEmpty() && stack.peek().value != '(') {
                        sb.append(stack.pop().value);
                    }
                    stack.pop();
                    break;
                // 피연산자가 들어온 경우 스택에 값을 추가하지 않음
                default:
                    sb.append(temp);
            }
        }

        // 스택에 남아있는 연산자들을 모두 빼서 저장
        while(!stack.isEmpty()) {
            sb.append(stack.pop().value);
        }

        System.out.println(sb.toString());
    }
}
