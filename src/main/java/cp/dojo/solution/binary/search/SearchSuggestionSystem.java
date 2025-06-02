package cp.dojo.solution.binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystem {
  public static void main(String[] args) {
    SearchSuggestionSystem s = new SearchSuggestionSystem();
    List<List<String>> result = s.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
    for(List<String> suggestion : result){
        System.out.println(suggestion);
    }
  }

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
      Arrays.sort(products);
      int lb = 0, end = products.length;
      List<List<String>> result = new ArrayList<>();
      String prefix = "";
      for(char ch : searchWord.toCharArray()){
          prefix += ch;
          lb = findLb(products, prefix, lb, end);
          List<String> subList = new ArrayList<>();
          for(int i = lb; i < products.length && i < lb+3; ++i){
              if(!products[i].startsWith(prefix)){
                  end = i;
                  break;
              }
              subList.add(products[i]);
          }
          result.add(subList);
      }
      return result;
  }

  private int findLb(String[] products, String prefix, int low, int high){
      while(low < high){
          int mid = low + (high-low)/2;
          if(prefix.compareTo(products[mid]) <= 0){
              high = mid;
          } else {
              low = mid +1;
          }
      }
      return high;
  }
}
