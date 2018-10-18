package algorithms.solution9;

/**
 * 从最低位开始获取，并生成反串，再倒数第二位时判断是否相同，而不用完全反串
 * 
 * @author Administrator
 *
 */
public class Solution9 {
	public boolean isPalindrome(int x) {
		int num;
		if (x < 0) {
			return false;
		} else {
			num = x;
		}
		int devider = 10;
		int reverse = 0;
		int times=0;
		int tmp = num % devider;
		while (devider < num) {
			reverse = reverse * 10 + tmp;
			if(devider>=1000000000){
				tmp=num/devider;
				break;
			}else{
				tmp = (num % (10 * devider)) / devider;
			}
			devider *= 10;
			if(times>8){
				break;
			}
			times++;
		}
		if((reverse==num/10)&&(tmp==num%10)){
			return true;
		}else{
			return false;
		}
	}
	public static void main(String args[]){
		Solution9 test=new Solution9();
		System.out.println(test.isPalindrome(1410110141));
	}
}
