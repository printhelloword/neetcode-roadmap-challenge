package arraysandhasing;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
//        System.out.println(groupAnagrams(new String[]{"anagram", "managra", "uphill", "agnamar", "lihlpu", "bird"}));
        System.out.println(groupAnagrams(new String[]{"",""}));
        System.out.println(groupAnagrams(new String[]{"anagram","anagram"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalResult = new ArrayList<>();

        HashMap<String, Objects> frequentMap = new HashMap<>();
        for (String string : strs) {
            if (frequentMap.containsKey(string)) continue;

            List<String> groupedAnagram = new ArrayList<>();
            groupedAnagram.add(string);
            for (String string1 : strs) {
                if (string.equals(string1)) continue;

                if (isAnagram(string, string1)) {
                    groupedAnagram.add(string1);
                    frequentMap.put(string, null);
                    frequentMap.put(string1, null);
                }
            }
            finalResult.add(groupedAnagram.stream().toList());
        }
        return finalResult;
    }

    private static HashMap<Character, Integer> generateCharFrequentMap(char[] input) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : input) {
            if (hashMap.containsKey(c))
                hashMap.put(c, hashMap.get(c) + 1);
            else
                hashMap.put(c, 1);
        }
        return hashMap;
    }

    public static boolean isAnagram(String s, String t) {

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        if (sCharArray.length != tCharArray.length)
            return false;

        HashMap<Character, Integer> sMap = generateCharFrequentMap(sCharArray);
        HashMap<Character, Integer> tMap = generateCharFrequentMap(tCharArray);

        for (char c : sCharArray) {
            if (!Objects.equals(sMap.get(c), tMap.get(c)))
                return false;
        }

        return true;
    }
}
