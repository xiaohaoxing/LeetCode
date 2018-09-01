package algorithms.solution11;

/**
 * 我日，明明这么简单就做完了。为什么要想那么复杂？？？
 */
public class Solution11v2 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for(int x = 0; x < height.length; x++){
            for(int y = x + 1; y < height.length; y++){
                int temp = (y - x)*min(height[x], height[y]);
                if(temp > maxArea){
                    maxArea = temp;
                }
            }
        }
        return maxArea;
    }
    public int min(int x, int y){ return x>y?y:x; }
    public static void main(String[] args){

    }
}
