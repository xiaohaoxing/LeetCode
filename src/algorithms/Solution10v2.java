package algorithms;

public class Solution10v2 {
	public boolean isMatch(String s, String p) {
		if(match(s, p)==0)	return false;
		else	return true;
	}
	
	public int match(String s,String p){
		if(p.length()==0){
			System.out.println("获取到正则的结尾！");
			return 1;
		}
		if(p.length()>1&&p.charAt(1)=='*'){
			System.out.println("范围匹配：用"+p.substring(0, 2)+"匹配"+s);
			return matchRange(s, p.substring(2), p.charAt(0));
		}
		if(p.charAt(0)=='.'&&s.charAt(0)!='\0'){
			System.out.println("单个匹配：用"+p.charAt(0)+"匹配"+s.charAt(0));
			return match(s.substring(1), p.substring(1));
		}
		return 0;
	}
	public int matchRange(String s,String p,int r){
		int i=0;
		while(s.length()>i&&(s.charAt(i++)==r||r=='.')){
			s=s.substring(1);
			if(match(s, p)==1){
				return 1;
			}
		}
		return 0;
	}
	
	public static void main(String args[]){
		Solution10v2 test=new Solution10v2();
		System.out.println(test.isMatch("aab", "c*a*b"));
	}
}
