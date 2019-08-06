package string;
/**
 * 检查字符串s1的某一排列是否是s2的子串s
 */

import java.util.ArrayList;

public class StringPermutation {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "diwjeibbsja";

        StringPermutation sp = new StringPermutation();
        System.out.println(sp.checkInclusion(s1,s2));
    }

    public boolean checkInclusion(String s1, String s2) {

        if(s1.equals(""))
            return true;
        if(s2.length()==0)
            return false;
        if(s2.length()<s1.length())
            return false;

        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<s1.length();i++){
            list.add(s1.charAt(i));
        }

        for(int i=0;i<=s2.length()-s1.length();i++){
            if (!list.contains(s2.charAt(i)))
                continue;
            //若发现了第一个包含的字符，向后搜索一整串
            ArrayList<Character> list1 = (ArrayList<Character>) list.clone();
            ArrayList<Character> list2 = new ArrayList<>();
            list1.remove(list1.indexOf(s2.charAt(i)));
            list2.add(s2.charAt(i));
            boolean flag = true;
            int j = 1;
            while(j<s1.length()){
                if(!list1.contains(s2.charAt(i+j))){
                    flag = false;
                    break;
                }

                //记录遍历过的char元素
                list2.add(s2.charAt(i+j));
                list1.remove(list1.indexOf(s2.charAt(i+j)));
                j++;
            }

            if (flag)
                return true;
            else{
                //如果从第i+j个元素 断了  需要判断下一个i从哪里开始
                int index = list2.indexOf(s2.charAt(i+j));
                if(index==-1){
                    //如果这个元素是个新的元素,下个循环从i+j+1开始
                    i = i+j;

                }else{
                    //如果这个元素在前面的某个位置出现过，下一次从这个位置的下一个位置开始
                    i = i+index;

                }

            }

        }


        return false;
    }
}
