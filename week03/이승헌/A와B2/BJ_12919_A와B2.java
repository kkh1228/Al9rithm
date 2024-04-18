package al9rithm.week3;

import java.util.*;

public class BJ_12919_A와B2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();


        String start = sc.next();
        String end = sc.next();

        Queue<String> que = new ArrayDeque<>();
        Set<String> set = new HashSet<>();

        que.add(end);

        int ans = 0;

        while(!que.isEmpty()) {
            String s = que.poll();

            if(s.equals(start)){
                ans = 1;
                break;
            }

            if(s.length() == start.length())
                continue;

            if(s.charAt(s.length()-1) == 'A'){
                sb.append(s);
                sb.deleteCharAt(sb.length()-1);
                if(!set.contains(sb.toString())){
                    que.add(sb.toString());
                    set.add(sb.toString());
                }
                sb.delete(0, sb.length());
            }
            if(s.charAt(0) == 'B'){
                sb.append(s);
                sb.reverse();
                sb.deleteCharAt(sb.length()-1);
                if(!set.contains(sb.toString())){
                    que.add(sb.toString());
                    set.add(sb.toString());
                }
                sb.delete(0, sb.length());
            }
        }

        System.out.println(ans);

    }
}
