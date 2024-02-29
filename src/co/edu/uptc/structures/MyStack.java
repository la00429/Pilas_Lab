package co.edu.uptc.structures;

import java.util.Iterator;

public class MyStack<T> {
    private Node<T> head;

    public MyStack() {
        this.head = null;
    }

    public void push(T data) {
        Node<T> node = new Node<T>(data);
        if (isEmpty()) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
    }

    public T pop() {
        T data = head.getValue();
        head = head.getNext();
        return data;
    }

    public T peek() {
        return head.getValue();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void exist(T data) {
        boolean nodeExist = false;
        Node<T> nodeAux = head;
        while (nodeAux != null && nodeExist == false) {
            if (nodeAux.getValue().equals(data)) {
                nodeExist = true;
            }
            nodeAux = nodeAux.getNext();
        }
    }

    public Iterator<T> iterator() {
        Iterator<T> iterator;
        return iterator = new Iterator<T>() {
            // Atributo de la clase anónima;
            Node<T> actual = head;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                T data = actual.getValue();
                actual = actual.getNext();

                return data;
            }

        };
    }

}