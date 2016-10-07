package algorithms;

import java.util.*;

/**
 * Created by Lenovo on 16.9.30.
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int count = 0;
        for(int i = 1;i<nums.length;i++){
            for(int j = i-1;j>=0;j--){
                if(nums[j]==nums[i]){
                    continue;
                }
                if(nums[j])
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        for(int i= 2;i<nums.length;i++){
            for(int j= 1;j<i;j++){
                for(int k=0;k<j;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        LinkedList<Integer> tmp = new LinkedList<>();
                        tmp.add(0,nums[k]);
                        tmp.add(1,nums[j]);
                        tmp.add(2,nums[i]);
                        result.add(tmp);
                    }
                }
            }
        }
        return result;
    }
}
