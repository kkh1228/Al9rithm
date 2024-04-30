package al9rithm.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class CodeTree_좌표압축 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");

        TreeSet<Integer> ts = new TreeSet<>();

        for(String s : input){
            ts.add(Integer.parseInt(s));
        }

        int idx = 1;

        Map<Integer, Integer> map = new HashMap<>();

        for(Integer num : ts){
            map.put(num, idx);
            idx++;
        }


        for(int tc = 0; tc < q; tc++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);


            sb.append(map.get(end) - map.get(start)+1).append("\n");

        }

        System.out.println(sb);

    }
}
