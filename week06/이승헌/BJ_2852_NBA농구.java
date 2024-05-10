package al9rithm.week6;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2852_NBA농구 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int a = 0;
        int b = 0;

        int timeA = 0;
        int timeB = 0;

        int lastTime = 0;

        for(int i = 0; i < n; i++){

            int team = sc.nextInt();

            String[] time = sc.next().split(":");
            int curTime = 0;

            curTime += Integer.parseInt(time[0])*60;
            curTime += Integer.parseInt(time[1]);

            if(a == b){

            }else if(a > b){

                timeA += (curTime - lastTime);

            }else if(a < b){
                timeB += (curTime - lastTime);
            }
            lastTime = curTime;

            if(team == 1){
                a++;
            }else{
                b++;
            }

            if(a == b){

            }else if(a > b){

                timeA += (curTime - lastTime);

            }else if(a < b){
                timeB += (curTime - lastTime);
            }

        }

        int curTime = 48*60;

        if(a == b){

        }else if(a > b){

            timeA += (curTime - lastTime);

        }else if(a < b){
            timeB += (curTime - lastTime);
        }


        System.out.println((timeA/60 < 10 ? "0" + timeA/60 : timeA/60) +":" + (timeA%60 < 10 ? "0"+timeA%60 : timeA%60));
        System.out.println((timeB/60 < 10 ? "0" + timeB/60 : timeB/60) +":" + (timeB%60 < 10 ? "0"+timeB%60 : timeB%60));
    }
}
