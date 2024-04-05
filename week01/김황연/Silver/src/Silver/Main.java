package Silver;
import java.util.*;
import java.io.*;
public class Main {
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        sum = 0;
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            goodWord(s);
        }
        System.out.print(sum);
    }

    static void goodWord(String s) {
        if (s.length() % 2 == 1) return; //문자열의 길이가 홀수이다는 것은 A 또는 B의 개수가 홀수이므로 좋은단어 X
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0)); //첫 단어는 스택에 push
//        System.out.print(s.charAt(0)); charAT()함수는 뒤에 int숫자를 통해 원하는 위치의 문자를 가져올수있음
        for (int i = 1; i < s.length(); i++) {
            if (stack.size() > 0 && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else { 
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) sum++;
    }
}