from merge_sort import merge_sort


def main():
    array = [7, 15, 19, 21, 5, 9, 11, 90]
    print("Array antes: % s" % list(map(str, array)))
    merge_sort(array)
    print("Array depois: % s" % list(map(str, array)))


main()
