/**
 * Created by yjin on 8/11/16.
 */
public class MergekSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        return this.mergeKLists(lists,0,lists.length-1);
    }

    public ListNode mergeKLists(ListNode[] lists,int start,int end){
        if(start>end) return null;
        if(start==end) return lists[start];
        if(end-start==1) return this.merge2Lists(lists[start],lists[end]);
        int mid=start+(end-start)/2;
        ListNode n1=this.mergeKLists(lists,start,mid);
        ListNode n2=this.mergeKLists(lists,mid+1,end);
        return this.merge2Lists(n1,n2);
    }

    public ListNode merge2Lists(ListNode h1,ListNode h2){
        if(h1==null) return h2;
        if(h2==null) return h1;
        ListNode dummy=new ListNode(-1);
        ListNode head=dummy;
        while(h1!=null&&h2!=null){
            ListNode tmp=null;
            if(h1.val<h2.val){
                tmp=h1;
                h1=h1.next;
            }else{
                tmp=h2;
                h2=h2.next;
            }
            head.next=tmp;
            head=head.next;
        }
        if(h1==null) head.next=h2;
        else head.next=h1;
        return dummy.next;
    }

}
