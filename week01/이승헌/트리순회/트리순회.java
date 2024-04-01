package al9rithm.week1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BJ_1991_트리순회 {

    static Map<String, Node> map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String root = sc.next();
            String left = sc.next();
            String right = sc.next();

            map.put(root, new Node(left, right));

        }

        preOrder("A");
        System.out.println();
        inOrder("A");
        System.out.println();
        postOrder("A");


    }

    private static void preOrder(String curNode){

        System.out.print(curNode);
        if(!map.get(curNode).left.equals("."))
            preOrder(map.get(curNode).left);
        if(!map.get(curNode).right.equals("."))
            preOrder(map.get(curNode).right);
    }

    private static void inOrder(String curNode){
        if(!map.get(curNode).left.equals("."))
            inOrder(map.get(curNode).left);
        System.out.print(curNode);
        if(!map.get(curNode).right.equals("."))
            inOrder(map.get(curNode).right);
    }

    private static void postOrder(String curNode){
        if(!map.get(curNode).left.equals("."))
            postOrder(map.get(curNode).left);
        if(!map.get(curNode).right.equals("."))
            postOrder(map.get(curNode).right);
        System.out.print(curNode);
    }


    public static class Node{
        String left, right;
        public Node(String left, String right){
            this.left = left;
            this.right = right;
        }
    }
}
