package algorithms;
/**
 * 反转数字
 * 要点：
 * 1.注意边界条件！数字的边界不按照位数判断，需要进一步确定。
 * 		溢出具体条件是： ( 最后一位 > 7 AND 前面所有位 == 214748364 ) OR ( 前面所有位 == 214748364 )
 * 2.为了防止最高位操作时溢出，使用的方式是：将最高一位单独计算，后面的子串则必不会溢出，专注于反转
 * @author Administrator
 *
 */
public class Solution7 {
	//-2147483648
	//这个数字不能转成正的计算！溢出了。
	public int reverse(int x){
		int num=x;
		int size=0;
		int p=1;
		while(true){
			if((num/p)<10&&(num/p)>-10){
				break;
			}
			p*=10;
			size++;
		}
		size++;
		int head=num/p;
		int reverse=reverseLow(num%p,size-1);
		if((reverse>214748364||(reverse==214748364&&head>7))||(reverse<-214748364||(reverse==-214748364&&head<-8))){
			return 0;
		}
		return reverse*10+head;
	}
	public static int reverseLow(int x,int length){
		int result=0;
		int devider=1;
		int tmp=0;
		for(int i=0;i<length;i++){
			tmp = x % (devider * 10 ) / devider;
			System.out.println("进位："+result+"+"+tmp);
			result = result * 10 + tmp;
			devider *= 10;
			if(devider<=0){
				return 0;
			}
		}
		return result;
	}
	public static void main(String args[]){
		Solution7 solution7=new Solution7();
		int result=solution7.reverse(-2147483648);
		System.out.println(result);
	}
}
