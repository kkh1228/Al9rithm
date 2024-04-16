package al9rithm.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_21315_카드섞기 {

    static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int range = (int)(Math.log(n)/Math.log(2));

        for(int i = 1; i <= range; i++){
            for(int j = 1; j <= range; j++){
                if(isEqual(arr, magic(i, j))){
                    System.out.println(i+" "+j);
                    System.exit(0);
                }

            }

        }

    }

    private static boolean isEqual (int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

    private static int[] magic(int a, int b){

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <=n; i++){
            list.add(i);
        }

        int idx = list.size() - 1;
        //System.out.println(a + " " + b);

        for(int k = a; k>= 0; k--){

            for(int i = 0; i < Math.pow(2, k); i++){
                list.add(0, list.remove(idx));
            }
            //System.out.println(list.toString());
            idx = (int)Math.pow(2, k) - 1;
        }

        idx = list.size() - 1;

        for(int k = b; k>= 0; k--){

            for(int i = 0; i < Math.pow(2, k); i++){
                list.add(0 , list.remove(idx));
            }

            idx = (int)Math.pow(2, k) - 1;
        }

        int[] arr2 = new int[list.size()];

        for(int i = 0; i < arr2.length; i++){
            arr2[i] = list.get(i);
        }

        return arr2;
    }


}
