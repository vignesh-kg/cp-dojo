import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class WeirdAlgorithm {
        private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private static PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        try {
            long n = readLong();
            writer.printf("%d ", n);
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                } else {
                    n = n * 3 + 1;
                }
                writer.printf("%d ", n);
            }
            writer.flush();
            writer.close();
            reader.close();
        } catch (Exception e) {
        }

    }

    private static long readLong() {
        try {
            return Long.parseLong(reader.readLine());
        } catch (Exception ex) {

        }
        return -1L;
    }
}
