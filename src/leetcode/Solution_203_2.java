package leetcode;

import java.util.List;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/20 22:06
 */
public class Solution_203_2 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeElements(ListNode head, int val) {
//        该操作不合适，后续返回还要删除头节点
//        head=new ListNode(-1,head);
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
//        while (head!=null && head.val==val)
//            head=head.next;
//
//        if (head==null)
//            return null;

        ListNode prev=dummyHead ;
        while (prev.next!=null){
            if (prev.next.val==val){
                prev.next=prev.next.next;
            }else
                prev=prev.next;
        }

        return  dummyHead.next;
    }
}
