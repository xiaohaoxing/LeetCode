function dividePlayers(skill: number[]): number {
  if (skill.length % 2 == 1 || skill.length < 2) {
    return -1
  }
  const arr = skill.sort((a, b) => a - b)
  const right = arr.length / 2
  const left = right - 1
  const sum = arr[left] + arr[right]
  let result = 0
  for (let step = 0; step < arr.length / 2; step++) {
    if (arr[left - step] + arr[right + step] != sum) {
      return -1
    }
    result += (arr[left - step] * arr[right + step])
  }
  return result
}

const test1 = [3, 2, 5, 1, 3, 4]
const test2 = [3, 4]
const test3 = [1, 1, 2, 3]
const test4 = [10, 14, 16, 15, 9, 4, 4, 4]
const test5 = [13,1,14,3,2,15]
console.log(dividePlayers(test5))