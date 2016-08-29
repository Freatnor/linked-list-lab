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
        if(node == null){
            head = new Node<T>(obj);
        }
        else {
            while (node.next != null) {
                node = node.getNext();
            }
            node.setNext(new Node<T>(obj));
        }
        size++;
    }

    //The methods below are bonus

    public void add(int index, T obj) {
        //to-do
        Node<T> newNode = new Node<T>(obj);
        if(index < 0 || index > size -1){
            return;
        }
        else if(index == 0){
            newNode.setNext(head);
            head = newNode;
            size++;
        }
        //the case where the index is in the middle or end of the list
        else {
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            size++;
        }
    }

    private void removeHead(){
        head = head.getNext();
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new MyIterator<T>(head);
    }

    private class MyIterator<T> implements Iterator<T> {

        private Node<T> node;
        private Node<T> previous;
        private Node<T> next;

        public MyIterator(Node<T> node) {
            //to-do
            this.next = node;
        }

        @Override
        public boolean hasNext() {
            if(next != null){
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
            if(node != null) {
                previous = node;
            }
            node = next;
            next = node.getNext();
            return (T)node.getData();
        }

        @Override
        public void remove() {
            // TODO Auto-generated method stub
            if(node == null)
                throw new IllegalStateException();
            if(previous == null){
                removeHead();
                node = null;
            }
            //possible issue if you remove, next, and then remove again
            else {
                previous.setNext(next);
                node = null;
            }
        }

    }
}
