import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Watermelon{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static boolean isEvenFunction(int w){
        return (w & 1) == 0;
    }

    public static void main(String[] args) {
        int w = readInt();
        if(w <= 2 || !isEvenFunction(w)){
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    private static int readInt(){
        try{
            return Integer.parseInt(br.readLine());
        } catch(Exception ex){

        }
        return -1;
    }
}