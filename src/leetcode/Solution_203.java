package leetcode;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/20 22:06
 */
public class Solution_203 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeElements(ListNode head, int val) {
        while (head!=null && head.val==val){
            ListNode delNode=head;
            head=head.next;
            delNode.next=null;
        }

        if (head==null)
            return null;

        ListNode prev=head;
        while (prev.next!=null){
            if (prev.next.val==val){
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }else
                prev=prev.next;
        }

        return  head;
    }
}
