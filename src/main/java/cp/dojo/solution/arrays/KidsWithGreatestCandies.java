package cp.dojo.solution.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class KidsWithGreatestCandies {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] candies = new int[n];
    IntStream.range(0, n).forEach(i -> candies[i] = sc.nextInt());
    KidsWithGreatestCandies s = new KidsWithGreatestCandies();
    System.out.println(s.kidsWithCandies(candies, sc.nextInt()));
  }

  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int maxCandy = Arrays.stream(candies).max().getAsInt();
    List<Boolean> result = new ArrayList<>(candies.length);
    for (int candy : candies) {
      result.add(candy + extraCandies >= maxCandy);
    }
    return result;
  }
}