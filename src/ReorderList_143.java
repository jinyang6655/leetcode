/**
 * Created by yjin on 6/7/16.
 */
public class ReorderList_143 {

    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
            return;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode second=slow.next;
        slow.next=null;
        ListNode first=head;
        ListNode secondReverse=this.reverseList(second);
        dummy.next=null;
        ListNode current=dummy;
        while(first!=null&&secondReverse!=null){
            ListNode v1=first;
            first=first.next;
            ListNode v2=secondReverse;
            secondReverse=secondReverse.next;
            current.next=v1;
            current=current.next;
            current.next=v2;
            current=current.next;
        }
        if(first==null)
            current.next=secondReverse;
        else
            current.next=first;
    }

    public ListNode reverseList(ListNode node){
       if(node==null||node.next==null)
           return node;
        ListNode pre=null;
        ListNode current=node;
        ListNode next=node.next;
        while(current!=null){
            current.next=pre;
            pre=current;
            current=next;
            if(next.next==null)
                break;
            next=next.next;
        }
        current.next=pre;
        return current;
    }
}
