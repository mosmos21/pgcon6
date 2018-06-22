import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String[] x = br.readLine().split(" ");
        int b = Integer.parseInt(br.readLine());
        String[] y = br.readLine().split(" ");
        int c = Integer.parseInt(br.readLine());
        String[] z = br.readLine().split(" ");
        int k = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String t = br.readLine();
        System.out.println(convertTo(convertFrom(s, a, x) + convertFrom(t, b, y), c, z, k));
    }

    public static long convertFrom(String str, int base, String[] fromList) {
        int digit = 0;
        long result = 0;
        while (str.length() > 0) {
            for (int i = 0; i < base; i++) {
                if (str.endsWith(fromList[i])) {
                    result += Math.pow(base, digit++) * i;
                    str = str.substring(0, str.length() - fromList[i].length());
                    break;
                }
            }
        }
        return result;
    }

    public static String convertTo(long num, int base, String[] toList, int digit) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digit; i++) {
            int idx = (int) (num % (long) base);
            sb.insert(0, toList[idx]);
            num /= base;
        }
        return sb.toString();
    }
}