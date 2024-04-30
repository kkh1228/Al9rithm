package al9rithm.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class CodeTree_중간값 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < t; tc++){
            int m = Integer.parseInt(br.readLine());
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int mid = nums[0];

            PriorityQueue<Integer> higher = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> lower = new PriorityQueue<>();
            sb.append(mid).append(" ");

            for(int i = 1; i < m; i++){

                if(i % 2 == 1){

                    if(nums[i] < mid){
                        higher.add(nums[i]);
                    }else{
                        lower.add(nums[i]);
                    }

                }else{
                    int temp = 0;

                    if(higher.size() > lower.size()){
                        temp = higher.poll();
                    }else{
                        temp = lower.poll();
                    }

                    int[] sorted = {temp, nums[i], mid};
                    Arrays.sort(sorted);

                    lower.add(sorted[2]);
                    mid = sorted[1];
                    higher.add(sorted[0]);
                    sb.append(mid).append(" ");

                }

            }

            sb.append("\n");


        }

        System.out.println(sb);


    }
}
