package al9rithm.week3;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_18511_큰수구성하기 {

    static int N, K, size, max;
    static int[] arr;
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        size = String.valueOf(N).length();

        arr = new int[K];
        nums = new int[size];
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
        }

        max = 0;

        cal(0);

        System.out.println(max);
    }
    public static void cal(int cnt){
        if(cnt > 0){
            String s = "";
            for(int i = 0; i < cnt; i++){
                s += nums[i];
            }
            //System.out.println(s);
            if(Integer.parseInt(s) <= N) {
                max = Math.max(max, Integer.parseInt(s));
            }
        }
        if(cnt == size)
            return;


        for(int i = 0; i < K; i++){
            nums[cnt] = arr[i];
            cal(cnt+1);
        }
    }
}
