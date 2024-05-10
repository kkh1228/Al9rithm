import java.util.*;
import java.io.*;
//2156번 다이나믹 알고리즘 SilverI 포도주시식문제
public class Main {
static int N;
static int[] arr;
static int[] dp;

    public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    for(int i = 0; i<N; i++){
        arr[i] = Integer.parseInt(br.readLine());
    }
    dp = new int[N];
    for(int i = 0; i<N; i++)
    {
        if(i==0){
            dp[0] = arr[i];
            continue;
        }
        if(i==1){
            dp[1] = arr[0] + arr[1];
            continue;
        }
        if(i==2){
            dp[2] = Math.max(dp[1],Math.max(arr[0]+arr[2], arr[1]+arr[2]));
            continue;
        }
        dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]));
    }
    System.out.println(dp[N-1]);



    }
}