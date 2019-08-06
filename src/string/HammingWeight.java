package string;

public class HammingWeight {
	public static void main(String[] args) {
		HammingWeight hw = new HammingWeight();
		System.out.println(hw.hammingWeight(0b11111111111111111111111111111101));
	}
	
	public int hammingWeight(int n) {
		int res = 0;
		for(int i=0;i<32;i++) {
			res = res + (n>>i)%2;
		}
		return Math.abs(res);
	}
}
