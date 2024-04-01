import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;

        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Number> pq = new PriorityQueue<>();
        
        input = br.readLine().split(" ");

        for(int i = 0; i < n; i++){
            int cur = Integer.parseInt(input[i]);
            
            if(map.get(cur) == null){
                map.put(cur, 1);
            }else{
                map.put(cur, map.get(cur) + 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new Number(entry.getKey(), entry.getValue()));
        }

        for(int i = 0 ; i < k; i++){
            bw.write(pq.poll().num+" ");
        }
        bw.flush();
        bw.close();     
    }

    private static class Number implements Comparable<Number>{

        int num, cnt;

        public Number(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Number n){
            if(this.cnt == n.cnt){
                return n.num - this.num;
            }
            return n.cnt - this.cnt;
        }
    }
} 