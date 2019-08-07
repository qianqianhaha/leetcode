package string;

/**
 * 检查字符串s是否是字符串t的子串
 */
public class CheckSubstring {
    public static void main(String[] args) {
        String t = "shjakwncskc";
        String s = "abc";
        CheckSubstring cs = new CheckSubstring();
        System.out.println(cs.isSubsequence(s,t));

    }
    public boolean isSubsequence(String s, String t) {

        char[] chars = s.toCharArray();
        int index = -1;
        for(char c:chars){
            index = t.indexOf(c,index+1);
            if(index==-1){
                return false;
            }

        }

        return true;
    }

}
