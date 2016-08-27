package com.company.freatnor;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public boolean remove(int index) {
        if (index > size - 1 || index < 0) {
            return false;
        }
        else if (index == 0) {
            head = head.getNext();
            size--;
        }
        else {
            size--;
        }
        return true;
    }

    public T get(int index) {
        //to-do
        if(index < 0 || index > size -1){
            return null;
        }
        Node<T> currentNode = head;
        for (int i = 0; i < index + 1; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    public void add(T obj) {
        //to-do
        Node<T> node = head;
        while(node.getNext() != null){
            node = node.getNext();
        }
        node.setNext(new Node<T>(obj));
        size++;
    }

    //The methods below are bonus

    public void add(int index, T obj) {
        //to-do
        size++;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new MyIterator<T>(head);
    }

    private class MyIterator<T> implements Iterator<T> {

        private Node<T> node;
        private Node<T> previous;

        public MyIterator(Node<T> node) {
            //to-do
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            if(node.getNext() != null){
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public T next() {
            //to-do
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            previous = node;
            node = node.getNext();
            return previous.getData();
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub

        }

    }
}
