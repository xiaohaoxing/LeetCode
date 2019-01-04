package algorithms.solution34;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int middle = findOne(nums, 0, nums.length - 1, target);
        if (middle == -1) {
            return new int[]{-1, -1};
        }
        int left = findFirst(nums, 0, middle, target);
        int right = findLast(nums, middle, nums.length - 1, target);
        return new int[]{left, right};
    }

    private static int findOne(int[] nums, int from, int to, int target) {
        if (from == to) {
            if (nums[from] == target) {
                return from;
            } else {
                return -1;
            }
        }
        int middle = (from + to) / 2;
        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] < target) {
            return findOne(nums, middle + 1, to, target);
        } else {
            return findOne(nums, from, middle, target);
        }
    }

    // 这里的 nums[to] 不一定是 target
    private static int findFirst(int[] nums, int from, int to, int target) {
        if (from == to) {
            if (nums[to] == target) {
                return to;
            } else {
                return to + 1;
            }
        }
        int middle = (from + to) / 2;
        if (nums[middle] == target) {
            //left half
            return findFirst(nums, from, middle, target);
        } else {
            //right half
            return findFirst(nums, middle + 1, to, target);
        }
    }

    // 这里的nums[from] 不一定是target
    public static int findLast(int[] nums, int from, int to, int target) {
        if (from == to) {
            if (nums[to] == target) {
                return to;
            } else {
                return to - 1;
            }
        }
        int middle = (from + to) / 2;
        if (nums[middle] == target) {
            //right half
            return findLast(nums, middle + 1, to, target);
        } else {
            //left half
            return findLast(nums, from, middle, target);
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{5, 7, 7, 8, 8, 10};
        int[] list2 = new int[]{2, 2};
        int[] list3 = new int[]{0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 6, 6, 7, 8};
        int target = 3;
        Solution test = new Solution();
        int[] result = test.searchRange(list3, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
