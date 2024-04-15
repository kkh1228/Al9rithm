package al9rithm.week2;

import java.util.Scanner;

public class BJ_2798_블랙잭 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int maxValue = 0;

        for(int a = 0; a < n; a++){
            for(int b = 0; b < n; b++){
                if(a == b)
                    continue;
                for(int c = 0; c < n; c++){
                    if(b == c || a == c)
                        continue;

                    int sum = cards[a] + cards[b] + cards[c];
                    if(sum > maxValue && sum <= m){
                        maxValue = sum;
                    }
                }
            }
        }

        System.out.println(maxValue);
    }
}
