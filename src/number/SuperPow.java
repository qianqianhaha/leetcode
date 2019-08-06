package number;

/**
 * 求超级平方 ，a^b%1337=？  b用数组输入 a为正整数
 */
public class SuperPow {

    public static void main(String[] args) {
        SuperPow sp = new SuperPow();
        int a = 2;
        int[] b = {1,0};
        System.out.println(sp.superPow(a,b));
    }

    public int superPow(int a, int[] b) {
        int mod = 1337;
        int res = 1;

        int base = a%mod;

        for(int i=b.length-1;i>=0;i--){
            int index = b[i];
            for(int j=0;j<index;j++){
                res = (res*base)%mod;
            }

            int nextbase = 1;
            for(int j=0;j<10;j++){
                nextbase = (nextbase*base)%mod;
            }
            base = nextbase;

        }

        return res;
    }
}
