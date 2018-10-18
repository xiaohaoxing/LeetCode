package algorithms.solution8;

/**
 * 提交永远显示"-1"会被转成1.本地run结果正确。原因未知。
 * @author Administrator
 *
 */
public class Solution8v1 {
	private boolean isPos=true;
	public static final int max=2147483647;
	public static final int min=-2147483648;
	public int myAtoi(String str) {
		int num=0;
		char[] arr=str.toCharArray();
		int i=0;
		boolean maxOver=false;
		boolean maxBorder=false;
		boolean minOver=false;
		boolean minBorder=false;
		boolean isPos=true;
		if(arr.length<1){
			return 0;
		}
		while(arr[i]==' '){
				i++;
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
				return print(num);
			}
		}	
		return print(num);
    }
	public int print(int num){
		if(isPos){
			return num;

		}else{
			return -num;
		}
	}
	public static void main(String[] args) {
		Solution8 test=new Solution8();
		System.out.println(test.myAtoi("-1"));
	}
}
