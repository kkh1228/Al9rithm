import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split("");

        long ans = 0;

        int[] D = new int [str.length];

        for(int i = 1; i < D.length; i++){
            if(str[i].equals("(")){
                if(str[i-1].equals("("))
                    D[i] = D[i-1] + 1;
                else{
                    D[i] = D[i-1];
                }
            }else{
                D[i] = D[i-1];
            }
        }

        for(int i = 1; i < str.length; i++){
            if(str[i].equals(")")){
                if(str[i-1].equals(")")){
                    ans += D[i];
                }
            }
        }

        System.out.println(ans);
        
    }
}