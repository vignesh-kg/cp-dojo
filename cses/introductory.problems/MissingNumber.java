import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class MissingNumber {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        try{
            long n = readLong();
            long[] val = readLongArr();
            long sum = 0;
            for(long v : val){
                sum += v;
            }
            writer.println((n*(n+1))/2 - sum);

            writer.close();
            reader.close();
        } catch(Exception ex){}
    }

    private static long readLong() {
        try {
            return Long.parseLong(reader.readLine());
        } catch (Exception ex) {

        }
        return -1L;
    }

    private static long[] readLongArr(){
        try{
            String[] s = reader.readLine().split("\\s+");
            long[] res = new long[s.length];
            for(int i = 0; i < s.length; ++i){
                res[i] = Long.valueOf(s[i]);
            } 
            return res;
        } catch(Exception ex) {

        }
        return new long[]{};
    }
}
