from counting_sort import counting_sort

def main():
  array = [0,1,2,4,1,2,7,4,12,5,2,7,0,1,8]
  newArray = counting_sort(array)
  print("Array original   % s" % list(map(str, array)))
  print("Array organizado % s" % list(map(str, newArray)))

main()