package arraysandhasing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "managra"));
        System.out.println(isAnagram("loop", "pool"));
        System.out.println(isAnagram("astro", "ortsi"));
        System.out.println(isAnagram("dople", "dploy"));
        System.out.println(isAnagram("sushi", "sishu"));

        System.out.println();
        System.out.println(isAnagramV2("anagram", "managra"));
        System.out.println(isAnagramV2("loop", "pool"));
        System.out.println(isAnagramV2("astro", "ortsi"));
        System.out.println(isAnagramV2("dople", "dploy"));
        System.out.println(isAnagramV2("sushi", "sishu"));
    }

    public static boolean isAnagramV2(String s, String t) {
        char[] sCharArray = s.toCharArray();
        Arrays.sort(sCharArray);
        char[] tCharArray = t.toCharArray();
        Arrays.sort(tCharArray);

        String sortedS = Arrays.toString(sCharArray);
        String sortedT = Arrays.toString(tCharArray);

        return (sortedS.equals(sortedT));
    }

    public static boolean isAnagram(String s, String t) {

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        if (sCharArray.length != tCharArray.length)
            return false;

        HashMap<Character, Integer> sMap = initCharFrequentMap(sCharArray);
        HashMap<Character, Integer> tMap = initCharFrequentMap(tCharArray);

        for (char c : sCharArray) {
            if (!Objects.equals(sMap.get(c), tMap.get(c)))
                return false;
        }

        return true;
    }

    private static HashMap<Character, Integer> initCharFrequentMap(char[] input) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : input) {
            if (hashMap.containsKey(c))
                hashMap.put(c, hashMap.get(c) + 1);
            else
                hashMap.put(c, 1);
        }
        return hashMap;
    }

}
