package algorithms.solution8;
/**
 * 实现从String到int的转化，具体实现繁琐而不难。遇到以下几种情况：
 * 1.0的时候返回多少
 * 2.+/-开头的时候显示什么
 * 3.前面的空格要忽略
 * 4.数字长度超过int上限怎么办：显示上/下限数值
 * 5.非法数字怎么办：显示0
 * @author Administrator
 *
 */
public class Solution8 {
	public int myAtoi(String str) {
		final int max=2147483647;
		final int min=-2147483648;
		int num=0;
		char[] arr=str.toCharArray();
		int i=0;
		int size=0;
		boolean maxOver=false;
		boolean maxBorder=false;
		boolean minOver=false;
		boolean minBorder=false;
		boolean isPos=true;
		if(arr.length<1){
			return 0;
		}
		while(true){
			if(arr[i]==' '){
				i++;
			}else{
				break;
			}
		}
		//首字符
		if(arr[i]=='+'||arr[i]=='-'){
			switch(arr[i]){
			case '+':
				isPos=true;
				i++;
				break;
			case '-':
				isPos=false;
				i++;
				break;
			default:
				isPos=true;
				break;
			}
		}
		for(;i<arr.length;i++){
			if(num==214748364&&isPos){
				maxBorder=true;
			}else if(num>214748364&&isPos){
				maxOver=true;
			}else if(num==214748364&&!isPos){
				minBorder=true;
			}else if(num>=214748364&&!isPos){
				minOver=true;
			}
			switch(arr[i]){
			case '0':
				if(maxOver){
					return max;
				}else if(minOver){
					return min;
				}
				num=num*10+0;
				break;
			case '1':
				if(maxOver){
					return max;
				}else if(minOver){
					return min;
				}
				num=num*10+1;
				break;
			case '2':
				if(maxOver){
					return max;
				}else if(minOver){
					return min;
				}
				num=num*10+2;
				break;
			case '3':
				if(maxOver){
					return max;
				}else if(minOver){
					return min;
				}
				num=num*10+3;
				break;
			case '4':
				if(maxOver){
					return max;
				}else if(minOver){
					return min;
				}
				num=num*10+4;
				break;
			case '5':
				if(maxOver){
					return max;
				}else if(minOver){
					return min;
				}
				num=num*10+5;
				break;
			case '6':
				if(maxOver){
					return max;
				}else if(minOver){
					return min;
				}
				num=num*10+6;
				break;
			case '7':
				if(maxOver){
					return max;
				}else if(minOver){
					return min;
				}
				num=num*10+7;
				break;
			case '8':
				if(maxOver){
					return max;
				}else if(minOver){
					return min;
				}else if(maxBorder){
					return max;
				}
				num=num*10+8;
				break;
			case '9':
				if(maxOver){
					return max;
				}else if(minOver){
					return min;
				}else if(maxBorder){
					return max;
				}else if(minBorder){
					return min;
				}
				num=num*10+9;
				break;
			default:
				if(isPos){
					return num;
				}
				else{
					return (-1)*num;
				}
			}
		}
		//正负极端要考虑
		if(isPos&&num<0){
			return max;
		}
		if(!isPos&&num<0){
			return -2147483648;
		}
		if(isPos){
			return num;
		}
		else{
			return (-1)*num;
		}
    }
	public static void main(String[] args) {
		Solution8 test=new Solution8();
		System.out.println(test.myAtoi("      -11919730356x"));
	}
}
