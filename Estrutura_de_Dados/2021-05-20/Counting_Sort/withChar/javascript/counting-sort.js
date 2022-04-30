function countingSort(array) {
  const size = array.length;

  const output = Array.from({ length: size }, (_, i) => "");
  const count = Array.from({ length: 256 }, (_, i) => 0);

  array.forEach((item) => {
    count[item.charCodeAt(0)] += 1;
  });

  for (var i = 1; i < 256; ++i) {
    count[i] += count[i - 1];
  }


  for (var i = size - 1; i >= 0; i--) {
    output[count[array[i].charCodeAt(0)] - 1] = array[i];
    count[array[i].charCodeAt(0)] -= 1;
  }

  return output;
}

module.exports.countingSort = countingSort;
