package com.gabrielbusarello;

public class Nodo <T> {
    private T valor;
    private Nodo node;

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo getNode() {
        return node;
    }

    public void setNode(Nodo node) {
        this.node = node;
    }
}
