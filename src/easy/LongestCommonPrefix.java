package easy;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * See <a href="https://leetcode.com/problems/longest-common-prefix/">https://leetcode.com/problems/longest-common-prefix/</a>
 * <p>
 * Solution <a href="https://leetcode.com/articles/longest-common-prefix/">https://leetcode.com/articles/longest-common-prefix/</a>
 */
public class LongestCommonPrefix
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        System.out.println(s.longestCommonPrefix(
                new String[]{
                        "aaaaaaaaabbbbvvv",
                        "aaaaaaaaabbbbvvv",
                        "aaaaaaaaabbbbvvv",
                        "aaaaaaaaabbbbvvv",
                        "aaabaaaaabbbbvvv"
                }
        ));

        System.out.println(s.longestCommonPrefix(
                new String[]{
                        "aa",
                        "a"
                }
        ));

        System.out.println(s.longestCommonPrefix(
                new String[]{
                        "ab",
                        "ac"
                }
        ));

        System.out.println(s.longestCommonPrefix(
                new String[]{
                        "abab",
                        "aba",
                        ""
                }
        ));
    }

    private static class Solution
    {
        public String longestCommonPrefixMine(String[] strs)
        {
            if (strs == null || strs.length == 0)
                return "";

            char[] res = null;
            int resLength = 0;

            for (String str : strs)
            {
                if (res == null)
                {
                    res = str.toCharArray();
                    resLength = res.length;
                    continue;
                }

                char[] chars = str.toCharArray();
                if (chars.length < resLength)
                    resLength = chars.length;

                for (int i = 0; i < resLength && i < chars.length; i++)
                {
                    if (chars[i] != res[i])
                    {
                        resLength = i;
                        break;
                    }
                }
            }

            return resLength != res.length ? new String(Arrays.copyOf(res, resLength)) : new String(res);
        }

        public String longestCommonPrefixHorizontal(String[] strs)
        {
            if (strs.length == 0) return "";
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++)
                while (strs[i].indexOf(prefix) != 0)
                {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) return "";
                }
            return prefix;
        }

        public String longestCommonPrefixVertical(String[] strs)
        {
            if (strs == null || strs.length == 0) return "";
            for (int i = 0; i < strs[0].length(); i++)
            {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++)
                {
                    if (i == strs[j].length() || strs[j].charAt(i) != c)
                        return strs[0].substring(0, i);
                }
            }
            return strs[0];
        }

        /**
         * Divide and conquer approach
         *
         * @param strs
         * @return
         */
        public String longestCommonPrefix(String[] strs)
        {
            if (strs == null || strs.length == 0) return "";
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }

        private String longestCommonPrefix(String[] strs, int l, int r)
        {
            if (l == r)
            {
                return strs[l];
            } else
            {
                int mid = (l + r) / 2;
                String lcpLeft = longestCommonPrefix(strs, l, mid);
                String lcpRight = longestCommonPrefix(strs, mid + 1, r);
                return commonPrefix(lcpLeft, lcpRight);
            }
        }

        String commonPrefix(String left, String right)
        {
            int min = Math.min(left.length(), right.length());
            for (int i = 0; i < min; i++)
            {
                if (left.charAt(i) != right.charAt(i))
                    return left.substring(0, i);
            }
            return left.substring(0, min);
        }


    }
}
