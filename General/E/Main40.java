import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main40 {
    public static final int X = 1;
    public static final int O = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]), m = Integer.parseInt(ss[1]);
        int k = Integer.parseInt(br.readLine());
        int[][] field = new int[m][m];
        for(int i = 0; i < k; i++) {
            ss = br.readLine().split(" ");
            int x = Integer.parseInt(ss[0]) - 1;
            int y = Integer.parseInt(ss[1]) - 1;
            field[y][x] = i%2 == 0 ? X : O;
            if(check(field)) {
                System.out.println((i%2 == 0 ? "UNI ": "RITA ") + (i+1));
                return;
            }
        }
        System.out.println("DRAW");
    }

    public static boolean check(int[][] field) {
        for(int i = 0; i < 4; i++) {
            if(field[0][i] > 0 && field[0][i] == field[1][i] && field[0][i] == field[2][i] && field[0][i] == field[3][i]) {
                return true;
            }
        }
        for(int i = 0; i < 4; i++) {
            if(field[i][0] > 0 && field[i][0] == field[i][1] && field[i][0] == field[i][2] && field[i][0] == field[i][3]) {
                return true;
            }
        }
        if(field[0][0] > 0 && field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0] == field[3][3]) {
            return true;
        }
        if(field[0][3] > 0 && field[0][3] == field[1][2] && field[0][3] == field[2][1] && field[0][3] == field[3][0]) {
            return true;
        }
        return false;
    }
}