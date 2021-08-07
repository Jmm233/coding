package linklist;

/*
    两个单向链表的公共节点
    https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
    https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 */
public class LinkListCommon {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        int lenA = getLength(headA), lenB = getLength(headB);
        if (lenA < lenB) {
            tempB = goSteps(headB, lenB - lenA);
        } else if (lenA > lenB) {
            tempA = goSteps(headA, lenA - lenB);
        }
        while (tempA != null && tempB != null && tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }

    public ListNode goSteps(ListNode head, int step) {
        while (step > 0) {
            head = head.next;
            step--;
        }
        return head;
    }

    public int getLength(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    // solution 2
    // 绝了 转圈圈
    public ListNode getCommon(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        while (tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }
}
