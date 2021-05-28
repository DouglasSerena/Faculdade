const { countingSort } = require("./counting-sort");

const array = [0,1,2,4,1,2,7,4,12,5,2,7,0,1,8];

const newArray = countingSort(array);

console.log(`Array antes: ${array.join(",")}`);
console.log(`Array depois: ${newArray.join(",")}`);
