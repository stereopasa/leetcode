package easy;

import java.util.*;

public class ReverseVowelsOfAString
{
    public static void main(String[] args)
    {
//        Given s = "hello", return "holle".
//        Given s = "leetcode", return "leotcede".

        String e1 = "hello";
        String e2 = "leetcode";
        String e3 = "aA";

        Solution s = new Solution();
        System.out.println(s.reverseVowels(e1));
        System.out.println(s.reverseVowels(e2));
        System.out.println(s.reverseVowels(e3));

    }

    private static class Solution
    {
        private Character[] vowels = new Character[]{'a', 'e', 'i', 'o', 'u'};
        private Set<Character> vowelsSet = new HashSet<>(Arrays.asList(vowels));

        public String reverseVowels(String s)
        {
            char[] res = s.toCharArray();

            List<Integer> vowelIndexes = new ArrayList<>();
            String lowerCaseString = s.toLowerCase();
            for (int i = 0; i < lowerCaseString.length(); i++)
            {
                if (vowelsSet.contains(lowerCaseString.charAt(i)))
                    vowelIndexes.add(i);
            }

            for (int i = 0, length = vowelIndexes.size(); i < length / 2; i++)
            {
                swap(res, vowelIndexes.get(i), vowelIndexes.get(length - i - 1));
            }

            return new String(res);
        }

        private void swap(char[] array, int a, int b)
        {
            char tmp = array[a];
            array[a] = array[b];
            array[b] = tmp;
        }
    }
}


