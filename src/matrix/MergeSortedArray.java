package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {2,4,6,0,0,0};
        int[] nums2 = {1,3,5};
        MergeSortedArray msa = new MergeSortedArray();
        msa.merge(nums1,3,nums2,3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        Queue<Integer> queue = new LinkedList<>();
        while(index1<m || index2<n || !queue.isEmpty()){
            int n1 = index1<m?nums1[index1]:Integer.MAX_VALUE;
            int n2 = index2<n?nums2[index2]:Integer.MAX_VALUE;
            if(queue.isEmpty()){
                if(n1<=n2){
                    index1++;
                }else{
                    index2++;
                    if(n1<Integer.MAX_VALUE)
                        queue.offer(n1);
                    nums1[index1] = n2;
                    index1++;
                }
            }else{
                int n3 = queue.peek();
                if(n3<=n1 && n3<=n2){
                    queue.poll();
                    if(n1<Integer.MAX_VALUE)
                        queue.offer(n1);
                    nums1[index1] = n3;
                    index1++;
                }else if(n1<=n2 && n1<=n3){
                    index1++;
                }else if(n2<=n1 && n2<=n3){
                    if(n1<Integer.MAX_VALUE)
                        queue.offer(n1);
                    nums1[index1] = n2;
                    index2++;
                    index1++;
                }

            }
        }
    }
}
