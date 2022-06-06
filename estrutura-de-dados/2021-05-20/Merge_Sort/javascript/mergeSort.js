function mergeSort(
  array,
  left = undefined,
  middle = undefined,
  right = undefined
) {
  left = left || 0; // 0
  middle = middle || array.length / 2; // 4
  right = right || array.length; // 8

  // transfere os elementos entre left e right para um array auxiliar.
  let helper = [...array]; // [7, 15, 19, 21, 5, 9, 11, 90]

  let index = left; // 0
  let indexJ = middle; // 4
  let indexK = left; // 0

  while (index < middle && indexJ < right) {
    if (helper[index] < helper[indexJ]) {
      array[indexK] = helper[index];
      index++;
    } else {
      array[indexK] = helper[indexJ];
      indexJ++;
    }
    indexK++;
  }

  // se a metade inicial não foi toda consumida, faz o append.
  while (index < middle) {
    array[indexK] = helper[index];
    index++;
    indexK++;
  }

  // se a metade final não foi toda consumida, faz o append.
  while (indexJ < right) {
    array[indexK] = helper[indexJ];
    indexJ++;
    indexK++;
  }
}

module.exports.mergeSort = mergeSort;
