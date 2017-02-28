package datastructure;

/**
 * Created by wyy on 2/24/17.
 */
public class LinkedList {

    // node data structure
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){val =x;}
    }

    private ListNode head;
    //构造方法
    public LinkedList(int[] init){
        if(init.length==0) head=null;
        head = new ListNode(init[0]);
        ListNode pre = head;
        for(int i=1;i<init.length;i++){
            ListNode now = new ListNode(init[i]);
            pre.next=now;
            pre=now;
        }
    }
    public void printList(){
        ListNode p = head;
        while(p!=null){
            System.out.print(p.val+" ");
            p=p.next;
        }
    }

    public ListNode deleteDuplicates(){
        //the linkedlist is already sorted
        if(head==null) return null;
        ListNode p = head;
        while(p.next!=null){
            if(p.val==p.next.val)
                p.next=p.next.next;
            else{
                p=p.next;
            }
        }
        return head;
    }


}
