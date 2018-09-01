package algorithms.solution11;

public class Solution11 {
	public int maxArea(int[] height) {
		int tmp;
		int size = height.length;
		int left = height[0];
		int right = height[size - 1];
		int max = min(left, right) * (size - 1);
		for (int i = size - 1; i > 0; i--) {
			left = height[0];
//			if(height[i]>right){
			for (int j = 0; j < i; j++) {
				if (height[j] > left) {
					System.out.println("计算"+height[i]+"和"+height[j]+"围成的面积");
					tmp = (i - j) * min(height[i], height[j]);
					if (tmp > max) {
						System.out.println("面积更新");
						right = height[i];
						left = height[j];
						max = tmp;
					}
				}
			}
			//左边界找完了移动右边界时要比较两个：max和(0,i-1)
			System.out.println("计算"+height[i-1]+"和"+height[0]+"围成的面积");
			tmp = (i - 1) * min(height[i-1], height[0]);
			if (tmp > max) {
				right = height[i-1];
				left = height[0];
				max = tmp;
			}
		}
		return max;
	}

	public static int min(int a, int b) {
		return a < b ? a : b;
	}

	public static void main(String args[]) {
		Solution11 test = new Solution11();
		int[] arr = new int[] {5,2,12,1,5,3,4,11,9,4};
		System.out.println(test.maxArea(arr));
	}
}
