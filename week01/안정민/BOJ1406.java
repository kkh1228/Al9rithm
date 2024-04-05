import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        for (char ch : line.toCharArray()) {
            leftStack.push(ch);
        }

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L':
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case 'D':
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'P':
                    leftStack.push(command.charAt(2));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.print(sb);
    }
}
