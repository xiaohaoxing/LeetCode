func modifyString(s string) string {
    result := []rune(s)
    for i := 0; i < len(result); i++ {
        if result[i] == '?' {
            for c := 'a'; c <= 'z'; c++ {
                if (i == 0 || result[i-1] != c) && (i == len(result)-1 || result[i+1] != c) {
                    result[i] = c
                    break
                }
            }
        }
    }
    return string(result)
}