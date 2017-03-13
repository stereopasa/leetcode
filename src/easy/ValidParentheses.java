package easy;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 * See <a href="https://leetcode.com/problems/valid-parentheses/">https://leetcode.com/problems/valid-parentheses/</a>
 */
public class ValidParentheses
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        long start = LocalTime.now().getNano();
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
        System.out.println(s.isValid(")}{({))[{{[}"));
        System.out.println(s.isValid("([])"));
        System.out.println(s.isValid("(("));

        System.out.println(TimeUnit.NANOSECONDS.toMillis(LocalTime.now().getNano() - start));

        start = LocalTime.now().getNano();
        System.out.println(s.isValidMine("()[]{}"));
        System.out.println(s.isValidMine("(]"));
        System.out.println(s.isValidMine(")}{({))[{{[}"));
        System.out.println(s.isValidMine("([])"));
        System.out.println(s.isValidMine("(("));

        System.out.println(TimeUnit.NANOSECONDS.toMillis(LocalTime.now().getNano() - start));
    }

    private static class Solution
    {
        Map<Character, Character> map = new HashMap<>();

        {
            map.put('(', ')');
            map.put('{', '}');
            map.put('[', ']');
        }

        public boolean isValidMine(String s)
        {
            if (s.length() % 2 != 0)
            {
                return false;
            }

            LinkedList<Character> queue = new LinkedList<>();
            for (char ch : s.toCharArray())
            {
                if (queue.size() == 0 || map.containsKey(ch))
                    queue.add(ch);
                else {
                    char last = queue.removeLast();
                    if (map.containsKey(last) && ch != map.get(last))
                        return false;
                }
            }

            return queue.size() > 0 ? false : true;
        }

        public boolean isValid(String s) {
            LinkedList<Character> stack = new LinkedList<>();
            Map<Character, Character> hm = new HashMap<>();
            hm.put(')', '(');
            hm.put(']', '[');
            hm.put('}', '{');
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (hm.containsKey(c)) {
                    if (stack.isEmpty() || !hm.get(c).equals(stack.pop())) {
                        return false;
                    }
                } else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }
}
