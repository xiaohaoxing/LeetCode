function smallestEquivalentString(
  s1: string,
  s2: string,
  baseStr: string
): string {
  // prepare
  const friends = new Map<string, Set<string>>()
  for (let i = 0; i < s1.length; i++) {
    let c1 = s1.charAt(i)
    let c2 = s2.charAt(i)
    if (i == 17) {
      console.log(friends)
      console.log(c1)
      console.log(c2)
    }
    if (c1 != c2) {
      if (friends.has(c1) && friends.has(c2)) {
        continue
      }
      // add c2 to c1
      console.log(friends)
      console.log(`[${i}]add ${c2} to ${c1}`)
      let candidates = [c2, ...(friends.get(c2) ?? [])]
      for (let key in [...(friends.get(c1) ?? []), c1]) {
        if (friends.has(c1)) {
          friends.set(c1, friends.get(candidates[key])?.add(...candidates))
        } else {
          friends.set(c1, candidates)
        }
      }
      console.log(friends)
      console.log(`[${i}]add ${c1} to ${c2}`)
      candidates = [c1, ...(friends.get(c1) ?? [])]
      for (let key in [...(friends.get(c2) ?? []), c2]) {
        if (friends.has(c2)) {
          friends.set(c2, [...friends.get(candidates[key])!, ...candidates])
        } else {
          friends.set(c2, candidates)
        }
      }
    }
  }
  console.log(friends)
  // replace
  let result = baseStr
  for (let i = 0; i < baseStr.length; i++) {
    const ch = baseStr.charAt(i)
    if (friends.has(ch)) {
      const min = friends
        .get(ch)!
        .reduce((value, min) => (value < min ? value : min), 'z')
      result = result.replace(ch, min < ch ? min : ch)
    }
  }
  return result
}

// console.log(smallestEquivalentString('parkerz', 'morrisb', 'parser'))
// console.log(smallestEquivalentString('hello', 'world', 'hold'))
console.log(
  smallestEquivalentString(
    'dfeffdfafbbebbebacbbdfcfdbcacdcbeeffdfebbdebbdafff',
    'adcdfabadbeeafeabbadcefcaabdecabfecffbabbfcdfcaaae',
    'myickvflcpfyqievitqtwvfpsrxigauvlqdtqhpfugguwfcpqv'
  )
)
