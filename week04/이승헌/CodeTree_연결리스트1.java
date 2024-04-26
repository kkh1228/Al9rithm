package al9rithm.week4;

import java.util.*;

public class CodeTree_연결리스트1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String init = sc.next();
        Node cur = new Node(init);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int order = sc.nextInt();
            String str;

            switch(order){
                case 1:
                    str = sc.next();
                    Node prev = new Node(str);
                    if(cur.prev == null){
                        prev.next = cur;
                        cur.prev = prev;
                    }else{
                        Node temp = cur.prev;
                        prev.prev = temp;
                        prev.next = cur;
                        temp.next = prev;
                        cur.prev = prev;
                    }
                    sb.append(cur.prev.value).append(" ");
                    sb.append(cur.value).append(" ");
                    if(cur.next == null){
                        sb.append("(Null) ");
                    }else{
                        sb.append(cur.next.value).append(" ");
                    }
                    sb.append("\n");
                    break;
                case 2:
                    str = sc.next();
                    Node next = new Node(str);
                    if(cur.next == null){
                        next.prev = cur;
                        cur.next = next;
                    }else{
                        Node temp = cur.next;
                        next.next = temp;
                        next.prev = cur;
                        temp.prev = next;
                        cur.next = next;
                    }

                    if(cur.prev == null){
                        sb.append("(Null) ");
                    }else{
                        sb.append(cur.prev.value).append(" ");
                    }
                    sb.append(cur.value).append(" ");
                    sb.append(cur.next.value).append(" ");
                    sb.append("\n");
                    break;
                case 3:
                    if(cur.prev != null)
                        cur = cur.prev;

                    if(cur.prev == null){
                        sb.append("(Null) ");
                    }else{
                        sb.append(cur.prev.value).append(" ");
                    }
                    sb.append(cur.value).append(" ");
                    if(cur.next == null){
                        sb.append("(Null) ");
                    }else{
                        sb.append(cur.next.value).append(" ");
                    }
                    sb.append("\n");
                    break;
                case 4:
                    if(cur.next != null)
                        cur = cur.next;

                    if(cur.prev == null){
                        sb.append("(Null) ");
                    }else{
                        sb.append(cur.prev.value).append(" ");
                    }
                    sb.append(cur.value).append(" ");
                    if(cur.next == null){
                        sb.append("(Null) ");
                    }else{
                        sb.append(cur.next.value).append(" ");
                    }
                    sb.append("\n");
                    break;

            }
        }

        System.out.println(sb);
    }

    private static class Node{
        String value;
        Node prev;
        Node next;
        public Node(String value){
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}