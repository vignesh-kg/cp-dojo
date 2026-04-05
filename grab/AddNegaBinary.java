package grab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddNegaBinary {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new AddNegaBinary().addNegabinary(new int[] { 1, 1, 1, 1, 1 }, new int[] { 1, 0, 1 })));
        System.out.println(
                Arrays.toString(new AddNegaBinary().addNegabinary(new int[] { 1 }, new int[] { 1 })));
    }

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        int i = arr1.length - 1, j = arr2.length - 1;
        while (i >= 0 || j >= 0 || carry != 0 ) {
            int sum = 0;
            if (i >= 0) {
                sum += arr1[i--];
            }

            if (j >= 0) {
                sum += arr2[j--];
            }
            sum += carry;
            result.add(sum & 1);
            carry = -(sum >> 1);
        }

        while(result.size() > 1 && result.get(result.size()-1) == 0){
            result.remove(result.size()-1);
        }
        Collections.reverse(result);
        return result.stream().mapToInt(x -> x).toArray();
    }
}
