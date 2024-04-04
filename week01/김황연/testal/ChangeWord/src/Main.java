import javax.print.DocFlavor;
//------------------- 스택쓰고 한메소드안에 기능구현----------------
// 이번문제 문제점 어떤방식을 쓸지 제대로 결정을 못하거나, 문제 정답을 맞추고도 예제 출력방식을 잘못이해해서 멀리돌아감;
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int z = 0; z < N; z++) {
            String word = br.readLine();
            String[] tokens = word.split(" ");
            System.out.print("Case #" +(z+1)+": " );
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                stack.push(tokens[i]);
            }

            for( int i=0; i < tokens.length; i++){
                System.out.print (stack.peek()+" ");
                stack.pop();
            }
            System.out.println();
        }

    }
}




//-----------------스택없이 배열로---------------------//

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        var br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            String str = br.readLine();
//            String strArr[] = str.split(" ");
//
//            System.out.print("Case #" + (i + 1) + ": ");
//            for (int j = strArr.length - 1; j >= 0; j--) {
//                System.out.print(strArr[j] + " ");
//            }
//
//            System.out.println();
//        }
//    }
//}

//-------------메소드 분리형식------------------
//import java.util.*;
//import java.io.*;
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        for (int z = 0; z < N; z++) {
//            String word = br.readLine();
//            String[] tokens = word.split(" ");
//            System.out.print("Case #" +(z+1)+": " );
//            changeWord(tokens);
//        }
//
//    }
//
//    static void changeWord(String[] s) {
//        Stack<String> stack = new Stack<>();
//        for (int i = 0; i < s.length; i++) {
//            stack.push(s[i]);
//        }
//
//        for( int i=0; i < s.length; i++){
//            System.out.print (stack.peek()+" ");
//            stack.pop();
//        }
//        System.out.println();
//
//    }
//}
