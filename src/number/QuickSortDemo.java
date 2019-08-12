package number;

public class QuickSortDemo {
    public static void main(String[] args) {
        QuickSortDemo quickSortDemo = new QuickSortDemo();
        int[] nums = {8,7,6,10,2,5,1,0,3,4};
        quickSortDemo.quickSort(0,nums.length-1,nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public void quickSort(int l1,int l2,int[] nums){
        if(l1<l2){
            int temp = nums[l2];
            int index = l1;
            for(int i=l1;i<l2;i++){
                if(nums[i]<=temp){
                    if(index!=i){
                        swap(nums,index,i);
                    }
                    index++;
                }
            }
            swap(nums,index,l2);
            quickSort(l1,index-1,nums);
            quickSort(index+1,l2,nums);
        }
    }

    private void swap(int[] nums, int index, int i) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }
}
