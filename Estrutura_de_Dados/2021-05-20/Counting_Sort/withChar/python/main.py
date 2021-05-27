from counting_sort import counting_sort

def main():
  arr = "ZYXWVUTSRQPONMLKJIHGFEDCBA"
  ans = counting_sort(arr)
  print("Sorted character array is % s" %("".join(ans)))

main()