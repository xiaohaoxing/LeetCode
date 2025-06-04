function answerString(word: string, numFriends: number): string {
  let result = word.substring(0, word.length - numFriends + 1)
  if (numFriends == 1) {
    return word
  }
  for (let pos = 0; pos < word.length; pos++) {
    for (let start = pos; start <= word.length - (numFriends - pos); start++) {
      const str = word.substring(start, word.length - (numFriends - pos) + 1)
      if(str.startsWith(result)) {
        result  = str
        continue
      }
      const length = Math.min(str.length, result.length)
      for (let i = 0; i < length; i++) {
        if (str.charAt(i) > result.charAt(i)) {
          result = str
          break
        } else if (str.charAt(i) < result.charAt(i)) {
          break
        }
      }
      result = str.length > result.length ? str : result
    }
  }
  return result
}

console.log(answerString('dbca', 2))
