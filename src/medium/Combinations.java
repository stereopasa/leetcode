package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <pre>
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]</pre>
 * <p>
 * See <a href="https://leetcode.com/problems/combinations/">https://leetcode.com/problems/combinations/</a>
 */
public class Combinations
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.combine(4, 2));

        Solution2 s2 = new Solution2();
        System.out.println(s2.combine(4, 2));
    }

    private static class Solution
    {
        public List<List<Integer>> combine(int n, int k)
        {
            List<List<Integer>> combs = new ArrayList<List<Integer>>();
            combine(combs, new ArrayList<Integer>(), 1, n, k);
            return combs;
        }

        private void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k)
        {
            if (k == 0)
            {
                combs.add(new ArrayList<>(comb));
                return;
            }
            for (int i = start; i <= n; i++)
            {
                comb.add(i);
                combine(combs, comb, i + 1, n, k - 1);
                comb.remove(comb.size() - 1);
            }
        }

    }

    private static class Solution2 {
        public List<List<Integer>> combine(int n, int k) {
            if (k == n || k == 0) {
                List<Integer> row = new LinkedList<>();
                for (int i = 1; i <= k; ++i) {
                    row.add(i);
                }
                return new LinkedList<>(Arrays.asList(row));
            }
            List<List<Integer>> result = this.combine(n - 1, k - 1);
            result.forEach(e -> e.add(n));
            result.addAll(this.combine(n - 1, k));
            return result;
        }
    }
}
