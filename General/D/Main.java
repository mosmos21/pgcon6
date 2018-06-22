import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        long A = Long.parseLong(ss[0]), B = Long.parseLong(ss[1]), K = Long.parseLong(ss[2]);
        long a = (A + K - 1) / K;
        long b = (B + K - 1) / K;
        long ans = K * ((b - 1) * b / 2 - (a - 1) * a / 2);
        System.out.println(ans);
    }
}