package al9rithm.week6;

import java.util.*;

public class CodeTree_주사위던지기 {

    static Map<Integer, Dice> map = new HashMap<>();
    static int n, m, r, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt()-1;
        c = sc.nextInt()-1;

        int[][] map = new int[n][n];

        String[] dir = new String[m];

        for(int i = 0; i < m; i++){
            dir[i] = sc.next();
        }

        Dice dice = new Dice(1, 6, 5, 2, 4, 3);

        for(int i = 0; i < m; i++){

            map[r][c] = dice.bottom;

            changeDice(dir[i], dice);

        }
        map[r][c] = dice.bottom;

        int sum = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sum += map[i][j];
            }
        }

        System.out.println(sum);

    }

    private static void changeDice(String dir, Dice dice){

        Dice temp = new Dice(dice.top, dice.bottom, dice.up, dice.down, dice.left, dice.right);

        switch(dir){
            case"L":
                if(c - 1 < 0) return;
                dice.bottom = temp.left;
                dice.top = temp.right;
                dice.up = temp.up;
                dice.down =temp.down;
                dice.left = temp.top;
                dice.right = temp.bottom;
                c--;
                break;
            case"R":
                if(c + 1 >= n) return;
                dice.bottom = temp.right;
                dice.top = temp.left;
                dice.up = temp.up;
                dice.down = temp.down;
                dice.left = temp.bottom;
                dice.right = temp.top;
                c++;
                break;
            case"U":
                if(r-1 < 0) return;
                dice.bottom = temp.up;
                dice.top = temp.down;
                dice.up = temp.top;
                dice.down = temp.bottom;
                dice.left = temp.left;
                dice.right = temp.right;
                r--;
                break;
            case"D":
                if(r+1 >= n) return;
                dice.bottom = temp.down;
                dice.top = temp.up;
                dice.up = temp.bottom;
                dice.down = temp.top;
                dice.left = temp.left;
                dice.right = temp.right;
                r++;
                break;
        }
    }

}

class Dice{
    int top, bottom, up, down, left, right;
    public Dice(int top, int bottom, int up, int down, int left, int right){
        this.top = top;
        this.bottom = bottom;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public void print(){
        System.out.println(top + " , " + bottom + " , " + up + " ,  " + down + " , " + left + " , " + right);
    }
}

