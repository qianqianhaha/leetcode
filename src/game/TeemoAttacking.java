package game;

/**
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。
 * 现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 */
public class TeemoAttacking {

    public static void main(String[] args) {
        TeemoAttacking ta = new TeemoAttacking();
        int[] timeSeries = {1,2,4,5,7,11,12,13,15};
        int duration = 3;

        System.out.println(ta.findPoisonedDuration(timeSeries,duration));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;

        if(timeSeries.length<=0){
            return 0;
        }

        int start = timeSeries[0];
        int end = start+duration-1;

        for(int i=0;i<timeSeries.length;i++){
            if(timeSeries[i]<=end){
                end = timeSeries[i]+duration-1;
            }else{
                res = res+end-start+1;
                start = timeSeries[i];
                end = start+duration-1;
            }
        }

        res = res+end-start+1;

        return res;
    }
}
