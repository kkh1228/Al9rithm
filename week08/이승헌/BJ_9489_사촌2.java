package al9rithm.week8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_9489_사촌2 {

    static int n, k, findIdx;
    static int[] arr, parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        StringBuilder sb = new StringBuilder();

        while(true){
            input = br.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            k = Integer.parseInt(input[1]);

            if(n == 0 && k == 0) break;

            arr = new int[n+1];
            parent = new int[n+1];

            findIdx = 0;
            input = br.readLine().split(" ");
            for(int i = 1; i <= n; i++){
                arr[i] = Integer.parseInt(input[i-1]);
                if(arr[i] == k) findIdx = i;
            }

            int parentIdx = 1;

            parent[0] = -1;
            parent[1] = 0;

            for(int i = 2; i <=n; i++){
                parent[i] = parentIdx;
                if(i+1 <= n && arr[i+1] - arr[i] != 1){
                    parentIdx++;
                }
            }
            int cnt = 0;
            for(int i = 1; i <= n; i++){

                if(parent[parent[i]] == parent[parent[findIdx]] && parent[i] != parent[findIdx]) cnt++;
            }

            sb.append(cnt).append("\n");

        }
        System.out.println(sb);
    }
}
