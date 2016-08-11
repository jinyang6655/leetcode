/**
 * Created by yjin on 6/7/16.
 */
public class SortList_148 {

    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode second=slow.next;
        slow.next=null;
        ListNode first=this.sortList(head);
        ListNode mysecond=this.sortList(second);
        return this.merge(first,mysecond);
    }

    public ListNode merge(ListNode first,ListNode second){
        ListNode d=new ListNode(-1);
        ListNode current=d;
        while(first!=null&&second!=null){
            if(first.val<second.val){
                current.next=first;
                first=first.next;
            }else{
                current.next=second;
                second=second.next;
            }
            current=current.next;
            current.next=null;
        }
        if(first==null)
            current.next=second;
        else
            current.next=first;
        return d.next;
    }
}
