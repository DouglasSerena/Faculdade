import { countingSort } from './counting-sort';

const array = 'ZYXWVUTSRQPONMLKJIHGFEDCBA'.split('');
const newArray = countingSort(array);

console.log(`Array original ${array.join(',')}`);
console.log(`Array organizado ${newArray.join(',')}`);
