package number;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 */

import java.util.ArrayList;

public class PartitionList {

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode head = list;
        list.next = new ListNode(4);
        list = list.next;
        list.next = new ListNode(3);
        list = list.next;
        list.next = new ListNode(2);
        list = list.next;
        list.next = new ListNode(5);
        list = list.next;
        list.next = new ListNode(2);
        list = list.next;

        PartitionList pl = new PartitionList();
        ListNode res = pl.partition(head,3);
    }

    public ListNode partition(ListNode head, int x) {

        ListNode list1 = new ListNode(0);
        if(head==null){
            return null;
        }
        ArrayList<Integer> array = new ArrayList<>();
        ListNode list2 = list1;
        while(head!=null){
            int temp = head.val;
            if(temp<x){
                list2.next = new ListNode(temp);
                list2 = list2.next;
            }else{
                array.add(temp);
            }

            head = head.next;
        }

        if(array.size()>0){
            for(int i:array){
                list2.next = new ListNode(i);
                list2 = list2.next;
            }
        }

        return list1.next;

    }
}

    class ListNode {
             int val;
             ListNode next;
             ListNode(int x) { val = x; }
}
