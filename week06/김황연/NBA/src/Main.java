import java.util.*;
import java.io.*;
//NBA 농구 Silver3 2852번

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,goal,time,a,b,s; // N= 골이 들어간수
        boolean check;
        s = time = a = b = 0;
        N = Integer.parseInt(br.readLine());
        int i =0;
        while(i<N) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("1")){
                check = true;
            }
            else {
                check = false;
            }
            String str = st.nextToken();
            goal = (str.charAt(0)-'0')*600;
            goal += (str.charAt(1)-'0')*60;
            goal += (str.charAt(3)-'0')*10;
            goal += str.charAt(4)-'0';
            if(s>0){
                a += goal - time;
            }
            if(s<0){
                b += goal - time;
            }
            if(check){
                s+=1;
            }
            else {
                s-=1;
            }
            time = goal;
            i++;
        }
        if(s>0) a += 2880 - time;
        if(s<0) b += 2880 - time;
        System.out.printf("%02d:%02d",a/60,a%60);
        System.out.println();
        System.out.printf("%02d:%02d",b/60,b%60);

    }
}