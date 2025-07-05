// 其中有 N 正好出现 N 次，找到他，（返回其中最大的）
function findLucky(arr: number[]): number {
  let count = new Array(arr.length);
  for (let i in arr) {
    if (!count[arr[i] - 1]) {
      count[arr[i] - 1] = 0;
    }
    count[arr[i] - 1] += 1;
    console.log(count);
  }
  for (let i = count.length - 1; i > 0; i--) {
    if (i + 1 == count[i]) {
      return i + 1;
    }
  }
  return -1;
}

const test = [2, 2, 3, 3, 3];
console.log(findLucky(test));
