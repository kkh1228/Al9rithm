package Today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_12605_단어순서뒤집기_브론즈2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<>(); 
		
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			String[] arr = str.split(" ");
			for (int j = 0; j < arr.length; j++) {
				stack.push(arr[j]);
			}
			
			System.out.print("Case #"+ i + ": ");
			while(!stack.isEmpty()) {
				System.out.print(stack.pop() + " ");
			}
			System.out.println();
		}
	}
}
