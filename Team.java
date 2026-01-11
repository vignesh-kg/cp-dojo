import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Team {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int readInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (Exception ex) {

        }
        return -1;
    }

    private static int[] readIntArray() {
        try {
            String line = br.readLine();
            if (line == null || line.trim().isEmpty()) {
                return new int[0]; // Return empty array if input is blank
            }

            // Split by one or more whitespace characters
            String[] parts = line.trim().split("\\s+");
            int[] arr = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            return arr;

        } catch (Exception ex) {
            // Log error or handle appropriately
            return null;
        }
    }

    public static void main(String[] args) {
        int n = readInt();
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int curRes = 0;
            int[] vote = readIntArray();
            curRes += vote[0] + vote[1] + vote[2];
            if (curRes >= 2) {
                ++res;
            }
        }
        System.out.println(res);
    }
}
