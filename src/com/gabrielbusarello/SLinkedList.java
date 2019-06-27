package com.gabrielbusarello;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class SLinkedList<T> {
    protected Nodo<T> head;
    protected Nodo<T> tail;
    protected long size;

    public SLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Verifica o tamanho da lista
     * @return o tamanho da lista
     */
    public long size() {
        return size;
    }

    /**
     * Verifica se a lista está vazia
     * @return true, se estiver vazia. Caso contrário, false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Remove todos os elementos da lista
     */
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Retorna o primeiro elemento da lista
     * @return O primeiro elemento da lista
     * @throws NoSuchElementException Se a lista estiver vazia
     */
    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return head.getValor();
    }

    /**
     * Retorna o último elemento da lista
     * @return O último elemento da lista
     * @throws NoSuchElementException Se a lista estiver vazia
     */
    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return tail.getValor();
    }

    /**
     * Adiciona um elemento na cabeça da lista
     * @param value
     */
    public void addFirst(T value) {
        Nodo<T> first = new Nodo<T>();
        first.setValor(value);
        first.setNode(head);
        if (head == null) {
            tail = first;
        }
        head = first;
        size++;
    }

    /**
     * Adiciona um elemento na cauda da lista
     * @param value
     */
    public void addLast(T value) {
        if (head == null) {
            addFirst(value);
        } else {
            Nodo<T> last = new Nodo<T>();
            last.setValor(value);
            tail.setNode(last);
            tail = last;
            size++;
        }
    }

    /**
     * Remove e retorna o primeiro elemento da lista
     * @return value
     * @throws NoSuchElementException Se a lista estiver vazia
     */
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        T value = head.getValor();
        head = head.getNode();
        size--;
        return value;
    }

    /**
     * Remove e retorna o último elemento da lista
     * @return value
     * @throws NoSuchElementException Se a lista estiver vazia
     */
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        T value = tail.getValor();
        Nodo<T> temp = head;
        // Verifica se possui o próximo elemento
        // E verifica se o próximo elemento não é a cauda
        while (temp.getNode() != null && temp.getNode() != tail) {
            temp = temp.getNode();
        }
        // Último elemento aponta para nulo
        temp.setNode(null);
        // Penúltimo elemento, se torna o último elemento
        tail = temp;
        size--;
        return value;
    }

    /**
     * Verifica se a lista contém o valor
     * @param value
     * @return true se o elemento estiver na lista, caso contrário, false
     */
    public boolean contains(T value) {
        Nodo<T> temp = head;

        while(temp != null) {
            if (temp.getValor().equals(value)) {
                return true;
            }
            temp = temp.getNode();
        }
        return false;
    }

    /**
     * Retorna uma lista de objetos com todos os elementos da lista
     * @return
     */
    public Object[] toArray() {
        Object[] array = new Object[(int) size];
        Nodo<T> temp = head;
        for (int i = 0; i < size; i++) {
            array[i] = temp.getValor();
            temp = temp.getNode();
        }
        return array;
    }

    // public get(index: int): T - Retorna o elemento na posição index
    // public remove(index: int): T - Remove e retorna o elemento da posição index
    // public add(index: int, value: T): void - Retorna o elemento na posição index
    // public set(index: int, value: T): void - Atualiza o elemento da posição index

    /**
     * Retorna o elemento na posição index
     * @param index
     * @return value
     * @throws IndexOutOfBoundsException Se a lista estiver vazia
     */
    public T get(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index);
        Nodo<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNode();
        }
        return temp.getValor();
    }

    /**
     * Remove o elemento da posiçao index e remove da lista
     * @param index
     * @return elemento da posicao index
     * @throws IndexOutOfBoundsException (index >= size  || index < 0)
     */
    public T remove(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index);
        Nodo<T> temp = head;
        Nodo<T> before = null;
        for(int i = 0; i < index; i++) {
            before = temp;
            temp = temp.getNode();
        }
        if(before == null) {
            head = temp.getNode();
        }else {
            before.setNode(temp.getNode());
            if(temp == tail) {
                tail = before;
            }
        }
        size--;
        return temp.getValor();
    }

    /**
     * Adiciona um novo elemento na posicao index
     * @param index
     * @param value
     * @throws IndexOutOfBoundsException (index < 0 || index > size())
     */
    public void add(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index);
        Nodo<T> temp = head;
        Nodo<T> before = null;
        for(int i = 0; i < index; i++) {
            before = temp;
            temp = temp.getNode();
        }
        Nodo<T> newNodo = new Nodo<T>();
        newNodo.setValor(value);
        newNodo.setNode(temp);
        if(before == null) {
            head = newNodo;
        }else {
            before.setNode(newNodo);
            if(temp == tail) {
                tail = newNodo;
            }
        }
        size++;
    }

    /**
     * Adiciona um novo elemento na posicao index sorted
     * @param value
     * @throws IndexOutOfBoundsException (index < 0 || index > size())
     */
    public void addSorted(T value, Comparator comparator) {
        Nodo<T> temp = head;
        int i = 0;
        for (i = 0; i < size; i++) {
            if (comparator.compare(temp.getValor(), value) > 0) {
                break;
            }
            temp = temp.getNode();
        }
        add(i, value);
    }

    /**
     * Atualiza o elemento da posiçao index
     * @param index
     * @throws IndexOutOfBoundsException
     */
    public void set(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index);
        Nodo<T> temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.getNode();
        }
        temp.setValor(value);
    }

}
