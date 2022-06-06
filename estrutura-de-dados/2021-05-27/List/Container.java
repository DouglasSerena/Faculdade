package List;

class Container<T> {
    T object;
    Container<T> next = null;

    Container(T object) {
        this.object = object;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object object) {
        if (object instanceof Container) {
            Container<T> container = (Container<T>) object;
            return this.object.equals(container.object);
        } else {
            return this.object.equals(object);
        }
    }
}
