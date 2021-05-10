class Queue:
    _list = []
    _count = 0
    _size = 10

    def __init__(self, size=10):
        self._size = size
        for item in range(size):
            self._list.append("")

    def add(self, item):
        if self._count < self._size:
            self._list[self._count] = item
            self._count += 1
        else:
            print("Lista esta cheia.")

    def remove(self):
        if self._count > 0:
            for index in range(self._size - 1):
                self._list[index] = self._list[index + 1]
            self._count -= 1
        else:
            print("Lista esta fazia.")

    def showFull(self):
        return self._list.__str__()

    def show(self):
        return self.showFull().replace(", ''", '')

    def __str__(self):
        return self.show()
