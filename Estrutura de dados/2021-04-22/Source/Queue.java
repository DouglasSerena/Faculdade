package Source;

public class Queue {
  private int _size = 0;
  private int _count = -1;
  private String[] _list;

  public void setSize(int size) {
    if (size < this._size) {
      this.destroy();
    }
    this._size = size;
  }

  public Queue(int size) {
    this._list = new String[size];
    this._size = size;
  }

  public int size() {
    return this._size;
  }

  public boolean add(String item) {
    if (isEmpty()) {
      this._list = new String[this._size];
    }
    if (this._count == this._size - 1) {
      this.remove();
    }
    this._count++;
    _list[_count] = item;
    return false;
  }

  public boolean remove() {
    if (isEmpty()) {
      return false;
    } else {
      this._count--;
      for (int index = 0; index <= this._count; index++) {
        this._list[index] = this._list[index + 1];
      }
      return true;
    }
  }

  public void destroy() {
    this._list = null;
    this._count = -1;
  }

  public int locate(String search) {
    for (int index = 0; index <= this._count; index++) {
      if (this._list[index].toLowerCase().equals(search.toLowerCase())) {
        return index;
      }
    }
    return -1;
  }

  public String last() {
    return this._list[this._size];
  }

  public String first() {
    return this._list[0];
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    for (int index = 0; index <= _count; index++) {
      stringBuilder.append(this._list[index]);
      if (index < this._count) {
        stringBuilder.append(", ");
      }
    }
    stringBuilder.append("]");
    return stringBuilder.toString();
  }

  private boolean isEmpty() {
    return this._list == null || this._list.length == 0;
  }
}