import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ1018 {

    static boolean[][] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        chess = new boolean[n][m];
        int min = 64;

        for(int i =0; i<n; i++)
        {
            String string = br.readLine();
            for(int j = 0; j<m; j++)
            {
                if(string.charAt(j) == 'W'){
                    chess[i][j] = true;
                }
                else{
                    chess[i][j] = false;
                }
            }
        }

        for(int i = 0; i<n-7; i++)
        {
            for(int j = 0; j<m-7; j++)
            {
                min = Math.min(min,solution(i,j));
            }
        }

        System.out.println(min);
    }

    static int solution(int x, int y){

        int count =0;

        boolean color = chess[x][y];

        for(int i=x; i<x+8; i++)
        {
            for(int j=y; j<y+8; j++)
            {
                if(chess[i][j] != color)
                {
                    count++;
                }
                //다음 색
                color = !color;
            }
            //줄바꿈 색
            color = !color;
        }
        //첫번째칸과 다른색으로 칠했을 때의 값과 비교후 작은 거 선택
        count = Math.min(count, 64 - count);
        return count;
    }
}
