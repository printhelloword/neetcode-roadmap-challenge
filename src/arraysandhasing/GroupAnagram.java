package arraysandhasing;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"anagram", "managra", "uphill", "agnamar", "lihlpu", "bird"}));
        System.out.println(groupAnagrams(new String[]{"", ""}));
        System.out.println(groupAnagrams(new String[]{"anagram", "anagram"}));

        System.out.println();

        System.out.println(groupAnagramsV2(new String[]{"anagram", "managra", "uphill", "agnamar", "lihlpu", "bird"}));
        System.out.println(groupAnagramsV2(new String[]{"", ""}));
        System.out.println(groupAnagramsV2(new String[]{"anagram", "anagram"}));
    }

    public static List<List<String>> groupAnagramsV2(String[] strs) {
        List<List<String>> finalResult = new ArrayList<>();

        Map<String, Objects> frequentMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (frequentMap.containsKey(strs[i])) continue;

            List<String> groupedAnagram = new ArrayList<>();
            groupedAnagram.add(strs[i]);
            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (getSortedString(strs[i]).equals(getSortedString(strs[j]))) {
                    groupedAnagram.add(strs[j]);
                    frequentMap.put(strs[i], null);
                    frequentMap.put(strs[j], null);
                }
            }
            finalResult.add(groupedAnagram.stream().toList());
        }
        return finalResult;
    }

    private static String getSortedString(String input) {
        char[] sCharArray = input.toCharArray();
        Arrays.sort(sCharArray);
        return Arrays.toString(sCharArray);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> finalResult = new ArrayList<>();

        HashMap<String, Objects> frequentMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (frequentMap.containsKey(strs[i])) continue;

            List<String> groupedAnagram = new ArrayList<>();
            groupedAnagram.add(strs[i]);
            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;

                if (isAnagram(strs[i], strs[j])) {
                    groupedAnagram.add(strs[j]);
                    frequentMap.put(strs[i], null);
                    frequentMap.put(strs[j], null);
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
