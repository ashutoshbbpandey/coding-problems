package org.practice;

import org.practice.ds.MyHashSetWOC;

public class Application {

    public static void main(String[] args) {
        MyHashSetWOC myHashSet = new MyHashSetWOC();

        myHashSet.add(1);
        System.out.println(myHashSet.contains(1));
        myHashSet.remove(1);
        System.out.println(myHashSet.contains(1));
    }
}
