export function mergeSort(
  array: number[],
  left?: number,
  middle?: number,
  right?: number
) {
  left = left || 0;
  middle = middle || array.length / 2;
  right = right || array.length;

  // transfere os elementos entre left e right para um array auxiliar.
  let helper = [...array];

  let index = left;
  let indexJ = middle;
  let indexK = left;

  while (index <= middle && indexJ <= right) {
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
  while (index <= middle) {
    array[indexK] = helper[index];
    index++;
    indexK++;
  }

  // se a metade final não foi toda consumida, faz o append.
  while (indexJ <= right) {
    array[indexK] = helper[indexJ];
    indexJ++;
    indexK++;
  }
}
