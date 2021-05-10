from Queue import Queue


def main():
    queue = Queue(10)
    queue.add("Douglas")
    queue.add("Schneider")
    queue.add("Serena")
    
    print(queue.showFull())
    print(queue.show())


main()
