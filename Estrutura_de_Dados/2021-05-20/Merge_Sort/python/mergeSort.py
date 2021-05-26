def merge_sort(array: list, left: int = None, middle: int = None, right: int = None):
    left = left == None if left else 0
    middle = middle == None if middle else len(array) / 2
    right = right == None if right else len(array)

    helper = array.copy()

    index = int(left)
    indexJ = int(middle)
    indexK = int(left)

    while index < middle and indexJ < right:
        if helper[index] < helper[indexJ]:
            array[indexK] = helper[index]
            index += 1
        else:
            array[indexK] = helper[indexJ]
            indexJ += 1
        indexK += 1

    while index < middle:
        array[indexK] = helper[index]
        index += 1
        indexK += 1

    while indexJ < right:
        array[indexK] = helper[indexJ]
        indexJ += 1
        indexK += 1
