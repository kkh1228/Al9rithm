import java.util.*;
import java.io.*;
//2775번,BronzeI   부녀회장이될테야(다이나믹 프로그래밍)
public class Main {
static int T,sum;
static int K,N,X;// K= 층 N=호수

static int[][] arr;
static int[] people;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        arr = new int[15][15];
        for(int j = 1; j<=14; j++)
        {

            arr[0][j] = j;
        }
        for(int y=1; y<15; y++)
            for(int j=1; j<15; j++)
            {
                X = 1;
                while (X<=j) {
                    arr[y][j] += arr[y-1][X];
                    X++;
                }
            }
        for(int i = 0; i < T; i++)
        {
            K = Integer.parseInt(br.readLine());
            N = Integer.parseInt(br.readLine());
            System.out.println(arr[K][N]);
        }

    }
}