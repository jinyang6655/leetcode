/**
 * Created by yjin on 6/7/16.
 */
public class RemoveDuplicatesfromSortedListII_82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode current=head;
        while(current!=null){
            if(current.next!=null){
                if(current.next.val==current.val) {
                    while (current.next != null && current.val == current.next.val)
                        current = current.next;
                    current = current.next;
                }
                else{
                    pre.next=current;
                    pre=current;
                    current=current.next;
                }
            }else{
                pre.next=current;
                pre=current;
                current=current.next;
            }
        }
        pre.next=current;
        return dummy.next;
    }
}
