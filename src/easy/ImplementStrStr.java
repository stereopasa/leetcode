package easy;

/**
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * See <a href="https://leetcode.com/problems/implement-strstr/">https://leetcode.com/problems/implement-strstr/</a>
 */
public class ImplementStrStr
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        System.out.println(s.strStr("aaa", "aaaa"));
    }

    private static class Solution
    {
        public int strStr(String haystack, String needle)
        {
            if (needle.length() == 0)
                return -1;

            for (int i = 0; i < haystack.length(); i++)
            {
                for (int j = 0; j < needle.length(); j++)
                {
                    if (j == needle.length())
                        return i;
                    if (i + j == haystack.length())
                        return -1;

                    if (haystack.charAt(i + j) != needle.charAt(j))
                        break;
                }
            }

            return haystack.equals(needle) ? 0 : -1;
        }
    }
}
