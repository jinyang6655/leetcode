/**
 * Created by yjin on 6/7/16.
 */
public class InsertionSortList_147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummyOld=new ListNode(-1);
        ListNode dummyNew=new ListNode(-1);
        dummyOld.next=head;
        while(head!=null){
            ListNode current=head;
            head=head.next;
            current.next=null;
            ListNode build=dummyNew;
            while(build.next!=null&&build.next.val<current.val){
                build=build.next;
            }
            ListNode next=build.next;
            build.next=current;
            current.next=next;
        }
        return dummyNew.next;
    }
}
