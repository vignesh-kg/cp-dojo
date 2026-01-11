import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class WayTooLongWords {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int readInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (Exception ex) {

        }
        return -1;
    }

    public static void main(String[] args) {
        int n = readInt();
        try {
            for (int i = 0; i < n; ++i) {
                char[] word = br.readLine().toCharArray();
                if (word.length <= 10) {
                    writer.write(word);
                } else {
                    writer.write(word[0] + String.valueOf(word.length-2) + word[word.length - 1]);
                }
                writer.newLine();
            }
            writer.close();
        } catch (Exception ex) {
        }
    }
}
