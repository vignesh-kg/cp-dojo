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
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy+extraCandies >= maxCandy);
        }
        return result;
    }
}