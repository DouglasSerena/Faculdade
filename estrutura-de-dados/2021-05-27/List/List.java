package List;

public class List<T> {
    private Container<T> containerInit;
    private Container<T> containerEnd;
    boolean notAllowEqualsObject;
    int size;

    public List() {
        this.notAllowEqualsObject = false;
    }

    public List(boolean notAllowEqualsObject) {
        this.notAllowEqualsObject = notAllowEqualsObject;
    }

    public T get(int index) {
        if (this.isEmpty()) {
            return null;
        }

        Container<T> assistant = this.containerInit;

        int count = 0;
        while (assistant != null) {
            if (index == count) {
                return assistant.object;
            }
            assistant = assistant.next;
            count++;
        }
        return null;
    }

    private T _addInit(Container<T> container) {
        if (this.isEmpty()) {
            this.containerInit = container;
            this.containerEnd = this.containerInit;
        } else {
            container.next = this.containerInit;
            this.containerInit = container;
        }
        this.size++;
        return container.object;
    }

    private T _addBetween(Container<T> container, Container<T> assistant) {
        if (this.isEmpty()) {
            return null;
        }
        if (this.notAllowEqualsObject) {
            remove(container.object);
        }
        container.next = assistant.next;
        assistant.next = container;

        this.size++;
        return container.object;
    }

    private T _addEnd(Container<T> container) {
        if (this.notAllowEqualsObject) {
            remove(container.object);
        }
        if (this.isEmpty()) {
            this.containerInit = container;
            this.containerEnd = this.containerInit;
        } else {
            containerEnd.next = container;
            containerEnd = container;
        }

        this.size++;
        return container.object;
    }

    public T add(T object) {
        Container<T> container = new Container<>(object);

        if (this.isEmpty()) {
            return this._addInit(container);
        } else {
            return this._addEnd(container);
        }
    }

    public T add(int index, T object) {
        Container<T> container = new Container<>(object);

        if (this.isEmpty()) {
            return this._addInit(container);
        } else {
            Container<T> assistant = this.containerInit;

            if (index < 0 || index > size) {
                return null;
            }

            if (index == 0) {
                return this._addInit(container);
            }

            if (index == size) {
                return this._addEnd(container);
            }

            for (int _index = 0; _index < size; _index++) {
                if (index - 1 == _index) {
                    return this._addBetween(container, assistant);
                }
                assistant = assistant.next;
            }
        }
        return null;
    }

    public T remove(T object) {
        if (this.isEmpty()) {
            return null;
        }

        Container<T> assistant = this.containerInit;

        while (assistant != null) {
            if (assistant.equals(object)) {
                int index = this.indexOf(object);
                return remove(index);
            }
            assistant = assistant.next;
        }
        return null;
    }

    private T _removeInit(Container<T> container) {
        this.containerInit = container.next;

        this.size--;
        return container.object;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Container<T> assistant = this.containerInit;

        if (index == 0) {
            return this._removeInit(assistant);
        }

        int count = 0;
        while (assistant != null) {
            if (index - 1 == count) {
                Container<T> containerRemove = assistant.next;
                assistant.next = containerRemove.next;
                if (index == size - 1) {
                    this.containerEnd = assistant;
                }

                size--;
                return containerRemove.object;
            }
            assistant = assistant.next;
            count++;
        }
        return null;
    }

    public void clear() {
        this.containerEnd = null;
        this.containerInit = null;
        this.size = 0;
    }

    public int indexOf(T object) {
        Container<T> assistant = this.containerInit;

        int index = 0;
        while (assistant != null) {
            if (assistant.equals(object)) {
                return index;
            }
            assistant = assistant.next;
            index++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return containerInit == null && this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void list() {
        System.out.println(this.toString());
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        Object[] object = new Object[this.size];
        Container<T> assistant = this.containerInit;

        int index = 0;
        while (assistant != null) {
            object[index] = assistant.object;
            assistant = assistant.next;
            index++;
        }
        return (T[]) object;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (!this.isEmpty()) {
            Container<T> assistant = this.containerInit;

            result.append("[ ");
            while (assistant != null) {
                result.append(assistant.object);
                assistant = assistant.next;
                if (assistant != null) {
                    result.append(", ");
                }
            }
            result.append(" ]");
        } else {
            result.append("[]");
        }
        return result.toString();
    }
}
