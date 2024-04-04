package al9rithm.week1;

import java.util.Scanner;
import java.util.Stack;

public class BJ_1874_스택수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int idx = 0;  // 수열을 0번째부터 탐색할 변수
        int num = 1; // 스택에 넣을 숫자  1 부터 n 까지 차례대로 증가

        Stack<Integer> stack = new Stack<>();

        while(idx < n){  // idx 가 n 보다 작을때까지 반복

            if(arr[idx] > num){ // 만약 현재 스택에 넣어야 할 숫자가 수열의 idx 번째보다 작다면
                stack.add(num);  // 스택에 num 을 넣고 num 을 1 증가
                num++;
                sb.append("+\n");  // 스택에 push 연산을 했으므로 + 를 출력
            }else if(arr[idx] == num){ // 만약 현재 스택에 넣을예정인 숫자 num 과 add[idx] 번째가 같다면
                sb.append("+\n");     // 스택에 넣었다가 빼면 되므로  + 출력 후 - 출력 ( 실제로 스택에는 안넣어도 됨 )
                sb.append("-\n");    // 이후에 수열의 다음번 째 수를 탐색해야하기 때문에 idx 와 num 을 1 증가
                idx++;
                num++;
            }else if(arr[idx] < num){  // 만약 arr[idx] 가 현재 넣을 숫자보다 작다면 스택에서 빼서 수열을 만들어야함
                if(stack.peek() == arr[idx]){ // 스택에 가장 위의 숫자가 arr[idx] 와 같다면 빼고 - 출력
                    stack.pop();
                    idx++;
                    sb.append("-\n");
                }else{ // 만약 스택의 가장 위의 숫자가 arr[idx] 와 다르다면 수열을 만들 수 없으므로 NO 출력후 시스템 종료
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }

        System.out.println(sb);
    }
}
