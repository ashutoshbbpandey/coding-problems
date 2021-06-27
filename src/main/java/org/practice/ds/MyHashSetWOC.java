package org.practice.ds;

public class MyHashSetWOC {

    class Node<T>{
        T val;
        Node<T> next;

        Node(){
            this(null, null);
        }

        Node(T val){
            this(val, null);
        }

        Node(T val, Node<T> next){
            this.val = val;
            this.next = next;
        }
    }

    private final static int MAX_VALUE = 100000;

    private final int BUCKET_SIZE;

    Node<Integer>[] buckets;

    public MyHashSetWOC(){
        this(100);
    }

    MyHashSetWOC(int size){
        this.BUCKET_SIZE = size;
        this.buckets = new Node[BUCKET_SIZE];
    }

    public void add(Integer key){
        int bucketIndex = hash(key);
        Node bucket = buckets[bucketIndex];
        if(bucket==null){
            bucket = new Node(key);
            bucket.next = buckets[bucketIndex];
            buckets[bucketIndex] = bucket;
            return;
        }

        while(bucket != null && !bucket.val.equals(key)){
            bucket = bucket.next;
        }

        if(bucket != null){
            return;
        }

        Node newHead = new Node(key);
        newHead.next = buckets[bucketIndex];
        buckets[bucketIndex] = newHead;
    }

    public void remove(int key){
        int bucketIndex = hash(key);
        Node bucket = buckets[bucketIndex];
        if(bucket == null){
            return;
        }

        while(bucket != null && !bucket.val.equals(key)){
            bucket = bucket.next;
        }

        if(bucket.next == null){
            return;
        }

        bucket.next = bucket.next.next;
    }

    public boolean contains(int key){
        int bucketIndex = hash(key);
        Node bucket = buckets[bucketIndex];
        if(bucket == null) {
            return false;
        }
        while (bucket != null && !bucket.val.equals(key)){
            bucket = bucket.next;
        }

        return bucket!=null;
    }

    public int hash(int key){
        return key % BUCKET_SIZE;
    }
}
