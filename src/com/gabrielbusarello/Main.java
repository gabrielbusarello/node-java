package com.gabrielbusarello;

import com.gabrielbusarellod.DLinkedList;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        SLinkedList<String> list = new SLinkedList<String>();
        list.addFirst("a");
        list.addFirst("b");
        list.addLast("c");
        list.addLast("d");
        System.out.println(list.get(3));
        System.out.println(list.remove(3));
        System.out.println(list.get(2));
        System.out.println("Tamanho: " + list.size());
        System.out.println("Está vazia? " + list.isEmpty());
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        list.clear();

        System.out.println("--------------------------");

        DLinkedList<String> listD = new DLinkedList<String>();
        listD.addFirst("a");
        listD.addFirst("b");
        listD.add(1, "asd");
        listD.addLast("c");
        listD.addLast("d");
        System.out.println(listD.getFirst());
        listD.removeFirst();
        System.out.println(listD.getFirst());
        System.out.println(listD.getLast());
        listD.removeLast();
        System.out.println(listD.getLast());
        System.out.println(listD.contains("c"));
        System.out.println(listD.get(1));
        System.out.println(listD.remove(0));
        System.out.println(listD.size());
        System.out.println(listD.isEmpty());

        SLinkedList<Integer> listSS = new SLinkedList<Integer>();
        Comparator<Integer> comparator = (o1, o2) -> o1 - o2;
        listSS.addSorted(3, comparator);
        listSS.addSorted(5, comparator);
        listSS.addSorted(2, comparator);
        listSS.addSorted(7, comparator);
        System.out.println(Arrays.toString(listSS.toArray()));

        /*Nodo<String> gru = new Nodo<String>();
        gru.setValor("gru");

        Nodo<String> lis = new Nodo<String>();
        lis.setValor("lis");

        Nodo<String> hlr = new Nodo<String>();
        hlr.setValor("hlr");

        gru.setNode(lis);
        lis.setNode(hlr);

        imprimirIterativo(gru);
        System.out.println("---");
        imprimirIterativo(lis);
        System.out.println("---");
        imprimirIterativo(hlr);
        System.out.println("---");
        imprimirIterativo(null);

        System.out.println("-----------------------------");

        imprimirRecursivo(gru);
        System.out.println("---");
        imprimirRecursivo(lis);
        System.out.println("---");
        imprimirRecursivo(hlr);
        System.out.println("---");
        imprimirRecursivo(null);*/
    }

    public static void imprimirIterativo(Nodo nodo) {
        while (nodo != null) {
            System.out.println(nodo.getValor());
            nodo = nodo.getNode();
        }
    }

    public static void imprimirRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.getValor());
            imprimirRecursivo(nodo.getNode());
        }
    }
}
