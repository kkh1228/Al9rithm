package al9rithm.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_9489_사촌 {

    static int curIdx;
    static int n , k;
    static int[] arr;
    static Node findNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        StringBuilder sb = new StringBuilder();

        while(true){
            input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            k = Integer.parseInt(input[1]);

            if(n == 0 && k == 0) break;

            arr = new int[n];

            input =br.readLine().split(" ");

            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(input[i]);
            }

            Node root = new Node(arr[0]);

            curIdx = 1;
            makeTree(root);

            //findNode.print();

            Node grandParent = findNode.parent.parent;
            int cnt = 0;
            if(grandParent != null && grandParent.child.size() > 0){
                for(int i = 0; i < grandParent.child.size(); i++){
                    if(grandParent.child.get(i).idx == findNode.parent.idx) continue;
                    cnt += grandParent.child.get(i).child.size();
                }
            }

            sb.append(cnt).append("\n");

        }
        System.out.println(sb);
    }

    private static void makeTree(Node parent) {

        if(curIdx == n){
            return;
        }

        parent.child = new ArrayList<>();

        while(curIdx < n){
            Node c = new Node(arr[curIdx]);
            //System.out.print(arr[curIdx]+" ");
            c.parent = parent;
            parent.child.add(c);
            if(curIdx + 1 < n && arr[curIdx + 1]- arr[curIdx] != 1){
                curIdx++;
                break;
            }
            curIdx++;
        }

        for(Node c : parent.child){
            addChild(c);
            if(c.idx == k){
                findNode = c;
            }
        }

        if(curIdx < n){
            for(Node c : parent.child){
                makeTree(c);
            }
        }

    }

    private static void addChild(Node parent){

        parent.child = new ArrayList<>();

        while(curIdx < n){
            Node c = new Node(arr[curIdx]);
            c.parent = parent;
            parent.child.add(c);
            if(c.idx == k){
                findNode = c;
            }
            if(curIdx + 1 < n && arr[curIdx + 1]- arr[curIdx] != 1){
                curIdx++;
                break;
            }
            curIdx++;
        }
    }

    private static class Node{
        Node parent;
        int idx;
        List<Node> child;
        public Node(int idx){
            this.idx = idx;
        }

        public void print(){
            System.out.println(parent + " " + idx + " " + child.size());
        }

    }
}
