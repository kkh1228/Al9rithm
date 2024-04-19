import java.util.Scanner;

public class BOJ1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = Integer.parseInt(sc.nextLine());
        int number = 666;
        int count = 1;

        while(n != count)
        {
            number++;
            if(String.valueOf(number).contains("666")){
                count++;
            }
        }
        System.out.println(number);
    }
}

