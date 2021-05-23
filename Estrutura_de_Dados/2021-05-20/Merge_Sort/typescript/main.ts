import { mergeSort } from './mergeSort';

const array = [7, 15, 19, 21, 5, 9, 11, 90];

console.log('Array antes: ' + array.join(','));

mergeSort(array);

console.log('Array depois: ' + array.join(','));
