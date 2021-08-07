package linklist;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
    合并k个升序链表
    https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKLinks {
    public class sheng implements Comparator<ListNode> {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new sheng());
        ListNode cur;
        for (ListNode list : lists) {
            cur = list;
            while (cur != null) {
                pq.offer(cur);
                cur = cur.next;
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
        ListNode ans = pq.poll();
        cur = ans;
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
        }
        cur.next = null;
        return ans;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] list, int left, int right) {
        if (left >= right) {
            return list[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftN = merge(list, left, mid);
        ListNode rightN = merge(list, mid + 1, right);
        return mergeTwoList(leftN, rightN);
    }

    public ListNode mergeTwoList(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        if (left.val < right.val) {
            left.next = mergeTwoList(left.next, right);
            return left;
        } else {
            right.next = mergeTwoList(left, right.next);
            return right;
        }
    }
}
