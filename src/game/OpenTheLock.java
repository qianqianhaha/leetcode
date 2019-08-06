package game;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 */
public class OpenTheLock {

    public static void main(String[] args) {
        String[] strings = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        OpenTheLock otl = new OpenTheLock();
        System.out.println(otl.openLock(strings,"8888"));
    }

    public int openLock(String[] deadends, String target) {
        //深度优先搜索
        //?why hashset?  避免重复！！！
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        if(target==null || set.contains("0000"))
            return -1;
        LinkedList<String> list = new LinkedList<>();
        list.add("0000");
        int depth = 0;

        while(!list.isEmpty()){
            int size = list.size();
            while(size>0){
                String str = list.removeFirst();
                //搜索到 返回深度
                if(str.equals(target)){
                    return depth;
                }
                //没有搜索到，将这一步的密码保存到 死亡密码 集合，避免下一次再搜索到
                if(!set.contains(str)){
                    set.add(str);
                    getNextList(list,str);
                }
                size--;
            }
            depth++;
        }

        return -1;
    }

    private void getNextList(LinkedList<String> list, String str) {
        ArrayList<String> arr = new ArrayList<>();
        char[] ch = str.toCharArray();

        //遍历4个位置，计算出一共8种变化情况
        for(int i=0;i<ch.length;i++){
            char c = ch[i];
            //注意这里一定要用clone()，方法，创造一个同样的数组，但是在一个新开辟的空间内
            char[] clone = ch.clone();
            char temp1 = c=='9'?'0':(char)(c+1);
            clone[i] = temp1;
            arr.add(new String(clone));
            char temp2 = c=='0'?'9':(char)(c-1);
            clone[i] = temp2;
            arr.add(new String(clone));

        }
        list.addAll(arr);
    }

}
