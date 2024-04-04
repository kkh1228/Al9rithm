
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int N = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();

        int C = 0;

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > C) {
                for (int j = C; j < num; j++) {
                    stack.push(C+1);
//                    System.out.println("현재상위값은" + stack.peek() + "입니다.");
                    C++;
                    stb.append("+").append("\n");
                    if (stack.peek() == num) {
                        stack.pop();
//                        System.out.println("현재상위값은" + stack.peek() + "입니다.");
                        stb.append("-").append("\n");
                    }

                }
            }
            else if(stack.peek()!=num){
                System.out.println("NO");
                return ;
            }
            else {
                stack.pop();
                stb.append("-").append("\n");
             }
            }
        System.out.println(stb);
    }
}






