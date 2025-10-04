package homework1.structures;

public interface MyList<T> {

    void add(T value);

    void addAll(T[] values);

    boolean remove(T value);

    boolean contains(T value);

    Item<T> get(T value);

    int getListCount();
}
