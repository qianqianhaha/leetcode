package dp;

/**
 * 水壶问题
 * 有两个容量分别为x,y的水壶
 * 现需要凑满z 升水
 * 是否可以用两个水壶凑满
 *
 * 思路：找到x,y的最大公约数
 * x=am
 * y=an
 *
 * z = p*x+q*y = pam+qan = a(pm+qn)  =>  z%a==0
 */
public class WaterJugPro {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z==0)
            return true;
        if(z>(x+y))
            return false;

        int temp = Math.min(x,y);
        while(temp>0){
            //找最大公约数
            if(x%temp==0 && y%temp==0)
                break;
            temp--;
        }

        if(temp!=0)
            return z%temp==0;
        else
            return z==x || z==y;

    }
}
