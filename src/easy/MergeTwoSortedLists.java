package easy;

import static utils.ListUtils.ListNode;
import static utils.ListUtils.print;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * See <a href="https://leetcode.com/problems/merge-two-sorted-lists/">https://leetcode.com/problems/merge-two-sorted-lists/</a>
 */
public class MergeTwoSortedLists
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);
        print(a);
        print(b);

        print(s.mergeTwoLists(a, b));
    }

    private static class Solution
    {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2)
        {
            ListNode head = new ListNode(-1);
            ListNode runner = head;


            while (l1 != null || l2 != null)
            {
                if (l1 == null || l2 == null)
                {
                    runner.next = l1 == null ? l2 : l1;
                    break;
                }

                if (l1.val < l2.val)
                {
                    runner.next = l1;
                    l1 = l1.next;
                } else
                {
                    runner.next = l2;
                    l2 = l2.next;
                }
                runner = runner.next;
            }

            return head.next;
        }

        public ListNode mergeTwoLists2(ListNode l1, ListNode l2)
        {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val < l2.val)
            {
                l1.next = mergeTwoLists2(l1.next, l2);
                return l1;
            } else
            {
                l2.next = mergeTwoLists2(l1, l2.next);
                return l2;
            }
        }


    }
}
