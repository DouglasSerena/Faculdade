const { countingSort } = require("./counting-sort");

const array = "ZYXWVUTSRQPONMLKJIHGFEDCBA".split("");
const newArray = countingSort(array);

console.log(`Array antes: ${array.join(",")}`);
console.log(`Array depois: ${newArray.join(",")}`);
