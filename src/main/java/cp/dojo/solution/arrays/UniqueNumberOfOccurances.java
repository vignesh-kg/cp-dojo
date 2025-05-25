package cp.dojo.solution.arrays;

public class UniqueNumberOfOccurances {
  public boolean uniqueOccurrences(int[] arr) {
    int[] count = new int[2001];
    for(int num : arr){
      count[num+1000] += 1;
    }
    boolean[] used = new boolean[2001];
    for(int i = 0; i < 2001; i += 1){
      if(count[i] != 0 && used[count[i]]){
        return false;
      }
      used[count[i]] = true;
    }
    return true;
  }

  public static void main(String[] args){
    UniqueNumberOfOccurances s = new UniqueNumberOfOccurances();
    System.out.println(s.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    System.out.println(s.uniqueOccurrences(new int[]{1,2,2,1,3}));
  }
}

