import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BOJ1303 {
    static char[][] field;
    static int n,m;
    static boolean[][] visited;
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //가로 크기
        n = Integer.parseInt(st.nextToken());
        //세로 길이
        m = Integer.parseInt(st.nextToken());

        field = new char[m][n];
        visited = new boolean[m][n];

        //field 받기
        for(int i=0; i<m; i++){
            String line = br.readLine();
            for(int j=0; j<n; j++){
                field[i][j] = line.charAt(j);
            }
        }

        int powerW=0, powerB=0;
        for(int i =0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(!visited[i][j])
                {
                    int power = dfs(i,j,field[i][j]);
                    if(field[i][j]=='W'){
                        powerW += power*power;
                    }
                    else{
                        powerB += power*power;
                    }
                }
            }
        }
        System.out.println(powerW+" " + powerB);
    }

    private static int dfs(int x, int y, char team) {
        //그래프를 벗어나거나 다른 팀이면
        if(x<0  || y<0 || x>=m || y>=n || visited[x][y] || field[x][y] != team){
            return 0;
        }
        visited[x][y] = true;
        int power = 1;
        for(int i =0; i<4; i++)
        {
            power += dfs(x+dx[i],y+dy[i], team);
        }
        return power;
    }
}
