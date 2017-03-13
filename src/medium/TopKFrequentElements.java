package medium;

import java.util.*;

public class TopKFrequentElements
{
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {-1,-1};
        int k = 1;

        List<Integer> result = s.topKFrequent(nums2, k);
        System.out.println(result);
    }

    static class Solution
    {
        public List<Integer> topKFrequent(int[] nums, int k)
        {
            Map<Integer, Integer> map = new HashMap<>();

            for (int element : nums)
            {
                Integer currentCount = map.get(element);
                map.put(element, currentCount != null ? currentCount + 1 : 1);
            }

            ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

            ArrayList<Integer> result = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : list)
                result.add(entry.getKey());

            return result.subList(0, k);
        }
    }
}


