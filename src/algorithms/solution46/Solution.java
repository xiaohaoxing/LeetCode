package algorithms.solution46;

import java.util.*;

/**
 * @author 肖皓星
 * @email xiaohaoxing@xiaomi.com
 * @date 2020/2/27 00:05
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        if (length == 1) {
            result.add(Arrays.asList(nums[0]));
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> piece = new ArrayList<>(length);
            result.add(piece);
        }
        return permutePart(nums, 1, result);
    }

    public List<List<Integer>> permutePart(int[] nums, int fromIndex, List<List<Integer>> previous) {
        if (fromIndex == nums.length - 1) {
            previous.forEach(list -> list.add(nums[fromIndex]));
            return previous;
        }
        int insertIndex = 1;
        List<List<Integer>> newList = new LinkedList<>();
        for (List<Integer> piece : previous) {
            for (int i = fromIndex; i < nums.length; i++) {
                List<Integer> newPiece = new LinkedList();
                Collections.copy(newPiece, piece);
                newPiece.add(nums[i]);
                newList.add(newPiece);
            }
        }
        return newList;
    }
}
