package list;

/**
 * 725 分隔链表
 */

public class SplitLinkedList {
    public static void main(String[] args) {
        SplitLinkedList sl = new SplitLinkedList();
        ListNode root = new ListNode(1);
        ListNode temp = root;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);
        temp = temp.next;
        temp.next = new ListNode(6);
        temp = temp.next;
        temp.next = new ListNode(7);
        ListNode[] res = sl.splitListToParts(root,3);
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        ListNode temp = root;
        while(temp!=null){
            len++;
            temp = temp.next;
        }

        ListNode[] res = new ListNode[k];

        if(len>0){
            int n1 = len/k;
            int n2 = len%k;

            for(int i=0;i<k;i++){
                int n3 = n1+((n2--)>0?1:0);
                if(root!=null){
                    res[i] = root;
                    while(n3-1>0){
                        root = root.next;
                        n3--;
                    }
                    ListNode node = root.next;
                    root.next = null;
                    root = node;
                }

            }

        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
