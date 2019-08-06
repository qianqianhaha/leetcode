package string;

/**
 * 定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
import java.util.ArrayList;
import java.util.List;

public class IpAddressRestore {

	public static void main(String[] args) {
		IpAddressRestore ipar = new IpAddressRestore();
		System.out.println(ipar.restoreIpAddresses("010010"));

	}

	public List<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<>();
		if (s.equals(""))
			return res;
		// 标记三个点的位置
		// 第一个数：s.substring(0,index[0])
		// 第二个数: s.substring(index[0],index[1])
		// 第三个数：s.substring(index[1],index[2])
		// 第四个数：s.substring(index[2])
		int[] index = new int[3];
		// 三个点是否能够继续移动
		boolean[] flag = new boolean[3];
		for (int i = 0; i < index.length; i++) {
			index[i] = i + 1;
			flag[i] = true;
		}
		// 当三个点都能继续移动时，循环一直继续
		while (flag[0] || flag[1] || flag[2]) {
			// int n4 = Integer.parseInt(s.substring(index[2]));
			if (!s.substring(index[2]).equals("") && Integer.parseInt(s.substring(index[2])) <= 255) {
				if (check(s, index)) {
					res.add(s.substring(0, index[0]) + "." + s.substring(index[0], index[1]) + "."
							+ s.substring(index[1], index[2]) + "." + s.substring(index[2]));
				}
			}
			for (int i = 2; i >= 0; i--) {
				if (index[i] + 1 > s.length()) {
					flag[i] = false;
				} else {
					if (flag[i]) {
						// 判断这个数是否有意义
						index[i] = index[i] + 1;
						String str;
						if (i == 0) {
							str = s.substring(0, index[i]);
						} else {
							str = s.substring(index[i - 1], index[i]);
						}
						if (Integer.parseInt(str) > 255 || index[i] == s.length()) {
							flag[i] = false;
						} else {
							for (int j = i + 1; j < 3; j++) {
								flag[j] = true;
								index[j] = index[j - 1] + 1 > s.length() ? s.length() : index[j - 1] + 1;
							}
							break;
						}
					}
				}

			}
		}

		return res;
	}
	
	//check right ip address format
	private boolean check(String s, int[] index) {
		if (s.substring(0, index[0]).charAt(0) == '0' && s.substring(0, index[0]).length() > 1)
			return false;
		if (s.substring(index[0], index[1]).charAt(0) == '0' && s.substring(index[0], index[1]).length() > 1)
			return false;
		if (s.substring(index[1], index[2]).charAt(0) == '0' && s.substring(index[1], index[2]).length() > 1)
			return false;
		if (s.substring(index[2]).charAt(0) == '0' && s.substring(index[2]).length() > 1)
			return false;

		return true;
	}
}
