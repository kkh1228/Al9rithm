package al9rithm.week8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BJ_20436_ZOAC3 {

    static Map<String, Pos> position = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        initialize();

        Pos left = position.get(sc.next());
        Pos right = position.get(sc.next());

        String[] str = sc.next().split("");

        int time = 0;

        for(String s : str){

            Pos p = position.get(s);

            if(p.dir.equals("l")){

                time += Math.abs(p.x - left.x) + Math.abs(p.y - left.y) + 1;
                left = p;
            }else{

                time += Math.abs(p.x - right.x) + Math.abs(p.y - right.y) + 1;
                right = p;
            }

        }

        System.out.println(time);

    }

    private static void initialize() {
        position.put("q", new Pos("l", 0, 0));
        position.put("w", new Pos("l", 0, 1));
        position.put("e", new Pos("l", 0, 2));
        position.put("r", new Pos("l", 0, 3));
        position.put("t", new Pos("l", 0, 4));
        position.put("y", new Pos("r", 0, 5));
        position.put("u", new Pos("r", 0, 6));
        position.put("i", new Pos("r", 0, 7));
        position.put("o", new Pos("r", 0, 8));
        position.put("p", new Pos("r", 0, 9));
        position.put("a", new Pos("l", 1, 0));
        position.put("s", new Pos("l", 1, 1));
        position.put("d", new Pos("l", 1, 2));
        position.put("f", new Pos("l", 1, 3));
        position.put("g", new Pos("l", 1, 4));
        position.put("h", new Pos("r", 1, 5));
        position.put("j", new Pos("r", 1, 6));
        position.put("k", new Pos("r", 1, 7));
        position.put("l", new Pos("r", 1, 8));
        position.put("z", new Pos("l", 2, 0));
        position.put("x", new Pos("l", 2, 1));
        position.put("c", new Pos("l", 2, 2));
        position.put("v", new Pos("l", 2, 3));
        position.put("b", new Pos("r", 2, 4));
        position.put("n", new Pos("r", 2, 5));
        position.put("m", new Pos("r", 2, 6));


    }

    private static class Pos{
        String dir;
        int x, y;
        public  Pos(String dir, int x, int y) {
            this.dir = dir;
            this.x = x;
            this.y = y;
        }
    }
}
