/**
 * Created by yjin on 8/11/16.
 */
public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode p=null;
        ListNode current=head;
        ListNode g=current.next;
        while(g!=null){
            current.next=p;
            p=current;
            current=g;
            g=g.next;
        }
        current.next=p;
        return current;
    }

    public ListNode reverseList1(ListNode head) {
        if(head==null||head.next==null) return head;
        return this.reverseList(null,head);
    }

    public ListNode reverseList(ListNode pre,ListNode current){
        if(current.next==null){
            current.next=pre;
            return current;
        }
        ListNode root=this.reverseList(current,current.next);
        current.next=pre;
        return root;
    }
}
