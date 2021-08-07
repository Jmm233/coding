package linklist;

import org.junit.Test;

/*
    判断链表是否含有回文结构【对称】
    https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class ContainHuiWen {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode mid = head, fast = head;
        // 不仅仅是单纯的快慢指针，还需要找mid节点
        while (fast.next != null && fast.next.next != null) {
            mid = mid.next;
            fast = fast.next.next;
        }

        ListNode posRev = reverseListMP(mid.next);
        while (posRev != null) {
            if (head.val != posRev.val) {
                return false;
            }
            head = head.next;
            posRev = posRev.next;
        }
        return true;
    }


    public ListNode reverseListMP(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prv = null;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = prv;
            prv = cur;
            cur = temp;
        }
        return prv;
        // 头插法
        /*ListNode tempList = new ListNode(0);
        tempList.next = head;

        ListNode prv = tempList;
        ListNode cur = head;

        ListNode temp;
        while (cur.next != null) {
            temp = cur.next;
            cur.next = temp.next;
            temp.next = prv.next;
            prv.next = temp;
        }
        return tempList.next;*/
    }

    @Test
    public void ttest() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(isPalindrome(head));
    }
}
