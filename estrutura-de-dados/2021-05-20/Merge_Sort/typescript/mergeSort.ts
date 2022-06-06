export function mergeSort(array: number[]) {
  let length = array.length;

  if (length < 2) {
    return;
  }

  let medLength = length / 2;
  let arrayLeft = [];
  let arrayRight = [];

  for (let index = 0; index < medLength; index++) {
    arrayLeft[index] = array[index];
  }
  for (let index = medLength; index < length; index++) {
    arrayRight[index - medLength] = array[index];
  }

  mergeSort(arrayLeft);
  mergeSort(arrayRight);

  return merge(array, arrayLeft, arrayRight);
}

function merge(array: number[], arrayLeft: number[], arrayRight: number[]) {
  let leftLength = arrayLeft.length;
  let rightLength = arrayRight.length;

  let index = 0;
  let indexJ = 0;
  let indexK = 0;

  while (index < leftLength && indexJ < rightLength) {
    if (arrayLeft[index] <= arrayRight[indexJ]) {
      array[indexK] = arrayLeft[index];
      index++;
    } else {
      array[indexK] = arrayRight[indexJ];
      indexJ++;
    }
    indexK++;
  }

  while (index < leftLength) {
    array[indexK] = arrayLeft[index];
    index++;
    indexK++;
  }

  while (indexJ < rightLength) {
    array[indexK] = arrayRight[indexJ];
    indexJ++;
    indexK++;
  }

  return array;
}
