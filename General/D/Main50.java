import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main50 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        long a = Long.parseLong(ss[0]), b = Long.parseLong(ss[1]), k = Long.parseLong(ss[2]);
        if(a % k != 0) {
            a = (a + k) / k * k;
        }
        long ans = 0;
        for(long i = a; i < b; i += k) {
            ans += i;
        }
        System.out.println(ans);
    }
}