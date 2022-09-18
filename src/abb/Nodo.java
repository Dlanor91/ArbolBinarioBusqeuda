package abb;

public class Nodo {
    private int dato;
    private Nodo izq;
    private Nodo der;

    public Nodo(int unDato) {
        this.dato = unDato;
        this.izq = null;
        this.der = null;
    }

    public Nodo(int unDato, Nodo izq, Nodo der) {
        this.dato = unDato;
        this.izq = izq;
        this.der = der;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

}
