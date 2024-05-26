package al9rithm.week8;

import java.util.*;

public class CodeTree_최대로연속한숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int m = sc.nextInt();

        TreeSet<Node> set = new TreeSet<>();
        TreeSet<Integer> remove = new TreeSet<>();

        remove.add(-1);
        remove.add(n+1);

        set.add(new Node(n+1, -1, n+1));

        for(int i = 0; i < m; i++){
            int curIdx = sc.nextInt();

            remove.add(curIdx);

            int upper = remove.higher(curIdx);
            int lower = remove.lower(curIdx);

            set.remove(new Node(upper - lower -1, lower, upper));
            set.add(new Node(curIdx - lower - 1 , lower, curIdx));
            set.add(new Node(upper - curIdx - 1, curIdx, upper));

            sb.append(set.first().len).append("\n");

        }
        System.out.println(sb);

    }

    private static class Node implements Comparable<Node>{
        int len, left, right;
        public Node(int len, int left, int right){
            this.len = len;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o){
            if(this.len != o.len)
                return o.len - this.len;
            else if(this.left != o.left)
                return this.left - o.left;
            else
                return this.right - o.right;
        }

    }
}
