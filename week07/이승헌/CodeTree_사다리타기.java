package al9rithm.week7;

import java.util.*;

public class CodeTree_사다리타기 {

    static int n, m, ans;
    static int[] result;
    static List<Line> lines;
    static List<Integer> nums;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        ans = 100;

        result = new int[n];

        for(int i = 0; i < n; i++){
            result[i] = i+1;
        }

        lines = new ArrayList<>();
        nums = new ArrayList<>();

        for(int i = 0; i < m; i++){
            int idx = sc.nextInt();
            int depth = sc.nextInt();

            lines.add(new Line(idx, depth));
        }

        Collections.sort(lines);

        for(int i = 0; i < m; i++){
            int idx = lines.get(i).idx;
            swap(result, idx);
        }

        combi(0, 0);
        System.out.println(ans);

    }

    private static void combi(int start, int cnt){

        if(cnt == m){
            check();
            return;
        }

        check();


        for(int i = start; i < m; i++){
            nums.add(i);
            combi(i+1, cnt+1);
            nums.remove(nums.size() - 1);
        }
    }

    private static void check(){
        int[] temp = new int[n];
        for(int i = 0; i< n; i++){
            temp[i] = i+1;
        }

        for(Integer n : nums){
            //System.out.print(n+" ");
            int idx = lines.get(n).idx;
            swap(temp, idx);
        }
        //System.out.println();
        //System.out.println(Arrays.toString(temp));

        boolean eq = true;
        for(int i = 0; i < n; i++){
            if(temp[i] != result[i])
                eq = false;
        }

        if(eq)
            ans = Math.min(ans, nums.size());
    }


    private static void swap(int[] arr , int idx){
        int temp = arr[idx];
        arr[idx] = arr[idx-1];
        arr[idx-1] = temp;
    }

    private static class Line implements Comparable<Line>{
        int idx, depth;
        public Line(int idx, int depth){
            this.idx = idx;
            this.depth = depth;
        }

        @Override
        public int compareTo(Line o){
            if(this.depth == o.depth)
                return this.idx - o.idx;
            return this.depth - o.depth;
        }
    }
}