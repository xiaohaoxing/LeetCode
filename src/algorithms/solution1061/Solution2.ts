function smallestEquivalentString(
  s1: string,
  s2: string,
  baseStr: string
): string {
  const map = new Map<string, string>()
  for (let i = 0; i < s1.length; i++) {
    const c1 = s1.charAt(i)
    const c2 = s2.charAt(i)
    const t1 = getTail(c1, map)
    const t2 = getTail(c2, map)
    if (t1 < t2) {
      map.set(t2, t1)
    } else if (t1 > t2) {
      map.set(t1, t2)
    }
  }
  // replace
  let result = baseStr
  for (let i = 0; i < baseStr.length; i++) {
    const ch = baseStr.charAt(i)
    if (map.has(ch)) {
      const min = getTail(ch, map)
      result = result.replace(ch, min < ch ? min : ch)
    }
  }
  return result
}

function getTail(key: string, map: Map<string, string>): string {
  let k = key
  while (map.has(k)) {
    k = map.get(k)!
  }
  return k
}

console.log(
    smallestEquivalentString(
      'dfeffdfafbbebbebacbbdfcfdbcacdcbeeffdfebbdebbdafff',
      'adcdfabadbeeafeabbadcefcaabdecabfecffbabbfcdfcaaae',
      'myickvflcpfyqievitqtwvfpsrxigauvlqdtqhpfugguwfcpqv'
    )
  )