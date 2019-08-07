package string;
/**
 * 816 模糊坐标
 * 将形如"(123)"的字符串转化成所有可能的二维坐标形式，且满足一下规律
 * 整数部分：超过两位数的首位不能为0
 * 小数部分：不为""的情况下其末位不能为0
 */

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinate {

    public static void main(String[] args) {
        AmbiguousCoordinate ac = new AmbiguousCoordinate();
        String s = "(00011)";
        ac.ambiguousCoordinates(s);
    }

    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        S = S.substring(1,S.length()-1);

        for(int i=0;i<S.length()-1;i++){
            String s1 = S.substring(0,i+1);
            String s2 = S.substring(i+1);
            for(int j=0;j<s1.length();j++){
                String ss1 = s1.substring(0,j+1);
                String ss2 = s1.substring(j+1);
                if(!(check(ss1,0) && check(ss2,1))){
                   continue;
                }
                for(int k=0;k<s2.length();k++){
                    String ss3 = s2.substring(0,k+1);
                    String ss4 = s2.substring(k+1);
                    if(!(check(ss3,0)&&check(ss4,1))){
                        continue;
                    }
                    String temp = "("+ss1+(ss2.equals("")?"":"."+ss2)+", "+ss3+(ss4.equals("")?"":"."+ss4)+")";
                    res.add(temp);
                }
            }

        }

        return res;
    }

    private boolean check(String ss1, int i) {
        if(i==0){
            //整数
            if(ss1.charAt(0)=='0' && ss1.length()>1)
                return false;
            return true;

        }else{
            //小数
            if(!ss1.equals("") && ss1.charAt(ss1.length()-1)=='0')
                return false;
            return true;
        }

    }
}
