package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {

    private Object[] elements = {0};
    private int size = 0;


    @Override
    public ImmutableList add(Object e) {
        return add(this.size, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] singleElList = {e};
        return addAll(index, singleElList);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(this.size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        ImmutableArrayList new_array = new ImmutableArrayList();

        Object new_elements[] = new Object[size + c.length];
        System.arraycopy(this.elements, 0, new_elements, 0, index);
        System.arraycopy(c, 0, new_elements, index, c.length);
        System.arraycopy(this.elements, index, new_elements, index + c.length, this.size - index);

        new_array.size = this.size + c.length;
        new_array.elements = new_elements;
        return new_array;

    }

    @Override
    public Object get(int index) {
        if (index < 0 | index > size){
            throw new IllegalArgumentException();
        }
        return elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index < 0 | index > size){
            throw new IllegalArgumentException();
        }
        ImmutableArrayList new_array = new ImmutableArrayList();
        Object[] new_elements = elements;
        System.arraycopy(new_elements, index + 1, new_elements, index, size - 1 - index);
        new_array.elements = new_elements;
        new_array.size = size - 1;
        return new_array;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < 0 | index > size){
            throw new IllegalArgumentException();
        }
        ImmutableArrayList new_array = new ImmutableArrayList();
        new_array.elements = elements;
        new_array.elements[index] = e;
        new_array.size = size;
        return new_array;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return elements;
    }

}
