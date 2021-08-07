package linklist;

import org.junit.Test;

/*
    翻转链表
 */
public class Reverses01 {
    // 翻转整个链表
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null, cur = head, temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 翻转M->N链表
    // https://leetcode-cn.com/problems/reverse-linked-list-ii/
    public ListNode reverseListMN(ListNode head, int M, int N) {
        ListNode tempList = new ListNode(0);
        tempList.next = head;

        ListNode prv = tempList;
        ListNode cur = head;
        int i = 1;
        for (; i < M; i++) {
            cur = cur.next;
            prv = prv.next;
        }
        ListNode temp;
        for (; i < N; i++) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = prv.next;
            prv.next = temp;
        }
        return tempList.next; // 返回prv.next或者head都是不对的 它们在变化
    }

    @Test
    public void ttest() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        reverseListMN(head, 1, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
