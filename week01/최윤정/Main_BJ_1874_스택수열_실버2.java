package Today;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_1874_스택수열_실버2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		
		Stack<Integer> stack = new Stack<>();
		
		int start = 1;
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= n; i++) {
			stack.push(i);
			sb.append('+').append('\n');
			while(!stack.empty() && stack.peek() == arr[start]) {
				stack.pop();
				sb.append('-').append('\n');
				start++;
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}
}
