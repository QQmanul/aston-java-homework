package homework1.structures;

import static java.util.Objects.hash;

public class MyHashSet<T> implements MySet<T> {
    private static final int DEFAULT_BUCKETS_COUNT = 8;
    private static final double scale = 2;

    private int bucketsCount = DEFAULT_BUCKETS_COUNT;
    private int elementCount = 0;
    private MyLinkedList<T>[] buckets = new MyLinkedList[DEFAULT_BUCKETS_COUNT];

    public MyHashSet() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new MyLinkedList<>();
        }
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public void remove(T value) {
        int bucketIdx = hash(value) % bucketsCount;
        MyLinkedList<T> bucket = buckets[bucketIdx];

        if (bucket.remove(value))
            elementCount--;
    }

    @Override
    public boolean contains(T value) {
        int bucketIdx = hash(value) % bucketsCount;
        MyLinkedList<T> bucket = buckets[bucketIdx];

        return bucket.contains(value);
    }

    @Override
    public void add(T value) {
        if (!contains(value)) {
            if (elementCount == bucketsCount) {
                resizeBuckets();
            }

            int bucketIdx = value.hashCode() % bucketsCount;
            buckets[bucketIdx].add(value);
            elementCount++;
        }
    }

    private void resizeBuckets() {
        int newBucketsCount = (int) (bucketsCount * scale);

        MyLinkedList<T>[] newBuckets = new MyLinkedList[newBucketsCount];
        for (int i = 0; i < newBucketsCount; i++) {
            newBuckets[i] = new MyLinkedList<>();
        }

        for (MyLinkedList<T> bucket : buckets) {
            Item<T> item = bucket.getFirstItem();

            while (item != null) {
                int bucketIdx = item.getValue().hashCode() % newBucketsCount;
                newBuckets[bucketIdx].addItem(item);
                item = item.getNextItem();
            }
        }

        bucketsCount = newBucketsCount;
        buckets = newBuckets;
    }
}
