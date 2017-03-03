package datastructure;

/**
 * Created by wyy on 2/24/17.
 */
public class LinkedList {


    private ListNode head;
    public ListNode getHead() {return head;}

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
    // non-recursive way to merge sorted linkedlists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1==null&&l2==null)
            return null;
        else if(l1==null)
            return l2;
        else if(l2==null)
            return l1;

        ListNode head=null;
        ListNode p1 =l1;
        ListNode p2 = l2;
        ListNode insert=null;

        if(l1.val<=l2.val){
            head = l1;
            p1=p1.next;
            insert=head;
        }
        else if(l1.val>l2.val){
            head=l2;
            p2=p2.next;
            insert=head;
        }
        while(p1!=null&&p2!=null){
            if(p1.val<p2.val){
                insert.next=p1;
                insert=insert.next;
                p1=p1.next;
            }else if(p1.val>=p2.val){
                insert.next=p2;
                insert=insert.next;
                p2=p2.next;
            }
        }
        if(p1==null&&p2!=null){
            while(p2!=null){
                insert.next=p2;
                insert=insert.next;
                p2=p2.next;
            }
        }
        else if(p1!=null&&p2==null){
            while(p1!=null){
                insert.next=p1;
                insert = insert.next;
                p1=p1.next;
            }
        }
        return head;
    }

    //leetcode_141 determine if the given linkedlist has a cycle
    public static boolean hasCycle(ListNode head){
        if(head==null) return false;
        ListNode less = head;
        ListNode  more = head.next;
        while(less!=null&more!=null){
            if(less==more)
                return true;
            less=less.next;
            more=more.next;
            if(more==null)
                break;
            else
                more=more.next;
        }
        return false;
    }
}
