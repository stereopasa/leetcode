package easy;

import static utils.ListUtils.*;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * <pre>Given 1->2->3->4, you should return the list as 2->1->4->3.</pre>
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 * See <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">https://leetcode.com/problems/swap-nodes-in-pairs/</a>
 */
public class SwapNodesInPairs
{
    public static void main(String[] args)
    {
        Solution s = new Solution();

        ListNode a = new ListNodeBuilder()
                .add(1)
                .add(2)
                .add(3)
                .add(4)
                .build();
        print(a);
        print(s.swapPairsRecursion(a));
    }

    private static class Solution
    {
        public ListNode swapPairs(ListNode head)
        {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode current = dummy;
            while (current.next != null && current.next.next != null)
            {
                ListNode first = current.next;
                ListNode second = current.next.next;
                first.next = second.next;
                current.next = second;
                current.next.next = first;
                current = current.next.next;
            }
            return dummy.next;
        }

        public ListNode swapPairsRecursion(ListNode head)
        {
            if ((head == null) || (head.next == null))
                return head;
            ListNode n = head.next;
            head.next = swapPairsRecursion(head.next.next);
            n.next = head;
            return n;
        }
    }
}
