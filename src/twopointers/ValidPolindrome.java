package twopointers;

public class ValidPolindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("i was going to find you"));
        System.out.println(isPalindrome("appa"));
        System.out.println(isPalindrome("api"));
        System.out.println(isPalindrome("air"));
        System.out.println(isPalindrome("Was it a car or a cat I saw"));
        System.out.println(isPalindrome("tab a cat"));

    }

    public static boolean isPalindrome(String s) {
        if (s.length()<1 || s.length()>1000)
            return false;
        s=s.replace(" ","").toLowerCase();

        int charSize = s.length();
        
        char[] chars = s.toCharArray();
        int mid;
        if (s.length() % 2 != 0)
            mid = (charSize-1) / 2;
        else
            mid = charSize / 2;

        for (int i=0; i < charSize; i++){
        
            if (chars[i] != chars[(charSize-1)-i])
                return false;

            if (i==mid+1)
                return true;
        }

        return true;


    }

}
