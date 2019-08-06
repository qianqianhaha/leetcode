package binarytree;

import java.util.ArrayList;

public class SortedListToBST {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        ListNode node = head;
        ListNode  temp;
        temp = new ListNode(-3);
        node.next = temp;
        node = node.next;

        temp = new ListNode(0);
        node.next = temp;
        node = node.next;

        temp = new ListNode(5);
        node.next = temp;
        node = node.next;

        temp = new ListNode(8);
        node.next = temp;

        SortedListToBST sl = new SortedListToBST();
        TreeNode res = sl.sortedListToBST(head);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null )
            return null;
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        TreeNode tn;
        if(len<=1)
            return new TreeNode(list.get(0));
        else{
             tn = new TreeNode(list.get(len/2));
        }
        coreleft(0,len/2-1,tn,list);
        coreright(len/2+1,len-1,tn,list);

        return tn;
    }

    private void coreleft(int i1, int i2, TreeNode node, ArrayList<Integer> list) {
        if(i1<=i2){
            int index = i1+(i2-i1+1)/2;
            node.left = new TreeNode(list.get(index));
            node = node.left;
            coreleft(i1,index-1,node,list);
            coreright(index+1,i2,node,list);
        }

    }

    private void coreright(int i1, int i2, TreeNode node, ArrayList<Integer> list) {
        if(i1<=i2){
            int index = i1+(i2-i1+1)/2;
            node.right = new TreeNode(list.get(index));
            node = node.right;
            coreleft(i1,index-1,node,list);
            coreright(index+1,i2,node,list);
        }

    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}