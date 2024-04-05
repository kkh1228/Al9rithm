import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1158 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int i = 1; i<=n; i++)
        {
            queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while(!queue.isEmpty()){
            for(int count = 1; count < k; count++) {
                queue.add(queue.poll());
            }
            sb.append(queue.poll());
            if(!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append('>');
        System.out.println(sb);
    }
}
