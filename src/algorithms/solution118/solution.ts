function generate(numRows: number): number[][] {
    let current = [1]
    const result = new Array(current)
    let row = 1
    while(row < numRows) {
        row = row + 1
        let nextRow = new Array(row)
        nextRow[0] = 1
        nextRow[row - 1] = 1
        for(let i = 1; i < row - 1; i++) {
            nextRow[i] = current[i-1] + current[i]
        }
        result.push(nextRow)
        current = nextRow
    }
    return result
};

console.log(JSON.stringify(generate(1)))
console.log(JSON.stringify(generate(2)))
console.log(JSON.stringify(generate(3)))
console.log(JSON.stringify(generate(4)))
console.log(JSON.stringify(generate(5)))