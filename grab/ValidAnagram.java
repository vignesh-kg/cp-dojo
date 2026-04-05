package grab;

public class ValidAnagram {
    public static void main(String[] args){
        System.out.println(new ValidAnagram().isAnagram("cat", "tac"));
        System.out.println(new ValidAnagram().isAnagram("cat", "rat"));
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] seen = new int[26];
        for(char ch : s.toCharArray()){
            seen[ch - 'a']++;
        }
        
        for(char ch : t.toCharArray()){
            seen[ch - 'a']--;
            if(seen[ch - 'a'] < 0) return false;
        }
        return true;
    }
}
