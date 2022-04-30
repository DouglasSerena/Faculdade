import { countingSort } from "./counting-sort";

const array = [0, 1, 2, 4, 1, 2, 7, 4, 12, 5, 2, 7, 0, 1, 8, 1, 5, 8, 2];
const newArray = countingSort(array);

console.log(`Array original ${array.join(",")}`);
console.log(`Array organizado ${newArray.join(",")}`);
