function countHillValley(nums: number[]): number {
  if (nums.length < 3) {
    return 0;
  }
  let result = 0;
  for (let i = 1; i < nums.length - 1; i++) {
    if (nums[i] == nums[i - 1]) {
      continue;
    }
    let left = 0;
    let right = 0;
    for (let l = i - 1; l >= 0; --l) {
      if (nums[l] < nums[i]) {
        left = -1;
        break
      } else if (nums[l] > nums[i]) {
        left = 1;
        break
      }
    }
    for (let r = i + 1; r < nums.length; r++) {
      if (nums[r] < nums[i]) {
        right = -1;
        break
      } else if (nums[r] > nums[i]) {
        right = 1;
        break
      }
    }
    if (left == right && left != 0) {
      result += 1;
    }
  }
  return result;
}

// const test = [21, 21, 21, 2, 2, 2, 2, 21, 21, 45];
const test = [2, 4, 1, 1, 6, 5];
console.log(countHillValley(test));
