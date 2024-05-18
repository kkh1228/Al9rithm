package al9rithm.week7;

import java.util.Scanner;

public class CodeTree_2n개의숫자중에n개고르기 {

    static int n, total, ans;
    static int[] nums, arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        nums = new int[n];
        arr = new int[n*2];
        ans = 2000000;

        for(int i = 0; i < n*2; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        combi(0, 0);

        System.out.println(ans);
    }

    private static void combi(int start, int cnt){

        if(cnt == n){

            ans = Math.min(check(), ans);
            return;
        }

        for(int i = start; i < n*2; i++){
            nums[cnt] = i;
            combi(i + 1, cnt + 1);
        }

    }

    private static int check(){

        int sum = 0;

        for(Integer i : nums){
            sum += arr[i];
        }

        return Math.abs(sum*2 - total);
    }
}
