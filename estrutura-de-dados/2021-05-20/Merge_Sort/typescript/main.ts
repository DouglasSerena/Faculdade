import { mergeSort } from "./mergeSort";

const array = [ 15, 12, 67, 7, 15, 19, 21, 12, 55, 5, 9, 11, 90];

console.log("Array antes: " + array.join(","));

mergeSort(array);

console.log("Array depois: " + array.join(","));
