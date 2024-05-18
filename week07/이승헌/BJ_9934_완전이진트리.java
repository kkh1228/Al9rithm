package al9rithm.week7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_9934_완전이진트리 {

    static int k;
    static int[] arr;
    static List<Integer>[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        k = sc.nextInt();

        arr = new int[(int)Math.pow(2, k) - 1];
        tree =new ArrayList[k];

        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < k; i++){
            tree[i] = new ArrayList<>();
        }

        findNode(0, arr.length-1, 0);

        for(int i = 0; i < k; i++){
            for(Integer n : tree[i]){
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void findNode(int start, int end, int floor) {

        if(floor == k)
            return;

        int root = (start + end) / 2;
        tree[floor].add(arr[root]);

        findNode(start, root -1, floor + 1);
        findNode(root + 1, end, floor + 1);
    }


}
