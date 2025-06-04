// find the largest alpha first
// 本质上是最长增长子序列，动态规划

function answerString(word: string, numFriends: number): string {
  const dp = new Array(word.length)
  dp[0] = word.substring(0, word.length - numFriends + 1)
  dp[word.length - 1] = dp[0]
  if(numFriends == 1) {
    return word
  }
  for (let i = 1; i < word.length; i++) {
    console.log(`[${i}, ${Math.min(word.length, word.length + i + 1 - numFriends)}]`)
    const current = word.substring(
      i,
      Math.min(word.length, word.length + i + 1 - numFriends)
    )
    dp[i] = current > dp[i - 1]?current:dp[i-1]
  }
  return dp[word.length - 1]
}

function max(str1: string, str2: string) {
console.log(`compare ${str1} and ${str2}`)
  const length = Math.min(str1.length, str2.length)
  for (let i = 0; i < length; i++) {
    if (str1.charAt(i) > str2.charAt(i)) {
      return str1
    } else if (str1.charAt(i) < str2.charAt(i)) {
      return str2
    }
  }
  return str1.length > str2.length ? str1 : str2
}

console.log(answerString('gh', 1))
// console.log(answerString('bif', 2))
// console.log(answerString('aaaaaaaaaaaaz', 2))
