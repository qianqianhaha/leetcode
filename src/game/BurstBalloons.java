package game;
/**
 * 输入数组代表气球在x轴上的起始位置
 * 要求从x轴向外射出n支箭击破气球，求气球的最小数量
 */

import java.util.TreeMap;

public class BurstBalloons {

    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        //int[][] points = {{0,9},{1,8},{7,8},{1,6},{9,16},{7,13},{7,10},{6,11},{6,9},{9,13}};
        BurstBalloons bb = new BurstBalloons();
        System.out.println(bb.findMinArrowShots(points));

    }


    public int findMinArrowShots(int[][] points) {
        int res = 0;

        if (points.length <= 0)
            return 0;

        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i=0;i<points.length;i++){
            if(map.containsKey(points[i][0]) && map.get(points[i][0])<points[i][1]){
                continue;
            }else{
                map.put(points[i][0],points[i][1]);
            }

        }

        Object[] set = map.keySet().toArray();

        for(int i=0;i<set.length;i++){
            res++;
            int temp2 = map.get(set[i]);

            while(i+1<set.length && (int)set[i+1]<=temp2){
                temp2 = map.get(set[i+1])<temp2?map.get(set[i+1]):temp2;
                i++;
            }

        }
        return res;
    }
}
