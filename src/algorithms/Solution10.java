package algorithms;
//必须考虑的案例："a*a"匹配"aaa"
//因此可能考虑的方式是：倒序匹配
public class Solution10 {
	public boolean isMatch(String s, String p) {
		if(s.equals("")){
			s=" ";
		}
		int currentS = 0;
		int currentP=0;
		boolean flag=true;
		while (currentP < p.length()) {
			//到尽头，无法foresee
			if(currentP+1>=p.length()){
				return flag&&match(p.charAt(currentP), s.charAt(currentS))&&currentS==s.length()-1;
			}
			switch (p.charAt(currentP+1)) {
			case '*':
				currentS=matchRange(s, p.charAt(currentP), currentS);
				//String到文末，如果正则也到文末则返回true
				if(currentS==-1){
					if(currentP==p.length()-2){
						return true;
					}else{
						return false;
					}
				}
				currentP++;
				break;
			default:
				flag=match(s.charAt(currentS), p.charAt(currentP));
				currentS++;
				break;
			}
			currentP++;
			if(!flag){
				return false;
			}
			//判断2个串是否同时匹配完
			if((currentP>=p.length()&&currentS<s.length())||(currentP<p.length()&&currentS>=s.length())){
				return false;
			}
		}
		return true;
	}

	public boolean match(char c, char p) {
		if (c == p) {
			return true;
		}
		if (p == '.') {
			return true;
		}
		return false;
	}

	// 匹配多个字符'*'，返回无法匹配的位置
	public int matchRange(String s, char p, int pos) {
		int i = pos;
		while (match((char) s.charAt(i), p)) {
			i++;
			//匹配到文末，返回-1
			if(i==s.length()){
				return -1;
			}
		}
		return i;
	}

	public static void main(String args[]) {
		Solution10 test = new Solution10();
//
//		int after = test.matchRange("abbbbc", 'b', 1);
//		System.out.println("结束的位置是：" + after);
		System.out.println(test.isMatch("aa", "a*"));
	}
}
