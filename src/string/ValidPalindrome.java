package string;

/**
 * 检查字符串是否满足 最多删除一个字符，得到一个回文字符串结果 这一条件
 * 输入：“abca” 输出：true 
 * @author qianqianshu
 *
 */
public class ValidPalindrome {
	
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.validPalindrome("deeee"));
	}
	public boolean validPalindrome(String s) {
		if(s==null || s.length()<=1)
			return true;
		int front = 0;
		int end = s.length()-1;
		boolean flag = true;
		return core(s,flag,front,end);
	}
	
	private boolean core(String s,boolean flag,int front,int end) {
		if(front<end) {
			if(s.charAt(front)==s.charAt(end)) {
				return core(s,flag,front+1,end-1);
			}else {
				return flag?(core(s,false,front+1,end)||core(s,false,front,end-1)):false;
			}
			
		}else {
			return true;
		}
		
	}
}
