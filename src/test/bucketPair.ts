function match(str: string): boolean {
  let stack = new Array();
  for (let i = 0; i < str.length; i++) {
    switch (str.charAt(i)) {
      case "(": {
        stack.push("(");
        break;
      }
      case "[": {
        stack.push("[");
        break;
      }
      case ")": {
        if (stack.length === 0) {
          return false;
        } else {
          let last = stack.pop();
          if (last !== "(") {
            return false;
          }
        }
        break;
      }
      case "]": {
        if (stack.length === 0) {
          return false;
        } else {
          let last = stack.pop();
          if (last !== "[") {
            return false;
          }
        }
        break;
      }
    }
  }
  if (stack.length) {
    return false;
  }
  return true;
}

console.log(match('()(([]))'))
console.log(match('())'))