import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsGreatestCandy {
    public static void main(String[] args) {
        KidsGreatestCandy s = new KidsGreatestCandy();
        System.out.println(s.kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = 0;
        for (int candy : candies) {
            if (candy > maxCandy) {
                maxCandy = candy;
            }
        }
        var result = new Boolean[candies.length];
        for (int i = 0; i < candies.length; ++i) {
            result[i] = candies[i] + extraCandies >= maxCandy;
        }

        return Arrays.asList(result);
    }
}