import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.OptionalInt;

public class Main60 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int pos;
        while ((pos = find(str)) > -1) {
            str = str.substring(0, pos) + str.substring(pos + 2);
        }
        System.out.println(str.length());
    }

    public static int find(String str) {
        String[] gcp = { "GC", "CP", "PG" };
        OptionalInt pos = Arrays.stream(gcp)
            .mapToInt(s -> str.indexOf(s))
            .filter(idx -> idx > -1)
            .min();
        return pos.orElse(-1);
    }
}