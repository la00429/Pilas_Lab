package co.edu.uptc.structures;

import java.util.Iterator;

public class SimpleList<E> implements Iterable<E> {
	private Node<E> head;

	public SimpleList() {
		this.head = null;
	}

	public void insert(E data) {
		Node<E> node = new Node<E>(data);
		if (isEmpty()) {
			head = node;
		} else {
			Node<E> nodeAux = head;
			while (nodeAux.getNext() != null) {
				nodeAux = nodeAux.getNext();
			}
			nodeAux.setNext(node);
		}
	}

	public boolean exist(E data) {
		boolean nodeExist = false;
		Node<E> nodeAux = head;
		while (nodeAux != null && nodeExist == false) {
			if (nodeAux.getValue().equals(data)) {
				nodeExist = true;
			}
			nodeAux = nodeAux.getNext();
		}
		return nodeExist;

	}

	public void remove(E data) {
		Node<E> nodeAux = head;
		Node<E> previus = head;
		while (nodeAux != null) {
			if (nodeAux.getValue().equals(data)) {
				removeNodeFound(nodeAux, previus);
			}
			nodeAux = nodeAux.getNext();
		}
	}

	private void removeNodeFound(Node<E> nodeAux, Node<E> previus) {
		Node<E> nodeToRemove = nodeAux;
		if (nodeToRemove == head) {
			head = nodeToRemove.getNext();
		} else {
			previusReference(previus, nodeToRemove);
		}
	}

	private void previusReference(Node<E> previus, Node<E> nodeToRemove) {
		while (previus.getNext() != nodeToRemove) {
			previus = previus.getNext();
		}
		previus.setNext(nodeToRemove.getNext());
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public String show() {
		return this.head.toString();

	}

	@Override
	public Iterator<E> iterator() {
		Iterator<E> iterator;
		return iterator = new Iterator<E>() {
			// Atributo de la clase anónima;
			Node<E> actual = head;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return actual != null;
			}

			@Override
			public E next() {
				E data = actual.getValue();
				actual = actual.getNext();

				return data;
			}

		};
	}
}
