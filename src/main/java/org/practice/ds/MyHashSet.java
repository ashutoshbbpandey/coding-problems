package org.practice.ds;

import java.util.LinkedList;
import java.util.List;

public class MyHashSet {

    private static final int MAX_VALUE = 1000000;
    private static final int BUCKET_SIZE = 100;
    private List<Integer>[] buckets;
    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = new LinkedList[BUCKET_SIZE];
    }

    public void add(int key) {
        if(contains(key)){
            return;
        }
        int bucketIndex = hash(key);
        List<Integer> bucket = buckets[bucketIndex];
        if(bucket != null){
            bucket.add(key);
        }else {
            bucket = new LinkedList<>();
            bucket.add(key);
            buckets[bucketIndex]= bucket;
        }
    }

    public void remove(Integer key) {
        int bucketIndex = hash(key);
        if(!contains(key)){
            return;
        }else{
            buckets[bucketIndex].remove(key);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if (key > MAX_VALUE){
            return false;
        }
        int bucketIndex = hash(key);
        List<Integer> bucket = buckets[bucketIndex];
        if(bucket == null){
            return false;
        }
        return bucket.contains(key);
    }

    private int hash(int key){
        return (key % BUCKET_SIZE)-1;
    }
}
